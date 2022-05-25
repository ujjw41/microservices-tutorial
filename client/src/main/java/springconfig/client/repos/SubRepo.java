package springconfig.client.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import springconfig.client.entities.Subscription;

import java.util.List;

public interface SubRepo extends JpaRepository<Subscription, Long> {

}
