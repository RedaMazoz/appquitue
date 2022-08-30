package ma.quantorion.appquitue.personalrest.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Condamnation
{
	
	private Long condamnationId;

	private String condamnationNature;
	
	private String condamnationPeriod;

	private String condamnationMotive;

	private Date condamnationDate;

	private String condamnationReference;
	
	public Condamnation(Long condamnationId, String condamnationNature, String condamnationPeriod, String condamnationMotive,
			Date condamnationDate, String condamnationReference) {
		super();
		this.condamnationId = condamnationId;
		this.condamnationNature = condamnationNature;
		this.condamnationPeriod = condamnationPeriod;
		this.condamnationMotive = condamnationMotive;
		this.condamnationDate = condamnationDate;
		this.condamnationReference = condamnationReference;
	}
	
	
}
