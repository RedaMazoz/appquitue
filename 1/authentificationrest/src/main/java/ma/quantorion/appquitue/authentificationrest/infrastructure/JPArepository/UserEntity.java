package ma.quantorion.appquitue.authentificationrest.infrastructure.JPArepository;


import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.quantorion.appquitue.authentificationrest.domain.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String email;
	
	private String password;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	private List<RoleEntity> userRoles;
	
	public UserEntity(String email, String password, List<RoleEntity> userRoles) {
		super();
		this.email = email;
		this.password = password;
		this.userRoles = userRoles;
	}
	
	public UserEntity(User user) {
		super();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.userRoles = user.getUserRoles()
				.stream()
		        .map(role ->
		          new RoleEntity(role))
		        .collect(Collectors.toList());
	}
	
	public User toUser() {
		User user = new User(userId, email, password, userRoles.stream()
		        .map(roleEntity ->
		          roleEntity.toRole())
		        .collect(Collectors.toList()));
        return user;
    }
	
	
	
}
