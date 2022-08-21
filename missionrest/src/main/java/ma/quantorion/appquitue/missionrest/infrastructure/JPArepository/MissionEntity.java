package ma.quantorion.appquitue.missionrest.infrastructure.JPArepository;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.quantorion.appquitue.missionrest.domain.Mission;

@Entity
@Data
@NoArgsConstructor
public class MissionEntity
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

	public MissionEntity(String missionDesignation, Date missionStartDate, Date missionEndDate) {
		super();
		this.missionDesignation = missionDesignation;
		this.missionStartDate = missionStartDate;
		this.missionEndDate = missionEndDate;
	}
	
	public MissionEntity(Mission mission) {
		super();
		this.missionStartDate = mission.getMissionStartDate();
		this.missionEndDate = mission.getMissionEndDate();
		this.missionDesignation = mission.getMissionDesignation();
	}
	
	public Mission toMission() {
		Mission mission = new Mission(missionId, missionDesignation, missionStartDate, missionEndDate);
        return mission;
    }
	
	
	
}
