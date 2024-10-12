package com.example.member.adapter.in.web.security;

import com.example.common.security.SecurityUser;
import com.example.member.adapter.out.persistence.member.Member;
import com.example.member.adapter.out.persistence.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	private final MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member =  memberRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("email (%s) not found", email)));

		return new SecurityUser(
				member.getMemberId(),
				member.getEmail(),
				member.getPassword(),
				member.getNickname(),
				null
		);
	}
}
