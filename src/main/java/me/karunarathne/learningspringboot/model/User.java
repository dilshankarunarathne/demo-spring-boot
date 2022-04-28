package me.karunarathne.learningspringboot.model;

import java.util.UUID;

public class User {
    private UUID userUid ;
    private final String firstName ;
    private final String lastName ;
    private final Gender gender ;
    private final Integer age ;
    private final String email ;

    public enum Gender {
        MALE, FEMALE
    }

    public User () {
    }

    public User (UUID userUid, String firstName, String lastName, Gender gender, Integer age, String email) {
        this.userUid = userUid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.email = email;
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

    public UUID getUserUid() {
        return userUid;
    }

    public String getFirstName() {
        return firstName;
    }

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

    public void setUserUid (UUID userUid) {
        this.userUid = userUid ;
    }
}
