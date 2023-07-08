package com.mobile.test.user.domain.model;

import java.time.Instant;

public class Token {
    private String tokenId;
    private String token;
    private Instant issuedOn;
    private Instant expireOn;

    public Token() {
        tokenId = "";
        token = "";
        issuedOn = Instant.now();
        expireOn = Instant.now();
    }
}
