package com.example.member.adapter.out.persistence.member;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends Repository<Member, Long> {

	Optional<Member> findByEmail(String email);
	Member save(Member member);
}
