package com.rcontrol.api.config.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.rcontrol.api.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${rcontrol.jwt.expiration}")
	private String expiration;
	
	@Value("${rcontrol.jwt.secret}")
	private String secret;
	
	public String generateToken(Authentication authentication) {
		User loggedUser = (User) authentication.getPrincipal();

		Map<String, Object> addInfo = new HashMap<>();
		addInfo.put("firstName", loggedUser.getFirstName());
		addInfo.put("lastName", loggedUser.getLastName());
		addInfo.put("Authorities", loggedUser.getSimpleAuthorities().toString());
				
		return Jwts.builder()
				.setClaims(addInfo)
				.setIssuer("RControl")
				.setSubject(loggedUser.getEmail())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(expiration)))
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
				
	}

	public boolean isTokenValid(String token) {
		
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	public String getSubjectToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}


}
