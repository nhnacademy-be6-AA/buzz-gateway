package store.buzzbook.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

	@Bean
	public RouteLocator myRoute(RouteLocatorBuilder builder) {

		RouteLocator routeLocator = builder.routes().build();

		return builder.routes()
			.route("coupon-api",
				p -> p.path("/api/coupons/**").and()
					.uri("lb://eureka-server:8091/"))
			.route("core-api",
				p -> p.path("/api/account/**").and()
					.uri("lb://core-api:8090/"))
			.route("auth-api",
				p -> p.path("/api/auth/**").and()
					.uri("lb://auth-api:8100/"))
			.build();
	}
}
