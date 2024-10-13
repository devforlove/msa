package com.example.dash.member.adapter.out.persistence.member;

import com.example.dash.member.application.out.CheckDuplicateEmailPort;
import com.example.dash.member.application.out.JoinMemberPort;
import com.example.dash.member.domain.model.MemberModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements JoinMemberPort, CheckDuplicateEmailPort {

	private final MemberMapper memberMapper;
	private final MemberRepository memberRepository;

	public long join(MemberModel memberModel) {
		final Member member = memberRepository.save(memberMapper.toEntity(memberModel));
		return member.getMemberId();
	}

	@Override
	public boolean checkDuplicate(String email) {
		return memberRepository.existsByEmail(email);
	}
}
