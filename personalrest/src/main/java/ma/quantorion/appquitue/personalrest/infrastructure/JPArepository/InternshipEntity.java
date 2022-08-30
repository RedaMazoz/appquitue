package ma.quantorion.appquitue.personalrest.infrastructure.JPArepository;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.quantorion.appquitue.personalrest.domain.Internship;

@Entity
@Data
@NoArgsConstructor
public class InternshipEntity
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
	private Date internshipEndDate;
	
	@Column(name="internship_place")
	private String internshipPlace;
	
	@Column(name="internship_reference")
	private String internshipReference;

	public InternshipEntity(String internshipDesignation, Date internshipStartDate, Date internshipEndDate,
			String internshipPlace, String internshipReference) {
		super();
		this.internshipDesignation = internshipDesignation;
		this.internshipStartDate = internshipStartDate;
		this.internshipEndDate = internshipEndDate;
		this.internshipPlace = internshipPlace;
		this.internshipReference = internshipReference;
	}
	
	public InternshipEntity(Internship internship) {
		super();
		this.internshipDesignation = internship.getInternshipDesignation();
		this.internshipStartDate = internship.getInternshipStartDate();
		this.internshipEndDate = internship.getInternshipEndDate();
		this.internshipPlace = internship.getInternshipPlace();
		this.internshipReference = internship.getInternshipReference();
	}
	
	public Internship toInternship() {
		Internship internship = new Internship(internshipId, internshipDesignation, internshipStartDate, internshipEndDate, internshipPlace, internshipReference);
        return internship;
    }
	
	
	
}
