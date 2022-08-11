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
public class Mission
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="mission_id")
	private Long missionId;

	@Column(name="mission_designation")
	private String missionDesignation;

	@Column(name="mission_start_date")
	private Date missionStartDate;

	@Column(name="mission_end_date")
	private Date missionEndDate;

	public Mission(String missionDesignation, Date missionStartDate, Date missionEndDate) {
		super();
		this.missionDesignation = missionDesignation;
		this.missionStartDate = missionStartDate;
		this.missionEndDate = missionEndDate;
	}
	
	
}
