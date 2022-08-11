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
public class Condamnation
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
	private Date condamnationMotive;

	@Column(name="condamnation_date")
	private Date condamnationDate;

	@Column(name="condamnation_reference")
	private Date condamnationReference;
	
	public Condamnation(String condamnationNature, String condamnationPeriod, Date condamnationMotive,
			Date condamnationDate, Date condamnationReference) {
		super();
		this.condamnationNature = condamnationNature;
		this.condamnationPeriod = condamnationPeriod;
		this.condamnationMotive = condamnationMotive;
		this.condamnationDate = condamnationDate;
		this.condamnationReference = condamnationReference;
	}
}
