package springcofing.client.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import springcofing.client.entities.Subscription;

import java.util.List;

public interface SubRepo extends JpaRepository<Subscription, Long> {

	List<Subscription> deleteByEmail(String email);
}
