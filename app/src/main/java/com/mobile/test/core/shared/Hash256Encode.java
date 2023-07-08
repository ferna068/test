package com.mobile.test.core.shared;

import com.mobile.test.core.domain.Encode;

import java.security.MessageDigest;

public class Hash256Encode implements Encode {

    private String bytesToHex(byte[] hash) {
        StringBuilder sb = new StringBuilder();
        for(byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    @Override
    public String EncodePassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            return bytesToHex(hash);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
