package me.karunarathne.learningspringboot.resource;

public class ErrorMessage {
    String errorMessage ;

    public ErrorMessage(String message) {
        this.errorMessage = message;
    }

    public String getMessage() {
        return errorMessage;
    }
}