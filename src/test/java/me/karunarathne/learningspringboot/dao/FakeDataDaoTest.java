package me.karunarathne.learningspringboot.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FakeDataDaoTest {
    private FakeDataDao fakeDataDao ;

    @BeforeEach
    void setUp() {
        fakeDataDao = new FakeDataDao() ;
    }

    @Test
    void shouldSelectAllUsers() throws Exception {
    }

    @Test
    void selectUserByUserUid() throws Exception {
    }

    @Test
    void updateUser() throws Exception {
    }

    @Test
    void deleteUserByUserUid() throws Exception {
    }

    @Test
    void insertUser() throws Exception {
    }
}