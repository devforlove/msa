package com.example.dash.member.adapter.out.persistence.memberevent;

import com.example.dash.event.internal.InternalEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Table(name = "member_event")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InternalMemberEvent extends InternalEvent {

	private Long memberId;
	@Enumerated(value = EnumType.STRING)
	private MemberEventType type;
	private String attributes;
	@CreatedDate
	private LocalDateTime createdAt;

	public InternalMemberEvent(Long memberId, MemberEventType type, String attributes) {
		this.memberId = memberId;
		this.type = type;
		this.attributes = attributes;
		this.isPublished = false;
	}
}
