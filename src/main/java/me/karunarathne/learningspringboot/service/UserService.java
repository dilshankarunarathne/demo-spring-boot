package me.karunarathne.learningspringboot.service;

import me.karunarathne.learningspringboot.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {
    public List<User> getAllUsers() {
        return new ArrayList<>(database.values());
    }

    public User getUser(UUID userUid) {
        return database.get(userUid);
    }

    public int updateUser(User user) {
        database.put(user.getUserUid(), user) ;
        return 1;
    }

    public int removeUser(UUID userUid) {
        database.remove(userUid) ;
        return 1;
    }

    public int insertUser(UUID userUid, User user) {
        database.put(userUid, user) ;
        return 1;
    }
}
