package in.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Greet-API")  // Recommended Approach
//@FeignClient(url = "http://localhost:9091",name = "greet")
public interface GreetFeignClient {
	
	@GetMapping("/greet")
	public String invokeGreetApi();

}
