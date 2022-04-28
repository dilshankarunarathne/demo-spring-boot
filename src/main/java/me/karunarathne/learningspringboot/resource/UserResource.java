package me.karunarathne.learningspringboot.resource;

import me.karunarathne.learningspringboot.model.User;
import me.karunarathne.learningspringboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping (
        path = "/api/v1/users"
)
public class UserResource {
    private UserService userService ;

    @Autowired
    public UserResource (UserService userService) {
        this.userService = userService ;
    }

    @RequestMapping (
            method = RequestMethod.GET,
            path = "hello"
    )
    public List<User> fetchUsers () {
        return userService.getAllUsers() ;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{userUid}"
    )
    public User fetchUser (@PathVariable ("userUid") UUID userUid) {
        return userService.getUser () ;
    }
}
