package in.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import in.api.GreetFeignClient;


@RestController
public class WelcomeRestController {
	
	@Autowired
	private GreetFeignClient greetClient;
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		String welcomeMsg = "Welcome To Ashok IT";
		String greetMsg = greetClient.invokeGreetApi();
		return greetMsg +", "+welcomeMsg;
	}
}
