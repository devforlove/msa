package com.example.dash.security;

import java.util.Collection;
import java.util.Set;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
public class SecurityUser implements UserDetails {
	private final Long memberId;
	private final String email;
	private final String password;
	private final String nickname;

	private final Set<Role> roles;

	@Builder
	public SecurityUser(Long memberId, String email, String password, String nickname, Set<Role> roles) {
		this.memberId = memberId;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList(
				roles.stream().map(r -> String.format("ROLE_%s", r.name()))
						.toArray(String[]::new)
		);
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return nickname;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
