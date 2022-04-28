package me.karunarathne.learningspringboot.resource;

import me.karunarathne.learningspringboot.model.User;
import me.karunarathne.learningspringboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;
import java.util.Optional;

@Component
@Path("api/v1/users")
public class UserResourceResteasy {
    private UserService userService ;

    @Autowired
    public UserResourceResteasy(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Produces (APPLICATION_JSON)
    public List<User> fetchUsers (@QueryParam("gender") String gender) {
        return userService.getAllUsers(Optional.ofNullable(gender)) ;
    }
}
