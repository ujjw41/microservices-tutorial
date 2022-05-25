package springconfig.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springconfig.client.entities.Subscription;
import springconfig.client.repos.SubRepo;

import java.util.List;
import java.util.Optional;

@Service
public class SubService {
	@Autowired
	SubRepo subRepo;

	public void save(Subscription subscription) {
		subRepo.save(subscription);
	}

	public Subscription get(Long id) {
		Optional<Subscription> optional = subRepo.findById(id);

		return optional.orElse(null);
	}

	public void delete(Subscription subscription) {
		subRepo.delete(subscription);

	}

	public void update(Subscription subscription) {
		subRepo.save(subscription);
	}

	public List<Subscription> getAll() {
		return subRepo.findAll();
	}

}
