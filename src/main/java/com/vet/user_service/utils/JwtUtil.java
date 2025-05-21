package com.vet.user_service.utils;

import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;


public class JwtUtil {
    private static final String SECRET = "thisIsAReallyLongSecretKeyThatShouldBeAtLeastSixtyFourBytesLong123456";
    private static final long EXPIRATION_TIME = 86400000; // 1 day

    private static final SecretKey SECRET_KEY = new SecretKeySpec(
            SECRET.getBytes(StandardCharsets.UTF_8),
            SignatureAlgorithm.HS512.getJcaName()
    );

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .compact();
    }
}


