package com.example.dash.member.adapter.in.web.controller;

import com.example.common.annotation.WebAdapter;
import com.example.dash.member.adapter.in.web.controller.request.JoinMemberRequest;
import com.example.dash.member.adapter.in.web.controller.response.JoinMemberResponse;
import com.example.dash.member.application.in.JoinMemberUseCase;
import com.example.dash.member.application.in.command.JoinMemberCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@WebAdapter
@RequestMapping("/member/v1")
@RequiredArgsConstructor
public class MemberJoinController {

	private final JoinMemberUseCase memberJoinUseCase;

	@PostMapping("/")
	public ResponseEntity<JoinMemberResponse> joinMember(
			@RequestBody JoinMemberRequest request
	) {
		final JoinMemberCommand command = request.toCommand();
		return new ResponseEntity<>(JoinMemberResponse.toResponse(memberJoinUseCase.joinMember(command)), HttpStatus.OK);
	}
}
