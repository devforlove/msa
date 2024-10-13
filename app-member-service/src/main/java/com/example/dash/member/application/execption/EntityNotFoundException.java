package com.example.dash.member.application.execption;

import com.example.dash.error.ErrorCode;

public class EntityNotFoundException extends MemberCustomException {

	public EntityNotFoundException(ErrorCode errorCode, String message) {
		super(errorCode, message);
	}
}
