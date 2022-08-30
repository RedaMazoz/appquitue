package ma.quantorion.appquitue.personalrest.infrastructure.JPArepository;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.quantorion.appquitue.personalrest.domain.Injury;

@Entity
@Data
@NoArgsConstructor
public class InjuryEntity
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

	public InjuryEntity(String injuryType, Date injuryDate, String injuryPlace) {
		super();
		this.injuryType = injuryType;
		this.injuryDate = injuryDate;
		this.injuryPlace = injuryPlace;
	}
	
	public InjuryEntity(Injury injury) {
		super();
		this.injuryType = injury.getInjuryType();
		this.injuryDate = injury.getInjuryDate();
		this.injuryPlace = injury.getInjuryPlace();
	}
	
	public Injury toInjury() {
		Injury injury = new Injury(injuryId, injuryType, injuryDate, injuryPlace);
        return injury;
    }
	
	
	
}
