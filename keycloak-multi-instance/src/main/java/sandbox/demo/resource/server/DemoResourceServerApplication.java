package sandbox.demo.resource.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class DemoResourceServerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(DemoResourceServerApplication.class, args);
    }

    @Configuration
    @EnableWebSecurity
    public static class SecurityConfig
    {
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
        {
            http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )
                .oauth2Login(Customizer.withDefaults())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

            return http.build();
        }
    }
}
