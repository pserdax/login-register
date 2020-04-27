package com.example.login;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("register.php")
    Call<User> performRegistration(@Query("email") String email, @Query("password") String password, @Query("password_confirm") String password_confirm);

    @GET("login.php")
    Call<User> performLogin(@Query("email") String email, @Query("password") String password);
}
