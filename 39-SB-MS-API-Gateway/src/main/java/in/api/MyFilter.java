package in.api;

import java.util.*;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class MyFilter implements GlobalFilter{

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = exchange.getRequest();
		HttpHeaders headers = request.getHeaders();
		Set<String> keySet = headers.keySet();
		
		for(String key : keySet) {
			List<String> values = headers.get(key);
			System.out.println(key + " :: " + values);
		}
		System.out.println( request.getBody());
		
		//check for token in header
		
		
		return chain.filter(exchange);
	}

}
