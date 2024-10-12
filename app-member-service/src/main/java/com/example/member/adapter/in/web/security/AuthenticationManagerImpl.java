package com.example.member.adapter.in.web.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationManagerImpl implements AuthenticationManager {
	private final PasswordEncoder passwordEncoder;
	private final UserDetailsService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) {
		UserDetails member = userDetailsService.loadUserByUsername(authentication.getName());

		final String encryptedPassword = member.getPassword();
		final String enteredPassword = (String) authentication.getCredentials();

		if (!passwordEncoder.matches(enteredPassword, encryptedPassword)) {
			throw new BadCredentialsException("password not matched.");
		}

		return new UsernamePasswordAuthenticationToken(member, null, member.getAuthorities());
	}
}
