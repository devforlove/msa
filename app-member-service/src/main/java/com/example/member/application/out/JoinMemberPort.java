package com.example.member.application.out;

import com.example.member.adapter.out.persistence.member.Member;
import com.example.member.domain.model.member.MemberModel;

public interface JoinMemberPort {
	long join(MemberModel memberModel);
}
