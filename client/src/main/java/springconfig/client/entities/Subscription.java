package springconfig.client.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Email
	String email;

}
