package ma.quantorion.appquitue.personalrest.infrastructure.JPArepository;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.quantorion.appquitue.personalrest.domain.Punishment;

@Entity
@Data
@NoArgsConstructor
public class PunishmentEntity
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="punishment_id")
	private Long punishmentId;

	@Column(name="punishment_days_number")
	private int punishmentDaysNumber;
	
	@Column(name="punishment_motive")
	private String punishmentMotive;

	@Column(name="punishment_date")
	private Date punishmentDate;

	public PunishmentEntity(int punishmentDaysNumber, String punishmentMotive, Date punishmentDate) {
		super();
		this.punishmentDaysNumber = punishmentDaysNumber;
		this.punishmentMotive = punishmentMotive;
		this.punishmentDate = punishmentDate;
	}
	
	public PunishmentEntity(Punishment punishment) {
		super();
		this.punishmentDaysNumber = punishment.getPunishmentDaysNumber();
		this.punishmentMotive = punishment.getPunishmentMotive();
		this.punishmentDate = punishment.getPunishmentDate();
	}
	
	public Punishment toPunishment() {
		Punishment punishment = new Punishment(punishmentId, punishmentDaysNumber, punishmentMotive, punishmentDate);
        return punishment;
    }
	
	
	
}
