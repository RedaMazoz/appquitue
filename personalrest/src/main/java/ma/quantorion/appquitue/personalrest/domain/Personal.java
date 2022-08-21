package ma.quantorion.appquitue.personalrest.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Personal
{
	private Long personalId;
	
	private String firstName;
	
	private String lastName;
	
	private int gsmNumber;
	
	private Date birthdate;
	
	private String birthplace;
	
	private String province;
	
	private String grade;
	
	private Date engagementDate;
	
	private String govId;
	
	private String bloodType;
	
	private String address;
	
	private String photo;
	
	private String city;
	
	private String matricule;
	
	private int somId;
	
	private String ccpId;
	
	private int gsmNumberPersonWhenAccident;
	
	private String addressPersonWhenAccident;
	
	private String contactPersonWhenAccident;
	
	private String wifeAddress;
	
	private String wifeJob;
	
	private String wifeFullname;
	
	private String mumJob;
	
	private String mumFullname;
	
	private String dadJob;
	
	private String dadFullname;
	
	private int childsCount;
	
	private String familySituation;
	
	private int affectationId;
	
	private String unit;
	
	private String currentFunction;
	
	private Date affectationDate;
	
	private String affectationReference;

	public Personal(Long personalId, String firstName, String lastName, int gsmNumber, Date birthdate, String birthplace,
			String province, String grade, Date engagementDate, String govId, String bloodType, String address,
			String photo, String city, String matricule, int somId, String ccpId, int gsmNumberPersonWhenAccident,
			String addressPersonWhenAccident, String contactPersonWhenAccident, String wifeAddress, String wifeJob,
			String wifeFullname, String mumJob, String mumFullname, String dadJob, String dadFullname, int childsCount,
			String familySituation, int affectationId, String unit, String currentFunction, Date affectationDate,
			String affectationReference) {
		super();
		this.personalId = personalId;
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
	
	
}
