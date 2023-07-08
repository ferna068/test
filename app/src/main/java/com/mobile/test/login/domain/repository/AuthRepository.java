package com.mobile.test.login.domain.repository;

import com.mobile.test.login.domain.callback.AuthCallback;
import com.mobile.test.login.domain.model.Auth;
import com.mobile.test.user.domain.model.User;
import retrofit2.Call;

public interface AuthRepository {
    void authenticate(Auth auth, AuthCallback callback);
}
