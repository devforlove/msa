package com.example.posting.adapter.in.web.post;

import com.example.posting.adapter.in.web.post.request.PostRegisterRequest;
import com.example.posting.adapter.in.web.post.response.PostingRegisterResponse;
import com.example.posting.application.in.PostRegisterUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/posting")
@RequiredArgsConstructor
public class PostingRegisterController {

	private final PostRegisterUseCase postRegisterUseCase;

	@PostMapping("/")
	public ResponseEntity<PostingRegisterResponse> registerPosting(@RequestBody PostRegisterRequest request) {
		postRegisterUseCase.register();
		return ResponseEntity.ok(new PostingRegisterResponse());
	}
}
