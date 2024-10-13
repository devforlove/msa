package com.example.dash.member.application.out;

import com.example.dash.member.domain.model.MemberModel;

public interface JoinMemberPort {
	long join(MemberModel memberModel);
}
