package com.example.member.command.domain.execption;

import com.example.coreweb.error.ErrorCode;
import com.example.coreweb.error.exception.BusinessException;

public class EmailDuplicatedException extends BusinessException {

	public EmailDuplicatedException(String email) {
		super(ErrorCode.EMAIL_DUPLICATED, String.format("email (%s) is duplicated.", email));
	}
}
