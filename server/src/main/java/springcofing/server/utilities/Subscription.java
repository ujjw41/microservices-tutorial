package springcofing.server.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	String email;

}
