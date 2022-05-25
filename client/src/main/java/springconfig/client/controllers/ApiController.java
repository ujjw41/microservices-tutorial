package springconfig.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import springconfig.client.entities.Subscription;
import springconfig.client.services.SubService;
import springconfig.client.utilities.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Endpoint(id = "subs")
@Component
public class ApiController {

	@Autowired
	SubService subService;

	@ResponseBody
	@WriteOperation
	@PostMapping("/api/add")
	public Response add(@RequestBody Subscription subscription) {
		subService.save(subscription);
		return new Response("success", "thank you");
	}

	@GetMapping(value = {"/api/read", "/api/read/{id}"})
	public List<Subscription> read(@PathVariable("id") Optional<Long> id) {
		if (id.isEmpty()) {
			return subService.getAll();
		}
		Subscription subscription = subService.get(id.get());
		List<Subscription> list = new ArrayList<>();
		list.add(subscription);
		return list;
	}

	@ReadOperation
	@GetMapping("/api/readall")
	public List<Subscription> readAll() {
		return subService.getAll();
	}

	@ResponseBody
	@DeleteOperation
	@DeleteMapping("/api/delete")
	public Response delete(@RequestBody Subscription subscription) {
		subService.delete(subscription);

		return new Response("success", "DELETED");
	}

	@ResponseBody
	@WriteOperation
	@PutMapping("/api/update")
	public Response update(@RequestBody Subscription subscription) {

		subService.update(subscription);

		return new Response("success", "UPDATED");
	}

}
