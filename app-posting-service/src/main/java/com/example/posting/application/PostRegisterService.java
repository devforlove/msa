package com.example.posting.application;

import com.example.posting.application.in.PostRegisterUseCase;
import com.example.posting.application.out.PostRegisterPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostRegisterService implements PostRegisterUseCase {

	private final PostRegisterPort postRegisterPort;

	@Override
	public void register() {
		postRegisterPort.savePost();
	}
}
