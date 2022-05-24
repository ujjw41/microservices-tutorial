package springcofing.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import springcofing.client.entities.Subscription;
import springcofing.client.services.SubService;
import springcofing.client.utilities.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Endpoint(id = "subc")
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

	@GetMapping(value = {"/read", "/read/{id}"})
	public List<Subscription> myread(@PathVariable("id") Optional<Long> id) {
		if (id.isEmpty()) {
			return subService.getall();
		}
		Subscription subscription = subService.get(id.get());
		List<Subscription> list = new ArrayList<>();
		list.add(subscription);
		return list;
	}

	@ReadOperation
	@GetMapping("/api/readall")
	public List<Subscription> readall() {
		return subService.getall();
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

		return new Response("success", "Updated");
	}

}
