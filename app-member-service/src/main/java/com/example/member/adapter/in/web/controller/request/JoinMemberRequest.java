package com.example.member.adapter.in.web.controller.request;

import com.example.member.application.in.JoinMemberCommand;

public record JoinMemberRequest(
		String nickname,
		String email,
		String password,
		String profileImage
) {
	public JoinMemberCommand toCommand() {
		return new JoinMemberCommand(nickname, email, password, profileImage);
	}
}
