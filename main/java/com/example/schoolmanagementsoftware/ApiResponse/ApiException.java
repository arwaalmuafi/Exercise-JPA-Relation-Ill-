package com.example.schoolmanagementsoftware.ApiResponse;

public class ApiException extends RuntimeException {

    public ApiException(String massage){
        super(massage);
    }
}
