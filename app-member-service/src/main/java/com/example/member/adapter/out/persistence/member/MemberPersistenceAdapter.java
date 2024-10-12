package com.example.member.adapter.out.persistence.member;

import com.example.member.application.out.JoinMemberPort;
import com.example.member.domain.model.member.MemberModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements JoinMemberPort {

	private final MemberMapper memberMapper;
	private final MemberRepository memberRepository;

	public long join(MemberModel memberModel) {
		final Member member = memberRepository.save(memberMapper.toEntity(memberModel));
		return member.getMemberId();
	}
}
