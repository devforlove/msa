package com.example.dash.member.domain.model;

import com.example.dash.member.adapter.out.persistence.member.Member;
public record MemberUpdateEvent(Member member) {
}
