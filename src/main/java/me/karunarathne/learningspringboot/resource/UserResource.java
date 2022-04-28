package me.karunarathne.learningspringboot.resource;

import me.karunarathne.learningspringboot.model.User;
import me.karunarathne.learningspringboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
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
            method = RequestMethod.GET
    )
    public List<User> fetchUsers (
                @QueryParam ("gender") String gender, @QueryParam ("ageLessThan") Integer ageLessThan
            ) {
        System.out.println (gender) ;
        System.out.println () ;
        return userService.getAllUsers() ;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{userUid}"
    )
    public ResponseEntity <?> fetchUser (@PathVariable ("userUid") UUID userUid) {
        return userService.getUser(userUid)
                .<ResponseEntity <?>> map(ResponseEntity::ok)
                .orElseGet (
                        () -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body (
                            new ErrorMessage ("user " + userUid + " was not found !")
                        )
                ) ;
    }

    @RequestMapping (
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity <Integer> insertNewUser (@RequestBody User user) {
        int result = userService.insertUser (user) ;
        return getIntegerResponseEntity (result) ;
    }

    @RequestMapping (
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity <Integer> updateUser (@RequestBody User user) {
        int result = userService.updateUser (user) ;
        return getIntegerResponseEntity (result) ;
    }

    @RequestMapping (
            method = RequestMethod.DELETE,
            path = "{userUid}"
    )
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
