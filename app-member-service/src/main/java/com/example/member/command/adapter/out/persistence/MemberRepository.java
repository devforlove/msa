package com.example.member.command.adapter.out.persistence;

import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends Repository<Member, Long> {

	Optional<Member> findByEmail(String email);
}
