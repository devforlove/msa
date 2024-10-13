package com.example.dash.member.adapter.out.persistence.memberevent;

import org.springframework.data.repository.Repository;

public interface InternalMemberEventRepository extends Repository<InternalMemberEvent, Long> {

	void save(InternalMemberEvent event);
}
