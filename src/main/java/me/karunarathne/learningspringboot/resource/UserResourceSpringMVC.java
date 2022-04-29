package me.karunarathne.learningspringboot.resource;

import me.karunarathne.learningspringboot.model.User;
import me.karunarathne.learningspringboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserResourceSpringMVC {
    private UserService userService ;

    @Autowired
    public UserResourceSpringMVC(UserService userService) {
        this.userService = userService ;
    }

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public List<User> fetchUsers ( @QueryParam("gender") String gender) {
        return userService.getAllUsers(Optional.ofNullable(gender)) ;
    }

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    @Path ("{userUid}")
    public Response fetchUser (@PathParam("userUid") UUID userUid) {
        Optional <User> userOptional = userService.getUser (userUid) ;
        if (userOptional.isPresent()) {
            return Response.ok(userOptional.get()).build() ;
        }
        return Response.status (Response.Status.NOT_FOUND)
                .entity (new ErrorMessage ("user " + userUid + " was not found !"))
                .build() ;
    }

    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Response insertNewUser (User user) {
        int result = userService.insertUser (user) ;
        return getIntegerResponseEntity (result) ;
    }

    @PUT
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Response updateUser (User user) {
        int result = userService.updateUser (user) ;
        return getIntegerResponseEntity (result) ;
    }

    @DELETE
    @Produces (MediaType.APPLICATION_JSON)
    @Path ("{userUid}")
    public Response deleteUser (@PathParam ("userUid") UUID userUid) {
        int result = userService.removeUser (userUid) ;
        return getIntegerResponseEntity (result) ;
    }

    private Response getIntegerResponseEntity (int result) {
        if (result == 1) {
            return Response.ok().build() ;
        }
        return Response.status(result).build() ;
    }

    
}
