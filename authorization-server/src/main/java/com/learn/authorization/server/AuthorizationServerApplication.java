package com.learn.authorization.server;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.*;

@SpringBootApplication
public class AuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }

    @Bean
    UserDetailsService userDetailsService() {
        var userBuilder = User.builder();
        return new InMemoryUserDetailsManager(
                userBuilder
                        .roles("read")
                        .username("user")
                        .password("{bcrypt}$2a$12$7ZfJN0HyvbTC7ZAOXxDRvOQSzBMbPhZ0VIdXlzbMXOrOlq.LeS3zO")
                        .build(),
                userBuilder
                        .roles("read", "write")
                        .username("admin")
                        .password("{bcrypt}$2a$04$78dIIJxxv/01FVBtXZOi1OKAUNeEcR7uxeoB/ZaZ1HY9up/hPGVLG")
                        .build()
        );
    }

}
