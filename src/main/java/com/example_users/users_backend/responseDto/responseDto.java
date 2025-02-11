package com.example_users.users_backend.responseDto;

public class responseDto {
    private String message ;


    public responseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
