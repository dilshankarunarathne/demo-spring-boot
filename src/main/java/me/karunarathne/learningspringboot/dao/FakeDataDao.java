package me.karunarathne.learningspringboot.dao;

import me.karunarathne.learningspringboot.model.User;

import java.util.*;

public class FakeDataDao implements UserDao {
    private static Map <UUID, User> database ;

    static {
        database = new HashMap <> () ;
        UUID joeUserUid = UUID.randomUUID() ;
        database.put (
                joeUserUid,
                new User
                (joeUserUid, "Joe", "Jones", User.Gender.MALE, 22, "joe@gmail.com")
        );
    }

    @Override
    public List<User> selectAllUsers() {
        return new ArrayList<>(database.values());
    }

    @Override
    public User getUser(UUID userUid) {
        return database.get(userUid);
    }

    @Override
    public int updateUser(User user) {
        database.put(user.getUserUid(), user) ;
        return 1;
    }

    @Override
    public int removeUser(UUID userUid) {
        database.remove(userUid) ;
        return 1;
    }

    @Override
    public int insertUser(UUID userUid, User user) {
        database.put(userUid, user) ;
        return 1;
    }
}
