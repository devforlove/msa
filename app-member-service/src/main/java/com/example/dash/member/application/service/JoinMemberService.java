package com.example.dash.member.application.service;

import com.example.dash.member.application.execption.EmailDuplicatedException;
import com.example.dash.member.application.in.JoinMemberUseCase;
import com.example.dash.member.application.in.command.JoinMemberCommand;
import com.example.dash.member.application.in.info.JoinMemberInfo;
import com.example.dash.member.domain.model.MemberModel;
import com.example.dash.member.application.out.CheckDuplicateEmailPort;
import com.example.dash.member.application.out.JoinMemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class JoinMemberService implements JoinMemberUseCase {

	private final JoinMemberPort joinMemberPort;
	private final CheckDuplicateEmailPort checkDuplicateEmailPort;

	@Override
	public JoinMemberInfo joinMember(JoinMemberCommand command) {
		if (checkDuplicateEmailPort.checkDuplicate(command.email())) {
			throw new EmailDuplicatedException(command.email());
		}

		final MemberModel memberModel = MemberModel.generateJoinMember(command.nickname(), command.email(), command.password(), command.profileImage());
		return new JoinMemberInfo(joinMemberPort.join(memberModel));
	}
}
