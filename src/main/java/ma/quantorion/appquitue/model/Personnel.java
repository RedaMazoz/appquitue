package ma.quantorion.appquitue.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Personnel
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personnelId;
	
	private String firstName;
	private String lastName;
	
	public Personnel() { }
	public Personnel(String firstName, String lastName)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getPersonnelId() {
		return personnelId;
	}

	public void setPersonnelId(Long personnelId) {
		this.personnelId = personnelId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
