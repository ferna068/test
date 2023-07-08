package com.mobile.test.login.infrastructure.api;

import com.mobile.test.login.domain.callback.AuthCallback;
import com.mobile.test.login.domain.model.Auth;
import com.mobile.test.login.domain.repository.AuthRepository;
import com.mobile.test.login.domain.service.AuthService;
import com.mobile.test.user.domain.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestAuthRepository implements AuthRepository {
    private AuthService service;

    public RestAuthRepository(AuthService service) {
        this.service = service;
    }

    @Override
    public void authenticate(Auth auth, AuthCallback callback) {
        Call<User> call = service.authenticate(auth);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    User user = response.body();
                    callback.onLoginSuccess(user);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onLoginFailure();
            }
        });
    }
}
