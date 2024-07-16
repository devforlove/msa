package com.example.member.command.domain.execption;

import com.example.coreweb.error.ErrorCode;
import com.example.coreweb.error.exception.BusinessException;

public class NicknameDuplicatedException extends BusinessException {

	public NicknameDuplicatedException(String nickname) {
		super(ErrorCode.NICKNAME_DUPLICATED, String.format("nickname (%s) is duplicated.", nickname));
	}
}
