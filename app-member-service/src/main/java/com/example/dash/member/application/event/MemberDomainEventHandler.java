package com.example.dash.member.application.event;

import com.example.dash.event.Events;
import com.example.dash.member.adapter.out.persistence.member.Member;
import com.example.dash.member.adapter.out.persistence.memberevent.InternalMemberEvent;
import com.example.dash.member.adapter.out.persistence.memberevent.InternalMemberEventRepository;
import com.example.dash.member.adapter.out.persistence.memberevent.MemberEventType;
import com.example.dash.member.domain.model.MemberUpdateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@RequiredArgsConstructor
public class MemberDomainEventHandler {

	private final InternalMemberEventRepository internalMemberEventRepository;

	@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	public void handle(MemberUpdateEvent event) {
		Member member = event.member();
		InternalMemberEvent internalMemberEvent = new InternalMemberEvent(
				member.getMemberId(),
				MemberEventType.UPDATE,
				member.toString()
		);
		internalMemberEventRepository.save(internalMemberEvent);
		Events.raise(internalMemberEvent);
	}
}
