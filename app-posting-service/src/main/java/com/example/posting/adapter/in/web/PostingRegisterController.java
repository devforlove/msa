package com.example.posting.adapter.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/posting")
public class PostingRegisterController {

	@PostMapping("/")
	public ResponseEntity<PostingRegisterResponse> registerPosting() {

		return ResponseEntity.ok(new PostingRegisterResponse());
	}
}
