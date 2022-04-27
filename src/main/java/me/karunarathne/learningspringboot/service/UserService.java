package me.karunarathne.learningspringboot.service;

import me.karunarathne.learningspringboot.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {
    public List<User> getAllUsers() {
        return null ;
    }

    public User getUser(UUID userUid) {
        return null ;
    }

    public int updateUser(User user) {
        return 1;
    }

    public int removeUser(UUID userUid) {
        return 1;
    }

    public int insertUser(UUID userUid, User user) {
        database.put(userUid, user) ;
        return 1;
    }
}
