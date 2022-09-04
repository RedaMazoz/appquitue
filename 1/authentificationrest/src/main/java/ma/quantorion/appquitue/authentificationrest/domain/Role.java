package ma.quantorion.appquitue.authentificationrest.domain;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Role
{	
	private String roleName;
	
	private Set<ApplicationUserPermission> rolePermissions;
	
	
	public Role(String roleName, Set<ApplicationUserPermission> rolePermissions){
		super();
		this.roleName = roleName;
		this.rolePermissions = rolePermissions;
	}
	
	public Set<SimpleGrantedAuthority> getGrantedAuthorities()
	{
		Set<SimpleGrantedAuthority> permissions = getRolePermissions().stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("ROLE_" + this.getRoleName()));
		return permissions;
	}
	
	
}
