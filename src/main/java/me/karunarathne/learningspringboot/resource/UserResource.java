package me.karunarathne.learningspringboot.resource;

import me.karunarathne.learningspringboot.model.User;
import me.karunarathne.learningspringboot.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
