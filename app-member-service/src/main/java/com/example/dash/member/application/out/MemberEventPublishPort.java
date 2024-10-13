package com.example.dash.member.application.out;

import com.example.dash.member.adapter.out.persistence.memberevent.InternalMemberEvent;

public interface MemberEventPublishPort {
	void publish(InternalMemberEvent event);
}
