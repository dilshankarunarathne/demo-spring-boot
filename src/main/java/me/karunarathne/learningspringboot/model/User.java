package me.karunarathne.learningspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.UUID;

public class User {
    private final UUID userUid ;
    private final String firstName ;
    private final String lastName ;
    private final Gender gender ;
    private final Integer age ;
    private final String email ;

    public enum Gender {
        MALE, FEMALE
    }

    public User (
            @JsonProperty ("userUid") UUID userUid,
            @JsonProperty ("firstName") String firstName,
            @JsonProperty ("lastName") String lastName,
            @JsonProperty ("gender") Gender gender,
            @JsonProperty ("age") Integer age,
            @JsonProperty ("email") String email
    ) {
        this.userUid = userUid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.email = email;
    }

    public static User newUser (UUID userUid, User user) {
        return new User (
                userUid, user.getFirstName(), user.getLastName(), user.getGender(), user.getAge(), user.getEmail()
        ) ;
    }

    @Override
    public String toString() {
        return "User{" +
                "userUid=" + userUid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    @JsonProperty ("id")
    public UUID getUserUid() {
        return userUid;
    }

    public String getFullName () {
        return firstName + " " + lastName ;
    }

    public int getDateOfBirth () {
        return LocalDate.now().minusYears(age).getYear() ;
    }

    @JsonIgnore
    public String getFirstName() {
        return firstName;
    }

    @JsonIgnore
    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
