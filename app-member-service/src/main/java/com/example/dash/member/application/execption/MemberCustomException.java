package com.example.dash.member.application.execption;

import com.example.dash.error.ErrorCode;

public class MemberCustomException extends RuntimeException {
	private final ErrorCode errorCode;

	public MemberCustomException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
