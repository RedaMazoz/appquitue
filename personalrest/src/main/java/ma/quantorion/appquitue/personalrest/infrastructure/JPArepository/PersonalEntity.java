package ma.quantorion.appquitue.personalrest.infrastructure.JPArepository;

import java.util.Date;

import javax.persistence.Column;
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

	public PersonalEntity(String firstName, String lastName, int gsmNumber, Date birthdate, String birthplace,
			String province, String grade, Date engagementDate, String govId, String bloodType, String address,
			String photo, String city, String matricule, int somId, String ccpId, int gsmNumberPersonWhenAccident,
			String addressPersonWhenAccident, String contactPersonWhenAccident, String wifeAddress, String wifeJob,
			String wifeFullname, String mumJob, String mumFullname, String dadJob, String dadFullname, int childsCount,
			String familySituation, int affectationId, String unit, String currentFunction, Date affectationDate,
			String affectationReference) {
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
	}
	
	public Personal toPersonal() {
		Personal personal = new Personal(personalId, firstName, lastName, gsmNumber, birthdate, birthplace,
				province, grade, engagementDate, govId, bloodType, address,
				photo, city, matricule, somId, ccpId, gsmNumberPersonWhenAccident,
				addressPersonWhenAccident, contactPersonWhenAccident, wifeAddress, wifeJob,
				wifeFullname, mumJob, mumFullname, dadJob, dadFullname, childsCount,
				familySituation, affectationId, unit, currentFunction, affectationDate,
				affectationReference);
        return personal;
    }
	
	
	
}
