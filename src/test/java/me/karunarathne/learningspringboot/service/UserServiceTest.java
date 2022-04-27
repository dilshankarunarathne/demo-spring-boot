package me.karunarathne.learningspringboot.service;

import me.karunarathne.learningspringboot.dao.FakeDataDao;
import me.karunarathne.learningspringboot.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.* ;
import static org.mockito.BDDMockito.given ;
import static org.mockito.Mockito.verify;

class UserServiceTest {
    @Mock
    private FakeDataDao fakeDataDao ;
    private UserService userService ;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.initMocks(this) ;
        userService = new UserService(fakeDataDao) ;
    }

    @Test
    void shouldGetAllUsers() throws Exception {
        UUID annaUserUid = UUID.randomUUID() ;
        User anna = new User(
                annaUserUid, "anna", "montana", User.Gender.FEMALE, 30, "anna@gmail.com"
        ) ;

        List <User> users = new ArrayList<User>() ;
        users.add(anna) ;

        given (fakeDataDao.selectAllUsers()).willReturn(users) ;
        List <User> allUsers = userService.getAllUsers() ;

        assertThat(allUsers).hasSize(1) ;

        User user = allUsers.get(0) ;

        assertUserFields (user);
    }

    @Test
    void shoildGetUser() throws Exception {
        UUID annaUserUid = UUID.randomUUID() ;
        User anna = new User(
                annaUserUid, "anna", "montana", User.Gender.FEMALE, 30, "anna@gmail.com"
        ) ;

        given (fakeDataDao.selectUserByUserUid(annaUserUid)).willReturn(Optional.of(anna)) ;

        Optional <User> userOptional = userService.getUser(annaUserUid);

        assertThat(userOptional.isPresent()).isTrue() ;
        User user = userOptional.get() ;
    }

    @Test
    void updateUser() throws Exception {
        UUID annaUserUid = UUID.randomUUID() ;
        User anna = new User(
                annaUserUid, "anna", "montana", User.Gender.FEMALE, 30, "anna@gmail.com"
        ) ;

        given (fakeDataDao.selectUserByUserUid(annaUserUid)).willReturn(Optional.of(anna)) ;
        given (fakeDataDao.updateUser(anna)).willReturn(1) ;

        int updateResult = userService.updateUser(anna) ;

        verify (fakeDataDao).selectUserByUserUid(annaUserUid) ;
    }

    @Test
    void removeUser() throws Exception {
    }

    @Test
    void insertUser() throws Exception {
    }

    private void assertUserFields(User user) {
        assertThat(user.getAge()).isEqualTo(30) ;
        assertThat(user.getFirstName()).isEqualTo("anna") ;
        assertThat(user.getLastName()).isEqualTo("montana") ;
        assertThat(user.getGender()).isEqualTo(User.Gender.FEMALE) ;
        assertThat(user.getEmail()).isEqualTo("anna@gmail.com") ;
        assertThat(user.getUserUid()).isNotNull() ;
    }
}