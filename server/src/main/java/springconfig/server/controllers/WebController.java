package springconfig.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springconfig.server.services.WebService;
import springconfig.server.utilities.Response;

@RestController
public class WebController {

	@Autowired
	WebService webService;

	@RequestMapping(value = "/server/read", method = RequestMethod.GET)
	public String[] read() {
		return webService.getAll();
	}

	@RequestMapping(value = "/server/add", method = RequestMethod.GET)
	public Response add() {
		return webService.add();
	}

	@RequestMapping(value = "/server/delete", method = RequestMethod.GET)
	public Response delete() {
		return webService.delete();
	}

	@RequestMapping(value = "/server/update", method = RequestMethod.GET)
	public Response update() {
		return webService.update();
	}
}
