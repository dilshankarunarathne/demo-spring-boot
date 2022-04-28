package me.karunarathne.learningspringboot.resource;

import me.karunarathne.learningspringboot.model.User;
import me.karunarathne.learningspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserResource {
    private UserService userService ;

    @Autowired
    public UserResource (UserService userService) {
        this.userService = userService ;
    }

    public List<User> 
}
