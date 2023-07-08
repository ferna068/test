package com.mobile.test.user.domain.repository;

import com.mobile.test.user.domain.model.User;

public interface UserRepository {
    User Authenticate(String email, String password);
}
