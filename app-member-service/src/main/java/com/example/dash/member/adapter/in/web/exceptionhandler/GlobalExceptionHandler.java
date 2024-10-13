package com.example.dash.member.adapter.in.web.exceptionhandler;

import com.example.dash.error.ErrorCode;
import com.example.dash.error.ErrorResponse;
import com.example.dash.error.ErrorResponse.ValidationError;
import com.example.dash.member.application.execption.MemberCustomException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MemberCustomException.class)
	protected ResponseEntity<ErrorResponse> handleBusinessException(MemberCustomException e) {
		ErrorCode errorCode = e.getErrorCode();
		ErrorResponse response = new ErrorResponse(errorCode.getCode(), e.getMessage());
		return new ResponseEntity<>(response, errorCode.getStatus());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidException(MethodArgumentNotValidException e) {
		ErrorCode errorCode = ErrorCode.INVALID_INPUT_VALUE;
		return ResponseEntity
				.status(errorCode.getStatus())
				.body(makeErrorResponse(e, errorCode));
	}

	private ErrorResponse makeErrorResponse(BindException e, ErrorCode errorCode) {
		List<ValidationError> validationErrorList = e.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(ValidationError::of)
				.collect(Collectors.toList());

		return ErrorResponse.builder()
				.message(errorCode.getMessage())
				.errors(validationErrorList)
				.build();
	}
}
