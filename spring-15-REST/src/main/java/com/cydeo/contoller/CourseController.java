package com.cydeo.contoller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // = @Controller + @ResponseBody (you need to add the @ResponseBody for each endpoint)
@RequestMapping("/courses/api/v1")
public class CourseController { // API controller

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getCourses();
    }

    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") long courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping("category/{name}")
    public List<CourseDTO> getCoursesByCategory(@PathVariable("name") String categoryName) {
        return courseService.getCoursesByCategory(categoryName);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course) { // need to provide the object
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") long courseId, @RequestBody CourseDTO course) {
        courseService.updateCourse(courseId,course);
    }

    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id") long courseId) {
        courseService.deleteCourseById(courseId);
    }

}
