package com.example.dash.adapter.in.web.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.dash.adapter.in.web.support.IntegrationTestSupport;
import com.example.dash.member.adapter.in.web.controller.request.JoinMemberRequest;
import com.example.dash.member.domain.model.Grade;
import com.example.dash.member.adapter.out.persistence.member.Member;
import com.example.dash.member.adapter.out.persistence.member.MemberRepository;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class MemberJoinControllerTest extends IntegrationTestSupport {

	@Autowired
	private MemberRepository memberRepository;

	@Test
	void joinMember() {
		memberRepository.save(generateMemberEntity("user1", "user1@example.com", "12345", Grade.COMMON));
		memberRepository.save(generateMemberEntity("user2", "user2@example.com", "abcde", Grade.COMMON));
		JoinMemberRequest joinMemberRequest = new JoinMemberRequest("user3", "user3@example.com", "1@x3Erx", "COMMON");

		ExtractableResponse<Response> response = RestAssured
				.given()
				.log().all()
				.body(joinMemberRequest)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.when()
				.post("/member/v1/")
				.then()
				.log().all()
				.extract();

		final JsonPath result = response.jsonPath();
		Optional<Member> savedMember = memberRepository.findByEmail("user3@example.com");

		assertAll(
				() -> assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value()),
				() -> assertThat(result.getLong("memberId")).isEqualTo(3L),
				() -> assertThat(savedMember.isPresent()).isTrue()
		);
	}

	private Member generateMemberEntity(String nickname, String email, String password, Grade grade) {
		return Member.builder()
				.nickname(nickname)
				.email(email)
				.password(password)
				.grade(grade.name())
				.build();
	}
}