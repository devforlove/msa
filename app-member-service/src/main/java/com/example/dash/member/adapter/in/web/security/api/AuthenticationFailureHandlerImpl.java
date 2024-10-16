package com.example.dash.member.adapter.in.web.security.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.dash.error.ErrorCode;
import com.example.dash.error.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
	private final ObjectMapper objectMapper;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
		ErrorCode errorCode = ErrorCode.USER_UNAUTHORIZED;
		ErrorResponse errorResponse = new ErrorResponse(errorCode.getCode(), e.getMessage());
		response.setStatus(errorCode.getStatus().value());
		response.setContentType(APPLICATION_JSON_VALUE);
		objectMapper.writeValue(response.getWriter(), errorResponse);
	}
}
