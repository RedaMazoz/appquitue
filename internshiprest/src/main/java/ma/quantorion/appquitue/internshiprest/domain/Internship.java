package ma.quantorion.appquitue.internshiprest.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Internship
{
	
	private Long internshipId;
	
	private String internshipDesignation;

	private Date internshipStartDate;
	
	private Date internshipEndDate;
	
	private String internshipPlace;
	
	private String internshipReference;

	public Internship(Long internshipId, String internshipDesignation, Date internshipStartDate, Date internshipEndDate, String internshipPlace, String internshipReference) {
		super();
		this.internshipId= internshipId;
		this.internshipDesignation = internshipDesignation;
		this.internshipStartDate = internshipStartDate;
		this.internshipEndDate = internshipEndDate;
		this.internshipPlace = internshipPlace;
		this.internshipReference = internshipReference;
	}
	
	
}
