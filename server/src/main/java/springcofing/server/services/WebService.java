package springcofing.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springcofing.server.utilities.Response;
import springcofing.server.utilities.Subscription;

import java.util.Arrays;
import java.util.List;

@Service
public class WebService {
	@Autowired
	RestTemplate restTemplate;

	public String[] getall() {

		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

		HttpEntity entity = new HttpEntity<>( httpHeaders );

		return new String[]{restTemplate.exchange("http://localhost:8080/read", HttpMethod.GET, entity, String.class).getBody()};
	}

	public Response postadd() {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

		HttpEntity entity = new HttpEntity<Subscription>(  new Subscription(23L , "testing@gmail.com") , httpHeaders  );

		return restTemplate.exchange( "http://localhost:8080/api/add" , HttpMethod.POST , entity, Response.class ).getBody();
	}
}
