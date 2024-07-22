package com.example.member.command.domain.execption;


import com.example.common.error.ErrorCode;
import com.example.common.error.exception.BusinessException;

public class EntityNotFoundException extends BusinessException {

	public EntityNotFoundException(ErrorCode errorCode, String message) {
		super(errorCode, message);
	}
}
