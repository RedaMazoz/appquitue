package ma.quantorion.appquitue.personalrest.infrastructure.JPArepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import ma.quantorion.appquitue.personalrest.domain.Personal;

@Entity
@Data
@NoArgsConstructor
public class PersonalEntity
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long personalId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gsm_number")
	private int gsmNumber;
	
	private Date birthdate;
	
	private String birthplace;
	
	private String province;
	
	private String grade;
	
	@Column(name= "engagment_date")
	private Date engagementDate;
	
	@Column(name= "gov_id")
	private String govId;
	
	@Column(name="blood_type")
	private String bloodType;
	
	private String address;
	
	private String photo;
	
	private String city;
	
	private String matricule;
	
	@Column(name="som_id")
	private int somId;
	
	@Column(name="ccp_id")
	private String ccpId;
	
	@Column(name="gsm_number_person_when_accident")
	private int gsmNumberPersonWhenAccident;
	
	@Column(name="address_person_when_accident")
	private String addressPersonWhenAccident;
	
	@Column(name="contact_person_when_accident")
	private String contactPersonWhenAccident;
	
	@Column(name="wife_address")
	private String wifeAddress;
	
	@Column(name="wife_job")
	private String wifeJob;
	
	@Column(name="wife_fullname")
	private String wifeFullname;
	
	@Column(name="mum_job")
	private String mumJob;
	
	@Column(name="mum_fullname")
	private String mumFullname;
	
	@Column(name="dad_job")
	private String dadJob;
	
	@Column(name="dad_fullname")
	private String dadFullname;
	
	@Column(name="childs_count")
	private int childsCount;
	
	@Column(name="family_situation")
	private String familySituation;
	
	@Column(name="affectation_id")
	private int affectationId;
	
	private String unit;
	
	@Column(name="current_function")
	private String currentFunction;
	
	@Column(name="affectation_date")
	private Date affectationDate;
	
	@Column(name="affectation_reference")
	private String affectationReference;
	
	@ElementCollection
	private List<CondamnationEntity> condamnations;
	@ElementCollection
	private List<DiplomaEntity> diplomas;
	@ElementCollection
	private List<InjuryEntity> injuries;
	@ElementCollection
	private List<InternshipEntity> internships;
	@ElementCollection
	private List<MissionEntity> missions;
	@ElementCollection
	private List<PermissionEntity> permissions;
	@ElementCollection
	private List<PunishmentEntity> punishments;

	public PersonalEntity(String firstName, String lastName, int gsmNumber, Date birthdate, String birthplace,
			String province, String grade, Date engagementDate, String govId, String bloodType, String address,
			String photo, String city, String matricule, int somId, String ccpId, int gsmNumberPersonWhenAccident,
			String addressPersonWhenAccident, String contactPersonWhenAccident, String wifeAddress, String wifeJob,
			String wifeFullname, String mumJob, String mumFullname, String dadJob, String dadFullname, int childsCount,
			String familySituation, int affectationId, String unit, String currentFunction, Date affectationDate,
			String affectationReference, List<CondamnationEntity> condamnations, List<DiplomaEntity> diplomas, List<InjuryEntity> injuries, List<InternshipEntity> internships, List<MissionEntity> missions, List<PermissionEntity> permissions, List<PunishmentEntity> punishments) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gsmNumber = gsmNumber;
		this.birthdate = birthdate;
		this.birthplace = birthplace;
		this.province = province;
		this.grade = grade;
		this.engagementDate = engagementDate;
		this.govId = govId;
		this.bloodType = bloodType;
		this.address = address;
		this.photo = photo;
		this.city = city;
		this.matricule = matricule;
		this.somId = somId;
		this.ccpId = ccpId;
		this.gsmNumberPersonWhenAccident = gsmNumberPersonWhenAccident;
		this.addressPersonWhenAccident = addressPersonWhenAccident;
		this.contactPersonWhenAccident = contactPersonWhenAccident;
		this.wifeAddress = wifeAddress;
		this.wifeJob = wifeJob;
		this.wifeFullname = wifeFullname;
		this.mumJob = mumJob;
		this.mumFullname = mumFullname;
		this.dadJob = dadJob;
		this.dadFullname = dadFullname;
		this.childsCount = childsCount;
		this.familySituation = familySituation;
		this.affectationId = affectationId;
		this.unit = unit;
		this.currentFunction = currentFunction;
		this.affectationDate = affectationDate;
		this.affectationReference = affectationReference;
		
		this.condamnations = condamnations;
		this.diplomas = diplomas;
		this.injuries = injuries;
		this.internships = internships;
		this.missions = missions;
		this.permissions = permissions;
		this.punishments = punishments;
	}
	
	public PersonalEntity(Personal personal) {
		super();
		this.firstName = personal.getFirstName();
		this.lastName = personal.getLastName();
		this.gsmNumber = personal.getGsmNumber();
		this.birthdate = personal.getBirthdate();
		this.birthplace = personal.getBirthplace();
		this.province = personal.getProvince();
		this.grade = personal.getGrade();
		this.engagementDate = personal.getEngagementDate();
		this.govId = personal.getGovId();
		this.bloodType = personal.getBloodType();
		this.address = personal.getAddress();
		this.photo = personal.getPhoto();
		this.city = personal.getCity();
		this.matricule = personal.getMatricule();
		this.somId = personal.getSomId();
		this.ccpId = personal.getCcpId();
		this.gsmNumberPersonWhenAccident = personal.getGsmNumberPersonWhenAccident();
		this.addressPersonWhenAccident = personal.getAddressPersonWhenAccident();
		this.contactPersonWhenAccident = personal.getContactPersonWhenAccident();
		this.wifeAddress = personal.getWifeAddress();
		this.wifeJob = personal.getWifeJob();
		this.wifeFullname = personal.getWifeFullname();
		this.mumJob = personal.getMumJob();
		this.mumFullname = personal.getMumFullname();
		this.dadJob = personal.getDadJob();
		this.dadFullname = personal.getDadFullname();
		this.childsCount = personal.getChildsCount();
		this.familySituation = personal.getFamilySituation();
		this.affectationId = personal.getAffectationId();
		this.unit = personal.getUnit();
		this.currentFunction = personal.getCurrentFunction();
		this.affectationDate = personal.getAffectationDate();
		this.affectationReference = personal.getAffectationReference();
		
		this.condamnations = personal.getCondamnations().stream()
				.map(condamnation -> { return new CondamnationEntity(condamnation);})
				.collect(Collectors.toList());
		this.diplomas = personal.getDiplomas().stream()
				.map(diploma -> { return new DiplomaEntity(diploma);})
				.collect(Collectors.toList());
		this.injuries = personal.getInjuries().stream()
				.map(injury -> { return new InjuryEntity(injury);})
				.collect(Collectors.toList());
		this.internships = personal.getInternships().stream()
				.map(internship -> { return new InternshipEntity(internship);})
				.collect(Collectors.toList());
		this.missions = personal.getMissions().stream()
				.map(mission -> { return new MissionEntity(mission);})
				.collect(Collectors.toList());
		this.permissions = personal.getPermissions().stream()
				.map(permission -> { return new PermissionEntity(permission);})
				.collect(Collectors.toList());
		this.punishments = personal.getPunishments().stream()
				.map(punishment -> { return new PunishmentEntity(punishment);})
				.collect(Collectors.toList());;
	}
	
	public Personal toPersonal() {
		Personal personal = new Personal(personalId, firstName, lastName, gsmNumber, birthdate, birthplace,
				province, grade, engagementDate, govId, bloodType, address,
				photo, city, matricule, somId, ccpId, gsmNumberPersonWhenAccident,
				addressPersonWhenAccident, contactPersonWhenAccident, wifeAddress, wifeJob,
				wifeFullname, mumJob, mumFullname, dadJob, dadFullname, childsCount,
				familySituation, affectationId, unit, currentFunction, affectationDate,
				affectationReference,
				
				
				condamnations.stream()
				.map(condamnationEntity -> { return condamnationEntity.toCondamnation();})
				.collect(Collectors.toList()),
				diplomas.stream()
				.map(diplomaEntity -> { return diplomaEntity.toDiploma();})
				.collect(Collectors.toList()),
				injuries.stream()
				.map(injuryEntity -> { return injuryEntity.toInjury();})
				.collect(Collectors.toList()),
				internships.stream()
				.map(internshipEntity -> { return internshipEntity.toInternship();})
				.collect(Collectors.toList()),
				missions.stream()
				.map(missionEntity -> { return missionEntity.toMission();})
				.collect(Collectors.toList()),
				permissions.stream()
				.map(permissionEntity -> { return permissionEntity.toPermission();})
				.collect(Collectors.toList()),
				punishments.stream()
				.map(punishmentEntity -> { return punishmentEntity.toPunishment();})
				.collect(Collectors.toList())
				);
        return personal;
    }
	
	
	
}
