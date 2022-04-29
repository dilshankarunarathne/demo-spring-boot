package me.karunarathne.learningspringboot.resource;

import me.karunarathne.learningspringboot.model.User;
import me.karunarathne.learningspringboot.service.UserService;

import org.checkerframework.checker.nullness.Opt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@RestController
//@RequestMapping (
//        path = "/api/v1/users"
//)
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
    public Response fetchUser (@PathVariable ("userUid") UUID userUid) {
        Optional <User> userOptional = userService.getUser (userUid) ;
        if (userOptional.isPresent()) {
            return Response.ok(userOptional.get()).build() ;
        }
        return Response.status (Response.Status.NOT_FOUND)
                .entity (new ErrorMessage ("user " + userUid + " was not found !"))
        return userService.getUser(userUid)
                .<ResponseEntity <?>> map(ResponseEntity::ok)
                .orElseGet (
                        () -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body (
                            new ErrorMessage ("user " + userUid + " was not found !")
                        )
                ) ;
    }

    @POST
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public ResponseEntity <Integer> insertNewUser (@RequestBody User user) {
        int result = userService.insertUser (user) ;
        return getIntegerResponseEntity (result) ;
    }

    @PUT
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public ResponseEntity <Integer> updateUser (@RequestBody User user) {
        int result = userService.updateUser (user) ;
        return getIntegerResponseEntity (result) ;
    }

    @DELETE
    @Produces (MediaType.APPLICATION_JSON)
    @Path ("{userUid}")
    public ResponseEntity <Integer> deleteUser (@PathVariable ("userUid") UUID userUid) {
        int result = userService.removeUser (userUid) ;
        return getIntegerResponseEntity (result) ;
    }

    private ResponseEntity<Integer> getIntegerResponseEntity (int result) {
        if (result == 1) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    class ErrorMessage {
        String errorMessage ;

        public ErrorMessage(String message) {
            this.errorMessage = message;
        }

        public String getMessage() {
            return errorMessage;
        }

        public void setMessage(String message) {
            this.errorMessage = message;
        }
    }
}
