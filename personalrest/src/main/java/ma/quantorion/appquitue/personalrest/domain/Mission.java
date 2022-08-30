package ma.quantorion.appquitue.personalrest.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Mission
{
	
	private Long missionId;
	
	private String missionDesignation;

	private Date missionStartDate;

	private Date missionEndDate;

	public Mission(Long missionId, String missionDesignation, Date missionStartDate, Date missionEndDate) {
		super();
		this.missionId = missionId;
		this.missionDesignation = missionDesignation;
		this.missionStartDate = missionStartDate;
		this.missionEndDate = missionEndDate;
	}
	
	
}
