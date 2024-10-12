package com.example.member.adapter.out.persistence.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long memberId;

	@Column(name = "member_name", length = 100)
	private String nickname;

	@Column(name = "member_email", length = 200)
	private String email;

	@Column(name = "member_password", length = 100)
	String password;

	@Column(name = "member_profile_image", length = 200)
	private String profileImage;

	@Column(name = "like_count")
	private Integer likeCount;

	@Column(name = "score_point")
	private Integer scorePoint;

	@Column(name = "grade", length = 50)
	private String grade;

	@Builder
	public Member(String nickname, String email, String password, String profileImage, Integer likeCount, Integer scorePoint, String grade) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.profileImage = profileImage;
		this.likeCount = likeCount;
		this.scorePoint = scorePoint;
		this.grade = grade;
	}
}
