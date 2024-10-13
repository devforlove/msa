package com.example.dash.member.adapter.out.persistence.member;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends Repository<Member, Long> {

	Optional<Member> findByEmail(String email);
	boolean existsByEmail(String email);
	Member save(Member member);
}
