package ma.quantorion.appquitue.personalrest.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Permission
{
	
	private Long permissionId;
	
	private String permissionType;

	private Date permissionStartDate;

	private Date permissionEndDate;
	
	private String permissionObservation;
	
	private String permissionDestination;

	public Permission(Long permissionId, String permissionType, Date permissionStartDate, Date permissionEndDate,
			String permissionObservation, String permissionDestination) {
		super();
		this.permissionId = permissionId;
		this.permissionType = permissionType;
		this.permissionStartDate = permissionStartDate;
		this.permissionEndDate = permissionEndDate;
		this.permissionObservation = permissionObservation;
		this.permissionDestination = permissionDestination;
	}
	
	
}
