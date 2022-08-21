package ma.quantorion.appquitue.injuryrest.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Injury
{
	
	private Long injuryId;
	
	private String injuryType;

	private Date injuryDate;

	private String injuryPlace;
	
	public Injury(Long injuryId, String injuryType, Date injuryDate, String injuryPlace) {
		super();
		this.injuryId = injuryId;
		this.injuryType = injuryType;
		this.injuryDate = injuryDate;
		this.injuryPlace = injuryPlace;
	}
	
	
}
