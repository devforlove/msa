package com.example.member.adapter.in.web.security.api;

import com.example.member.adapter.in.web.security.AuthenticationRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	private final ObjectMapper objectMapper;

	protected AuthenticationFilter(AuthenticationManager authenticationManager,
			AuthenticationSuccessHandler authenticationSuccessHandler,
			AuthenticationFailureHandler authenticationFailureHandler,
			ObjectMapper objectMapper
			) {
		super(new AntPathRequestMatcher("/member/login", "POST"), authenticationManager);
		this.setAuthenticationSuccessHandler(authenticationSuccessHandler);
		this.setAuthenticationFailureHandler(authenticationFailureHandler);
		this.objectMapper = objectMapper;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException {
		AuthenticationRequest authenticationRequest = objectMapper.readValue(request.getInputStream(), AuthenticationRequest.class);
		String email = authenticationRequest.email();
		String password = authenticationRequest.password();
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(email, password);

		return this.getAuthenticationManager().authenticate(authRequest);
	}
}
