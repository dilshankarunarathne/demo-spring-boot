package me.karunarathne.learningspringboot.service;

import jersey.repackaged.com.google.common.collect.ImmutableList;
import me.karunarathne.learningspringboot.dao.FakeDataDao;
import me.karunarathne.learningspringboot.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given ;
import static org.mockito.Mockito.verify;

import static org.assertj.core.api.Assertions.* ;

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
        List <User> allUsers = userService.getAllUsers(Optional.empty()) ;

        assertThat(allUsers).hasSize(1) ;

        User user = allUsers.get(0) ;
        assertAnnaFields(user);
    }

    @Test
    public void shouldGetAllUserByGender () throws Exception {
        UUID annaUserUid = UUID.randomUUID() ;
        User anna = new User(
                annaUserUid, "anna", "montana", User.Gender.FEMALE, 30, "anna@gmail.com"
        ) ;

        UUID joeUserUid = UUID.randomUUID() ;
        User joe = new User(
                annaUserUid, "joe", "jones", User.Gender.MALE, 30, "joe@gmail.com"
        ) ;

        ImmutableList <User> users = new ImmutableList.Builder <User> ()
                .add (anna)
                .add (joe)
                .build () ;

        given (fakeDataDao.selectAllUsers()).willReturn(users) ;

        List <User> filteredUsers = userService.getAllUsers(Optional.of("FEMALE")) ;
        assertThat (filteredUsers).hasSize(1) ;
        assertAnnaFields (filteredUsers.get(0)) ;
    }

    @Test
    void shouldThrowExceptionWhenGenderIsInvalid () throws Exception {
        assertThatThrownBy ()
    }

    @Test
    void shouldGetUser() throws Exception {
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
    void shouldUpdateUser() throws Exception {
        UUID annaUserUid = UUID.randomUUID() ;
        User anna = new User(
                annaUserUid, "anna", "montana", User.Gender.FEMALE, 30, "anna@gmail.com"
        ) ;

        given (fakeDataDao.selectUserByUserUid(annaUserUid)).willReturn(Optional.of(anna)) ;
        given (fakeDataDao.updateUser(anna)).willReturn(1) ;

        ArgumentCaptor <User> captor = ArgumentCaptor.forClass(User.class) ;

        int updateResult = userService.updateUser(anna) ;

        verify (fakeDataDao).selectUserByUserUid(annaUserUid) ;
        verify (fakeDataDao).updateUser(captor.capture()) ;

        User user = captor.getValue() ;
        assertAnnaFields (user) ;

        assertThat (updateResult).isEqualTo(1) ;
    }

    @Test
    void shouldRemoveUser() throws Exception {
        UUID annaUserUid = UUID.randomUUID() ;
        User anna = new User(
                annaUserUid, "anna", "montana", User.Gender.FEMALE, 30, "anna@gmail.com"
        ) ;

        given (fakeDataDao.selectUserByUserUid(annaUserUid)).willReturn(Optional.of(anna)) ;
        given (fakeDataDao.deleteUserByUserUid(annaUserUid)).willReturn(1) ;

        int deleteResult = userService.removeUser(annaUserUid) ;

        verify (fakeDataDao).selectUserByUserUid(annaUserUid) ;
        verify (fakeDataDao).deleteUserByUserUid(annaUserUid) ;

        assertThat (deleteResult).isEqualTo(1) ;
    }

    @Test
    void shouldInsertUser() throws Exception {
        User anna = new User(
            null, "anna", "montana", User.Gender.FEMALE, 30, "anna@gmail.com"
        ) ;

        given (fakeDataDao.insertUser(
                any (UUID.class), eq (anna)
        )).willReturn(1) ;

        ArgumentCaptor <User> captor = ArgumentCaptor.forClass(User.class) ;

        int insertResult = userService.insertUser(anna) ;

        verify (fakeDataDao).insertUser( any (UUID.class), captor.capture()) ;

        User user = captor.getValue() ;

        assertAnnaFields (user) ;

        assertThat (insertResult).isEqualTo(1) ;
    }

    private void assertAnnaFields(User user) {
        assertThat(user.getAge()).isEqualTo(30) ;
        assertThat(user.getFirstName()).isEqualTo("anna") ;
        assertThat(user.getLastName()).isEqualTo("montana") ;
        assertThat(user.getGender()).isEqualTo(User.Gender.FEMALE) ;
        assertThat(user.getEmail()).isEqualTo("anna@gmail.com") ;
        assertThat(user.getUserUid()).isNotNull() ;
    }
}