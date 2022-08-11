package ma.quantorion.appquitue.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Internship
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="internship_id")
	private Long internshipId;
	
	@Column(name="internship_designation")
	private String internshipDesignation;

	@Column(name="internship_start_date")
	private Date internshipStartDate;
	
	@Column(name="internship_end_date")
	private String internshipEndDate;
	
	@Column(name="internship_place")
	private String internshipPlace;
	
	@Column(name="internship_reference")
	private String internshipReference;

	public Internship(String internshipDesignation, Date internshipStartDate, String internshipEndDate,
			String internshipPlace, String internshipReference) {
		super();
		this.internshipDesignation = internshipDesignation;
		this.internshipStartDate = internshipStartDate;
		this.internshipEndDate = internshipEndDate;
		this.internshipPlace = internshipPlace;
		this.internshipReference = internshipReference;
	}
	
	
}
