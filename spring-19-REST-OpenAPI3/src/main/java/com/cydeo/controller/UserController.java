package com.cydeo.controller;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User", description = "User CRUD Operations")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    @Operation(summary = "Read all users") // add summary
    // send more than one API responses
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved users (OK)",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Something went wrong (Bad Request)",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content)
    }) // to send response body empty, leave alone the @Content annotation
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @Operation(summary = "Create a user")
    // send only one API response
    @ApiResponse(responseCode = "201", description = "User created successfully (CREATED)",
            content = {@Content(mediaType = "application/xml"), @Content(mediaType = "application/json")},
            headers = {@Header(name = "Connection", description = "keep-alive")})
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userDTO));
    }

}
/*
Jackson does serialization and deserialization in our app but Jackson works with JSON
We can use Jackson again to do serialization and deserialization for other formats too.
First, we need to add the dependency related with the format, for example:
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
    <version>2.14.0</version>
</dependency>
and then specify it right next http methods.
consumes -> means that controller is able to accept request in xml and json format
produces -> means that responses can be either xml or json format
 */
