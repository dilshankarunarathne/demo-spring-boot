package me.karunarathne.learningspringboot.dao;

import me.karunarathne.learningspringboot.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

class FakeDataDaoTest {
    private FakeDataDao fakeDataDao ;

    @BeforeEach
    void setUp() {
        fakeDataDao = new FakeDataDao() ;
    }

    @Test
    void shouldSelectAllUsers() throws Exception {
        List<User> users = fakeDataDao.selectAllUsers();
        assertThat(users).hasSize(1) ;

        User user = users.get(0) ;

        assertThat(user.getAge()).isEqualTo(22) ;
        assertThat(user.getFirstName()).isEqualTo("Joe") ;
        assertThat(user.getLastName()).isEqualTo("Jones") ;
        assertThat(user.getGender()).isEqualTo(User.Gender.MALE) ;
        assertThat(user.getEmail()).isEqualTo("joe@gmail.com") ;
        assertThat(user.getUserUid()).isNotNull() ;
        
    }

    @Test
    void shouldSelectUserByUserUid() throws Exception {
        UUID annaUserUid = UUID.randomUUID() ;
        User anna = new User(
                annaUserUid, "anna", "montana", User.Gender.FEMALE, 30, "anna@gmail.com"
        ) ;
        fakeDataDao.insertUser(annaUserUid, anna) ;

        assertThat(fakeDataDao.selectAllUsers()).hasSize(2) ;

        Optional <User> annaOptional = fakeDataDao.selectUserByUserUid(annaUserUid) ;
        assertThat(annaOptional.isPresent()).isTrue() ;
        assertThat(annaOptional.get()).isEqualToComparingFieldByField(anna) ;
    }

    @Test
    void shouldNotSelectUserByRandomUserUid() throws Exception {
        Optional <User> user = fakeDataDao.selectUserByUserUid(UUID.randomUUID()) ;
        assertThat(user.isPresent()).isFalse() ;
    }

    @Test
    void shouldUpdateUser() throws Exception {
        UUID joeUserUid = fakeDataDao.selectAllUsers().get(0).getUserUid() ;
        User newJoe = new User(
                joeUserUid, "anna", "montana", User.Gender.FEMALE, 30, "anna@gmail.com"
        ) ;

        fakeDataDao.updateUser(newJoe) ;

        Optional <User> user = fakeDataDao.selectUserByUserUid(joeUserUid) ;
        assertThat(user.isPresent()).isTrue() ;

        assertThat(fakeDataDao.selectAllUsers()).hasSize(1) ;
        assertThat(user.get()).isEqualToComparingFieldByField(newJoe) ;
    }

    @Test
    void deleteUserByUserUid() throws Exception {
        UUID joeUserUid = fakeDataDao.selectAllUsers().get(0).getUserUid() ;

        fakeDataDao.deleteUserByUserUid(joeUserUid) ;

        assertThat(fakeDataDao.selectUserByUserUid(joeUserUid).isPresent()).isFalse() ;
        assertThat(fakeDataDao.selectAllUsers()).isEmpty() ;
    }

    @Test
    void insertUser() throws Exception {
        UUID userUid = UUID.randomUUID() ;
        User user = new User(
                userUid, "anna", "montana", User.Gender.FEMALE, 30, "anna@gmail.com"
        ) ;
        fakeDataDao.insertUser(userUid, user) ;

        List <User> users = fakeDataDao.selectAllUsers() ;
        assertThat(users).hasSize(2) ;
        assertThat(fakeDataDao.selectUserByUserUid(userUid).get()).isEqualToComparingFieldByField(user) ;
    }
}