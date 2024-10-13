package com.example.dash.member.adapter.out.produce;

import com.example.dash.event.KafkaMemberEvent;
import com.example.dash.member.adapter.out.persistence.memberevent.InternalMemberEvent;
import com.example.dash.member.application.out.MemberEventPublishPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MemberEventPublisher implements MemberEventPublishPort {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	private final ObjectMapper objectMapper;
	@Value("${event.member-topic}")
	private String MEMBER_EVENT_TOPIC;

	@Override
	public void publish(InternalMemberEvent event) {
		try {
			kafkaTemplate.send(
					MEMBER_EVENT_TOPIC,
					objectMapper.writeValueAsString(new KafkaMemberEvent(event.getMemberId(), event.getType().name(), event.getAttributes()))).whenComplete((result, e) -> {
				if (e == null) {
					log.info("produced member event");
				} else {
					log.error("Error occurred while producing message: {}", e.getMessage());
				}
			});
		} catch (JsonProcessingException e) {
			log.error("Error occurred sending member event: {}", e.getMessage());
		}
	}
}
