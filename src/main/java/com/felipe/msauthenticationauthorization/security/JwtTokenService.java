package com.felipe.msauthenticationauthorization.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.felipe.msauthenticationauthorization.exceptions.JwtTokenCreationException;
import com.felipe.msauthenticationauthorization.exceptions.JwtTokenInvalidException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

@Service
public class JwtTokenService {

    private final String SECRET = "my-secret";
    private final String ISSUER = "ms-authentication-authorization";
    private final HttpServletRequest request;

    public JwtTokenService(HttpServletRequest request) {
        this.request = request;
    }

    public String generateToken(String username, String accessKey) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);

            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(username)
                    .withClaim("accessKey", accessKey)
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new JwtTokenCreationException();
        }
    }

    public Map<String, Claim> validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getClaims();
        } catch (JWTVerificationException exception) {
            throw new JwtTokenInvalidException();
        }
    }

    public String getToken() {
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusMonths(1).toInstant(ZoneOffset.ofHours(-3));
    }
}
