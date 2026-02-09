package com.proje.FilmWatchlist.controller;

import com.proje.FilmWatchlist.entity.User;
import com.proje.FilmWatchlist.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
        @Autowired
        private UserServiceImpl userService;

        @PostMapping(path = "/create")
        public User createUser(@RequestParam String username){
            return userService.createUser(username);
        }

        @GetMapping(path = "/get")
         public List<User> getAllUsers(){
            return userService.getAllUsers();
        }

        @GetMapping(path = "/get/{id}")
        public User getUserById(@PathVariable Long id){
            return userService.getUserById(id);
        }
}
