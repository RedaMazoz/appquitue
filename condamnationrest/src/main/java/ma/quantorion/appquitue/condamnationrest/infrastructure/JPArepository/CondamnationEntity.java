package ma.quantorion.appquitue.condamnationrest.infrastructure.JPArepository;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.quantorion.appquitue.condamnationrest.domain.Condamnation;

@Entity
@Data
@NoArgsConstructor
public class CondamnationEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="condamnation_id")
	private Long condamnationId;

	@Column(name="condamnation_nature")
	private String condamnationNature;
	
	@Column(name="condamnation_period")
	private String condamnationPeriod;

	@Column(name="condamnation_motive")
	private String condamnationMotive;

	@Column(name="condamnation_date")
	private Date condamnationDate;

	@Column(name="condamnation_reference")
	private String condamnationReference;
	
	public CondamnationEntity(String condamnationNature, String condamnationPeriod, String condamnationMotive,
			Date condamnationDate, String condamnationReference) {
		super();
		this.condamnationNature = condamnationNature;
		this.condamnationPeriod = condamnationPeriod;
		this.condamnationMotive = condamnationMotive;
		this.condamnationDate = condamnationDate;
		this.condamnationReference = condamnationReference;
	}
	
	public CondamnationEntity(Condamnation condamnation) {
		super();
		this.condamnationNature = condamnation.getCondamnationNature();
		this.condamnationPeriod = condamnation.getCondamnationPeriod();
		this.condamnationMotive = condamnation.getCondamnationMotive();
		this.condamnationDate = condamnation.getCondamnationDate();
		this.condamnationReference = condamnation.getCondamnationReference();
	}
	
	public Condamnation toCondamnation() {
		Condamnation condamnation = new Condamnation(condamnationId, condamnationNature, condamnationPeriod, condamnationMotive, condamnationDate, condamnationReference);
        return condamnation;
    }
	
	
	
}
