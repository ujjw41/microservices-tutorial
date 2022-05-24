package springcofing.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springcofing.server.services.WebService;
import springcofing.server.utilities.Response;

@RestController
public class WebController {

	@Autowired
	WebService webService;

	public String all() {

		return "all";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String[] read() {
		return webService.getall();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Response add() {
		return webService.postadd();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public Response delete() {
		return webService.delete();
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public Response update() {
		return webService.update();
	}
}
