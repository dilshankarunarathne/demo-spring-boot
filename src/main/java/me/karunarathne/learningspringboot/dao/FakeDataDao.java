package me.karunarathne.learningspringboot.dao;

import me.karunarathne.learningspringboot.model.User;

import java.util.List;
import java.util.UUID;

public class FakeDataDao implements UserDao {
    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUser(UUID userUd) {
        return null;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int removeUser(UUID userUid) {
        return 0;
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }
}
