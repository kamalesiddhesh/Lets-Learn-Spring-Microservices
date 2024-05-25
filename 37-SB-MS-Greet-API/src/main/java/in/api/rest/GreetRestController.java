package in.api.rest;

import org.springframework.web.bind.annotation.GetMapping;

public class GreetRestController {
	
	@GetMapping("/greet")
	public String greetMsg() {
		return "Good Evening";
	}

}
