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
public class Punishment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="punishment_id")
	private Long punishmentId;

	@Column(name="punishment_days_number")
	private String punishmentDaysNumber;
	
	@Column(name="punishment_motive")
	private String punishmentMotive;

	@Column(name="punishment_date")
	private Date punishmentDate;

	public Punishment(String punishmentDaysNumber, String punishmentMotive, Date punishmentDate) {
		super();
		this.punishmentDaysNumber = punishmentDaysNumber;
		this.punishmentMotive = punishmentMotive;
		this.punishmentDate = punishmentDate;
	}
	
	
}
