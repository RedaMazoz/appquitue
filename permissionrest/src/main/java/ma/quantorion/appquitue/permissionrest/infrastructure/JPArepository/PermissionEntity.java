package ma.quantorion.appquitue.permissionrest.infrastructure.JPArepository;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.quantorion.appquitue.permissionrest.domain.Permission;

@Entity
@Data
@NoArgsConstructor
public class PermissionEntity
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="permission_id")
	private Long permissionId;

	@Column(name="permission_type")
	private String permissionType;

	@Column(name="permission_start_date")
	private Date permissionStartDate;

	@Column(name="permission_end_date")
	private Date permissionEndDate;
	
	@Column(name="permission_obs")
	private String permissionObservation;
	
	@Column(name="permission_destination")
	private String permissionDestination;

	public PermissionEntity(String permissionType, Date permissionStartDate, Date permissionEndDate,
			String permissionObservation, String permissionDestination) {
		super();
		this.permissionType = permissionType;
		this.permissionStartDate = permissionStartDate;
		this.permissionEndDate = permissionEndDate;
		this.permissionObservation = permissionObservation;
		this.permissionDestination = permissionDestination;
	}
	
	public PermissionEntity(Permission permission) {
		super();
		this.permissionType = permission.getPermissionType();
		this.permissionStartDate = permission.getPermissionStartDate();
		this.permissionEndDate = permission.getPermissionEndDate();
		this.permissionObservation = permission.getPermissionObservation();
		this.permissionDestination = permission.getPermissionDestination();
	}
	
	public Permission toPermission() {
		Permission permission = new Permission(permissionId, permissionType, permissionStartDate, permissionEndDate, permissionObservation, permissionDestination);
        return permission;
    }
	
	
	
}
