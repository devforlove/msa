package com.example.member.command.domain.execption;

import com.example.common.error.ErrorCode;
import com.example.common.error.exception.BusinessException;

public class EmailDuplicatedException extends BusinessException {

	public EmailDuplicatedException(String email) {
		super(ErrorCode.EMAIL_DUPLICATED, String.format("email (%s) is duplicated.", email));
	}
}
