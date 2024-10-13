package com.example.dash.member.application.in;

import com.example.dash.member.application.in.command.JoinMemberCommand;
import com.example.dash.member.application.in.info.JoinMemberInfo;

public interface JoinMemberUseCase {
	JoinMemberInfo joinMember(JoinMemberCommand command);
}
