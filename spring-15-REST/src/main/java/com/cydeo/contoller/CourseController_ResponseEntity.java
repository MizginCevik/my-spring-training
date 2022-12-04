package com.cydeo.contoller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity { // manipulating responses

    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    // ResponseEntity is provided by Spring, used to pass header, to modify API responses we are sending
    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version","Cydeo.V2")
                .header("Operation","Get List")
                .body(courseService.getCourses());
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long courseId) {
        return ResponseEntity.ok(courseService.getCourseById(courseId)); // ok -> returns 200 as status code and accepts body
    }

    @GetMapping("category/{name}")
    public ResponseEntity<List<CourseDTO>> getCourseByCategory(@PathVariable("name") String category) {
        return ResponseEntity.ok(courseService.getCoursesByCategory(category));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation","Create")
                .body(courseService.createCourse(course));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable("id") Long courseId) { // it can return ResponseEntity<CourseDTO>
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable("id") Long courseId, @RequestBody CourseDTO course) {
        courseService.updateCourse(courseId,course);
        return ResponseEntity.noContent().build();
    }

}
