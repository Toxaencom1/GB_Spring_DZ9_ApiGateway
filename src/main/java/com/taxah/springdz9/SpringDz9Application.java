package com.taxah.springdz9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDz9Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDz9Application.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("Client",r->r.path("/client/**")
                        .uri("http://localhost:8080/"))
                .route("Payment",r->r.path("/payment/**")
                        .uri("http://localhost:8081/"))
                .route("Storehouse",r->r.path("/store/**")
                        .uri("http://localhost:8079/")).build();
    }
}
