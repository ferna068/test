package com.mobile.test.login.application;

import com.mobile.test.core.shared.Hash256Encode;
import com.mobile.test.helpers.PasswordHelper;
import com.mobile.test.login.domain.callback.AuthCallback;
import com.mobile.test.login.domain.model.Auth;
import com.mobile.test.login.domain.repository.AuthRepository;

public class Authenticator {
    private AuthRepository repository;
    private PasswordHelper helper;

    public Authenticator(AuthRepository repository) {
        this.repository = repository;
        this.helper = new PasswordHelper(new Hash256Encode());
    }

    public void authenticate(String email, String password, final AuthCallback callback) {
        String passwordEncoded = helper.EncodePassword(password);
        Auth auth = new Auth(email, passwordEncoded);
        repository.authenticate(auth, callback);
    }
}
