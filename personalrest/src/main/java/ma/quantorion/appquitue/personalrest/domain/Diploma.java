package ma.quantorion.appquitue.personalrest.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Diploma
{
	private Long diplomaId;
	
	private String diplomaType;
	
	private String diplomaDesignation;

	private Date diplomaDateObtained;

	public Diploma(Long diplomaId, String diplomaType, String diplomaDesignation, Date diplomaDateObtained) {
		super();
		this.diplomaId = diplomaId;
		this.diplomaType = diplomaType;
		this.diplomaDesignation = diplomaDesignation;
		this.diplomaDateObtained = diplomaDateObtained;
	}
	
	
}
