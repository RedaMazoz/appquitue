package ma.quantorion.appquitue.personalrest.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Punishment
{
	
	private Long punishmentId;
	
	private int punishmentDaysNumber;

	private String punishmentMotive;
	
	private Date punishmentDate;

	public Punishment(Long punishmentId, int punishmentDaysNumber, String punishmentMotive, Date punishmentDate) {
		super(); 
		this.punishmentId = punishmentId;
		this.punishmentDaysNumber = punishmentDaysNumber;
		this.punishmentMotive = punishmentMotive;
		this.punishmentDate = punishmentDate;
	}
	
	
}
