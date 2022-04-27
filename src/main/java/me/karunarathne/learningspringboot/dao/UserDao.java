package me.karunarathne.learningspringboot.dao;

import me.karunarathne.learningspringboot.model.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    List<User> selectAllUsers();

    User selectUserByUserUid(UUID userUd);

    int updateUser(User user);

    int deleteUserByUserUid(UUID userUid);

    int insertUser(UUID userUid, User user);
}
