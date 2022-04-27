package me.karunarathne.learningspringboot.dao;

import me.karunarathne.learningspringboot.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class FakeDataDao implements UserDao {
    private static Map <UUID, User> database ;

    static {
        database = new HashMap <> () ;
        UUID userUid = UUID.randomUUID() ;
        database.put (userUid, new User
                (userUid, "Joe", "Jones", User.Gender.MALE, 22, "joe@gmail.com")
        );
    }

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
