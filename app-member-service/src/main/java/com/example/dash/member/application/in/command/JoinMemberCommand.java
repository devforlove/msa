package com.example.dash.member.application.in.command;

public record JoinMemberCommand(
		String nickname,
		String email,
		String password,
		String profileImage
) {

}
