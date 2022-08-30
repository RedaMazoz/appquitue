package ma.quantorion.appquitue.personalrest.infrastructure.JPArepository;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.quantorion.appquitue.personalrest.domain.Diploma;

@Entity
@Data
@NoArgsConstructor
public class DiplomaEntity
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="diploma_id")
	private Long diplomaId;

	@Column(name="diploma_type")
	private String diplomaType;
	
	@Column(name="diploma_designation")
	private String diplomaDesignation;

	@Column(name="diploma_date_obtained")
	private Date diplomaDateObtained;

	public DiplomaEntity(String diplomaType, String diplomaDesignation, Date diplomaDateObtained) {
		super();
		this.diplomaType = diplomaType;
		this.diplomaDesignation = diplomaDesignation;
		this.diplomaDateObtained = diplomaDateObtained;
	}

	public DiplomaEntity(Diploma diploma) {
		super();
		this.diplomaId = diploma.getDiplomaId();
		this.diplomaType = diploma.getDiplomaType();
		this.diplomaDesignation = diploma.getDiplomaDesignation();
		this.diplomaDateObtained = diploma.getDiplomaDateObtained();
	}
	
	public Diploma toDiploma() {
		Diploma personal = new Diploma(diplomaId, diplomaType, diplomaDesignation, diplomaDateObtained);
        return personal;
    }
	
	
	
}
