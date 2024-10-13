package com.example.dash.event;

import java.time.LocalDateTime;

public class KafkaMemberEvent {

	private final Long memberId;
	private final String type;
	private final String attributes;
	private final LocalDateTime createdAt;

	public KafkaMemberEvent(Long memberId, String type, String attributes) {
		this.memberId = memberId;
		this.type = type;
		this.attributes = attributes;
		this.createdAt = LocalDateTime.now();
	}
}
