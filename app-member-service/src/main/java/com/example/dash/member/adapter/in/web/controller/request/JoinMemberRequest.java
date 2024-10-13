package com.example.dash.member.adapter.in.web.controller.request;

import com.example.dash.member.application.in.command.JoinMemberCommand;

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
