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
public class Injury
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="injury_id")
	private Long injuryId;

	@Column(name="injury_type")
	private String injuryType;

	@Column(name="injury_date")
	private Date injuryDate;
	
	@Column(name="injury_place")
	private String injuryPlace;

	public Injury(String injuryType, Date injuryDate, String injuryPlace) {
		super();
		this.injuryType = injuryType;
		this.injuryDate = injuryDate;
		this.injuryPlace = injuryPlace;
	}
	
	
}
