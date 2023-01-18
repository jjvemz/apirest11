package com.demo.apirest.controller;

import com.demo.apirest.model.Users;
import com.demo.apirest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path ="/api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/api/v1/user")
    private ResponseEntity<Users> createUser(@RequestBody Users users){
        Users temp = userService.createUser(users);

        try{
            return ResponseEntity.created(new URI("api/v1/user"+ temp.getId())).body(temp);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/api/v1/user")
    private ResponseEntity<List<Users>> ListAllUsers(@RequestBody Users users){

        return  ResponseEntity.ok(userService.getAllUsers());
    }
    @DeleteMapping("/api/v1/user")
    private ResponseEntity<Void> DeleteUser(@RequestBody Users users){
        userService.deleteUser(users);
        return  ResponseEntity.ok().build();
    }

    @PutMapping("/api/v1/user/{id}")
    private ResponseEntity<Void> PutUser(@PathVariable Long id , @RequestBody Users users){
        userService.updateUser(id, users);
        return  ResponseEntity.ok().build();
    }

    @GetMapping("/api/v1/user/{id}")
    private ResponseEntity<Optional<Users>> GetUser(@PathVariable ("id") Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

}
