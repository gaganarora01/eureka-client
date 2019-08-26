package com.example.eurekaclient;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HystrixController {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallbackHandler")
	@RequestMapping(value = "/eurekaclient/hysterix/getclient2info", method = RequestMethod.GET)
	public String getClient2InfoHysterix() {
		System.out.println("Getting client configuration from client 1");

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		String response = restTemplate
				.exchange("http://config-client/getclientconf", HttpMethod.GET, entity, String.class).getBody();

		System.out.println("Response Received as " + response);

		return response;
	}

	public String fallbackHandler() {
		return "Fallback Initiated!";
	}	
}
