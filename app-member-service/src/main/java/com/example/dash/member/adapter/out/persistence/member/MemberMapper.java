package com.example.dash.member.adapter.out.persistence.member;

import com.example.dash.member.domain.model.Grade;
import com.example.dash.member.domain.model.MemberModel;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

	public MemberModel toDomain(Member member) {
		return MemberModel.builder()
				.nickname(member.getNickname())
				.email(member.getEmail())
				.password(member.getPassword())
				.profileImage(member.getProfileImage())
				.likeCount(member.getLikeCount())
				.grade(Grade.valueOf(member.getGrade()))
				.build();
	}

	public Member toEntity(MemberModel member) {
		return Member.builder()
				.nickname(member.getNickname())
				.email(member.getEmail())
				.password(member.getPassword())
				.profileImage(member.getProfileImage())
				.likeCount(member.getLickCount())
				.grade(member.getGrade().name())
				.build();
	}
}
