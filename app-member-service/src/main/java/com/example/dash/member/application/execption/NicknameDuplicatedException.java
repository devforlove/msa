package com.example.dash.member.application.execption;

import com.example.dash.error.ErrorCode;

public class NicknameDuplicatedException extends MemberCustomException {

	public NicknameDuplicatedException(String nickname) {
		super(ErrorCode.NICKNAME_DUPLICATED, String.format("nickname (%s) is duplicated.", nickname));
	}
}
