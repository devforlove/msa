package com.example.member.domain.model.member;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberModel {

	private String nickname;
	private String email;
	private String password;
	private String profileImage;
	private int lickCount;
	private Grade grade;

	@Builder
	private MemberModel(String nickname, String email, String password, String profileImage, int likeCount, Grade grade) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.profileImage = profileImage;
		this.lickCount = likeCount;
		this.grade = grade;
	}

	public static MemberModel generateJoinMember(String nickname, String email, String password, String profileImage) {
		return MemberModel.builder()
				.nickname(nickname)
				.email(email)
				.password(password)
				.profileImage(profileImage)
				.likeCount(0)
				.grade(Grade.COMMON)
				.build();
	}
}
