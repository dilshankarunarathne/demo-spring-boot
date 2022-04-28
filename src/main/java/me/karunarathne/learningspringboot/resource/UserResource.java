package me.karunarathne.learningspringboot.resource;

import me.karunarathne.learningspringboot.model.User;
import me.karunarathne.learningspringboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {
    private UserService userService ;

    @Autowired
    public UserResource (UserService userService) {
        this.userService = userService ;
    }

    public List<User> fetchUsers () {
        return userService.getAllUsers() ;
    }
}
