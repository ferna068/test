package com.mobile.test.login.domain.service;

import com.mobile.test.login.domain.model.Auth;
import com.mobile.test.user.domain.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("auth/authenticate")
    Call<User> authenticate(@Body Auth auth);
}
