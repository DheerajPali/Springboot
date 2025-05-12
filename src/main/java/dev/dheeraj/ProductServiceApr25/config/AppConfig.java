package dev.dheeraj.ProductServiceApr25.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}


//Configuration -> Spring executes this class during initial build
// and calls all the methods of this class.

//whatever each method returns,
// it gets injected in the IoC containers as a Bean[object]

//This allows us to use those objects as dependencies at multiple places.
