package com.mobile.test.helpers;

import com.mobile.test.core.domain.Encode;

public class PasswordHelper {
    private Encode encode;

    public PasswordHelper(Encode encode) {
        this.encode = encode;
    }

    public String EncodePassword(String password) {
        return encode.EncodePassword(password);
    }
}
