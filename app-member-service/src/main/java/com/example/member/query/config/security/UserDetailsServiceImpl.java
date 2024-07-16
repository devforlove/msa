package com.example.member.query.config.security;

import com.example.coreweb.security.SecurityUser;
import com.example.member.command.adapter.out.persistence.Member;
import com.example.member.command.adapter.out.persistence.MemberRepository;
import java.util.stream.Collectors;
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
				member.getRoles().stream().map(UserRole::getName).collect(Collectors.toSet())
		);
	}
}
