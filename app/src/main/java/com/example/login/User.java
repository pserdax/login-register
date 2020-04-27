package com.example.login;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("response")
    private String response;

    @SerializedName("email")
    private String email;


    public String getResponse() {
        return response;
    }

    public String getEmail() {
        return email;
    }
}
