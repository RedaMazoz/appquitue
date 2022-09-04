package ma.quantorion.appquitue.authentificationrest.domain;

public enum ApplicationUserPermission {
	PERSONAL_READ("personal:read"),
	PERSONAL_WRITE("personal:write"),
	
	CONDAMNATION_READ("condamnation:read"),
	CONDAMNATION_WRITE("condamnation:write"),
	
	DIPLOMA_READ("diploma:read"),
	DIPLOMA_WRITE("diploma:write"),
	
	INJURY_READ("injury:read"),
	INJURY_WRITE("injury:write"),
	
	INTERNSHIP_READ("internship:read"),
	INTERNSHIP_WRITE("internship:write"),
	
	MISSION_READ("mission:read"),
	MISSION_WRITE("mission:write"),
	
	PERMISSION_READ("permission:read"),
	PERMISSION_WRITE("permission:write"),
	
	PUNISHMENT_READ("punishment:read"),
	PUNISHMENT_WRITE("punishment:write");
	
	private final String permission;
	
	ApplicationUserPermission(String permission) {
		this.permission = permission;
	}
	String getPermission() {
		return permission;
	}

}
