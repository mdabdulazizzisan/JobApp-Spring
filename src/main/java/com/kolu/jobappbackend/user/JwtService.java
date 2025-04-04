package com.kolu.jobappbackend.user;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.PublicKey;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {
    private static final String KEY = "kolu";

    public String extractUsername(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    public <T> T extractClaim(String jwt, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(jwt);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts
                .parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();

    }

    private SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
