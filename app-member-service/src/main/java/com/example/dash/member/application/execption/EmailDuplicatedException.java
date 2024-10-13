package com.example.dash.member.application.execption;

import com.example.dash.error.ErrorCode;

public class EmailDuplicatedException extends MemberCustomException {

	public EmailDuplicatedException(String email) {
		super(ErrorCode.EMAIL_DUPLICATED, String.format("email (%s) is duplicated.", email));
	}
}
