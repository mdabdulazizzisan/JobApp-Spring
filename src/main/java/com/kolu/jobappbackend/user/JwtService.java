package com.kolu.jobappbackend.user;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {
    private static final String KEY = "kofgjfljgdfjtgoireogifdjlkojgesrtoiehrogihjdfkjgldfkjgoirjkfgdsgdjgoerhigfdgjesorotiuerodfj3ge049rutreijgkdfjgkdfjugioujfghlu";

    public String generateToken(
            String username,
            Map<String, Object> extraClaims
    ) {
        return Jwts.builder()
                .claims(extraClaims)
                .subject(username)
                .signWith(getKey())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 10)) // 10 minutes
                .compact();
    }

    public String generateToken(String username) {
        return generateToken(username, Map.of());
    }

    public String extractUsername(String jwt) {
        return extractClaim(jwt, Claims::getSubject);
    }

    public Date extractExpiration(String jwt) {
        return extractClaim(jwt, Claims::getExpiration);
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
    public boolean isTokenExpired(String jwt) {
        return extractExpiration(jwt).before(new Date());
    }
    public boolean isTokenValid(String jwt, UserDetails userDetails) {
        final String username = extractUsername(jwt);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwt));
    }
}
