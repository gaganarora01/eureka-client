package com.example.eurekaclient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaClientController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/eurekaclient/getstudents", method = RequestMethod.GET)
	public List<String> getStudentNames() {
		return new ArrayList<String>(Arrays.asList("Vikram", "Sam", "Gagan"));
	}

	@RequestMapping(value = "/eurekaclient/getclient2info", method = RequestMethod.GET)
	public String getClient2Info() {
		System.out.println("Getting client configuration from client 2");

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		String response = restTemplate
				.exchange("http://config-client/getclientconf", HttpMethod.GET, entity, String.class).getBody();

		System.out.println("Response Received as " + response);

		return response;
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
