package com.example.jorgecardproject.security.jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.jorgecardproject.service.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

	@Value("${projeto.jwtSecret}")
	private String jwtSecret;

	@Value("${projeto.jwtExpirationMs}")
	private int jwtExpirationMs;

	public String generateTokenFromUserDeailsImpl(UserDetailsImpl UserDetail) {
		return Jwts.builder().subject(UserDetail.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
				.signWith(getSigninKey(), SignatureAlgorithm.HS512).compact();
	}

	public Key getSigninKey() {
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
		return key;
	}

	public boolean valitateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
			return true;
		} catch (MalformedJwtException e) {
			System.out.println("Token inválido " + e.getMessage());
		} catch (ExpiredJwtException e) {
			System.out.println("Token expirado " + e.getMessage());
		} catch (UnsupportedJwtException e) {
			System.out.println("Token não suportado " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Token Argumento inválido " + e.getMessage());
		}

		return false;
	}
}
