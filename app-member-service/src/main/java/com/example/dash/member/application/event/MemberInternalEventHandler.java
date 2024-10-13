package com.example.dash.member.application.event;

import com.example.dash.member.adapter.out.persistence.memberevent.InternalMemberEvent;
import com.example.dash.member.application.out.MemberEventPublishPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@RequiredArgsConstructor
public class MemberInternalEventHandler {

	private final MemberEventPublishPort memberEventPublishPort;

	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void handle(InternalMemberEvent event) {
		memberEventPublishPort.publish(event);
	}
}
