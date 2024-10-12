package com.example.member.adapter.in.web.controller.response;

import com.example.member.application.in.JoinMemberInfo;

public record JoinMemberResponse(
		long memberId
) {

	public static JoinMemberResponse toResponse(JoinMemberInfo info) {
		return new JoinMemberResponse(info.memberId());
	}
}
