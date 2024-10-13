package com.example.dash.member.adapter.in.web.controller.response;

import com.example.dash.member.application.in.info.JoinMemberInfo;

public record JoinMemberResponse(
		long memberId
) {

	public static JoinMemberResponse toResponse(JoinMemberInfo info) {
		return new JoinMemberResponse(info.memberId());
	}
}
