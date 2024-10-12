package com.example.member.application.in;

public record JoinMemberCommand(
		String nickname,
		String email,
		String password,
		String profileImage
) {

}
