package in.api.rest;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class DataRestController {
	
	
	@GetMapping("/data")
	@HystrixCommand(fallbackMethod = "getDataFrpomDB",
					commandProperties = {
							@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "3"),
							@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "50000")
							
					}
	)
	public String getDataFromRedis() {
		System.out.println("**Redis() method called**");
		Integer i = new Random().nextInt();
//		int i=3;
		System.out.println(i);

		if(i<=10) {
			System.out.println("Random Number : "+i);
			throw new RuntimeException("Redis Server Is Down");
		}
		//logic to access data from redis
		
		return "data accessed from redis (main logic)....";
	}
	
	
	public String getDataFrpomDB() {
		System.out.println("**DB() method called**");
		
		//logic to access data from DB
		return "data accessed from database (fall back logic)....";
	}

}
