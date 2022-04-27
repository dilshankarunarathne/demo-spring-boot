package me.karunarathne.learningspringboot.dao;

import me.karunarathne.learningspringboot.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    List<User> selectAllUsers();

    User getUser(UUID userUd);

    int updateUser(User user);

    int removeUser(UUID userUid);

    int insertUser(UUID userUid, User user);
}
