package com.tiamat.fino.controllers;

import com.tiamat.fino.dtos.users.AddUserDto;
import com.tiamat.fino.dtos.users.UserDto;
import com.tiamat.fino.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService service;

    public UserController(@Autowired UserService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody AddUserDto addUserDto) {
        return this.service.createUser(addUserDto);
    }

    @GetMapping(path = "/{id}")
    public UserDto getUser(@PathVariable String id) {
        return service.getUser(id);
    }
}
