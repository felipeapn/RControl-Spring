package com.rcontrol.api.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rcontrol.api.model.User;
import com.rcontrol.api.repository.UserRepository;

public class AuthenticationTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	
	private UserRepository userRepository;

	public AuthenticationTokenFilter(TokenService tokenService, UserRepository userRepository) {
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = retriveToken(request);
	
		boolean tokenValid = tokenService.isTokenValid(token);
		
		if(tokenValid) {
			authenticateClient(token);
		}
			
		filterChain.doFilter(request, response);
	}

	private void authenticateClient(String token) {
		String emailUser = tokenService.getSubjectToken(token);
		
		User user = this.userRepository.findByEmail(emailUser).orElseThrow();
		
		UsernamePasswordAuthenticationToken authentication = 
				new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
	}

	private String retriveToken(HttpServletRequest request) {
		
		String token = request.getHeader("Authorization");
		
		if (token == null || token.isEmpty() || !token.startsWith("bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}

}
