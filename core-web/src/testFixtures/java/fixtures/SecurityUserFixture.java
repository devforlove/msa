package fixtures;

import com.example.dash.security.Role;
import com.example.dash.security.SecurityUser;
import java.util.EnumSet;
import java.util.Set;

public enum SecurityUserFixture {
	MEMBER(1L, "inwook94@naver.com", "wjddlsdnr12!", "inwook", EnumSet.of(Role.MEMBER)),
	ADMIN(2L, "admin@naver.com", "admin12!", "admin", EnumSet.of(Role.MEMBER, Role.ADMIN));

	Long memberId;
	String email;
	String password;
	String nickname;
	Set<Role> roles;

	SecurityUserFixture(Long memberId, String email, String password, String nickname, Set<Role> roles) {
		this.memberId = memberId;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.roles = roles;
	}

	public SecurityUser getSecurityUser() {
		return new SecurityUser(memberId, email, password, nickname, roles);
	}
}
