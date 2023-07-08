package com.mobile.test.login.domain.callback;

import com.mobile.test.user.domain.model.User;

public interface AuthCallback {
    void onLoginSuccess(User user);
    void onLoginFailure();
}
