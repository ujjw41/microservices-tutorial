package springconfig.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springconfig.server.utilities.Response;
import springconfig.server.utilities.Subscription;

import java.util.List;

@Service
public class WebService {
	@Autowired
	RestTemplate restTemplate;

	public String[] getAll() {

		HttpHeaders httpHeader = new HttpHeaders();

		httpHeader.setAccept(List.of(MediaType.APPLICATION_JSON));

		HttpEntity httpEntity = new HttpEntity (httpHeader);

		return new String[]{restTemplate.exchange("http://EUREKACLIENT/api/read", HttpMethod.GET, httpEntity, String.class).getBody()};
	}

	public Response add() {

		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.setAccept(List.of(MediaType.APPLICATION_JSON));

		HttpEntity<Subscription> httpEntity = new HttpEntity(new Subscription(10L, "phoenix@github.com"), httpHeader);

		return restTemplate.exchange("http://EUREKACLIENT/api/add", HttpMethod.POST, httpEntity, Response.class).getBody();
	}

	public Response delete() {
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.setAccept(List.of(MediaType.APPLICATION_JSON));

		HttpEntity<Subscription> httpEntity = new HttpEntity (new Subscription(6L, "rinzai@123.com"), httpHeader);

		return restTemplate.exchange("http://EUREKACLIENT/api/delete", HttpMethod.DELETE, httpEntity, Response.class).getBody();
	}

	public Response update() {
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.setAccept(List.of(MediaType.APPLICATION_JSON));
		HttpEntity<Subscription> httpEntity = new HttpEntity (new Subscription(7L, "changed@api.in"), httpHeader);
		return restTemplate.exchange("http://EUREKACLIENT/api/update", HttpMethod.PUT, httpEntity, Response.class).getBody();
	}
}
