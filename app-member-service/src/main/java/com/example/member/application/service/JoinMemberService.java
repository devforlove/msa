package com.example.member.application.service;

import com.example.member.application.in.JoinMemberCommand;
import com.example.member.application.in.JoinMemberInfo;
import com.example.member.application.in.JoinMemberUseCase;
import com.example.member.application.out.JoinMemberPort;
import com.example.member.domain.model.member.MemberModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class JoinMemberService implements JoinMemberUseCase {

	private final JoinMemberPort joinMemberPort;
	
	@Override
	public JoinMemberInfo joinMember(JoinMemberCommand command) {
		final MemberModel memberModel = MemberModel.generateJoinMember(command.nickname(), command.email(), command.password(), command.profileImage());
		return new JoinMemberInfo(joinMemberPort.join(memberModel));
	}
}
