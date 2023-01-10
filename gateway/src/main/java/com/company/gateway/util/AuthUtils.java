package com.company.gateway.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class AuthUtils {

    private static final Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

    private static Date accessTokenLife() {
        return new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(10));
    }

    public static String generateAccessToken(String username, String issuer, Collection<GrantedAuthority> claim) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(accessTokenLife())
                .withIssuer(issuer)
                .withClaim("roles", claim.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
    }

}
