package org.ict.lookism.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.NullRequestCache;

@Configuration
public class SecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) {
        return http
                .authorizeHttpRequests(auth -> auth
                        .dispatcherTypeMatchers(DispatcherType.ERROR).permitAll()
                        .requestMatchers(HttpMethod.GET, "/", "/index.html", "/assets/**",
                                "/members/csrf", "/members/signup-options").permitAll()
                        .requestMatchers(HttpMethod.POST, "/members/signup", "/members/signin", "/members/email").permitAll()
                        .requestMatchers(HttpMethod.GET, "/members/me").authenticated()
                        .requestMatchers("/boards", "/boards/**", "/discovery", "/discovery/**").authenticated()
                        .anyRequest().denyAll())
                .requestCache(cache -> cache.requestCache(new NullRequestCache()))
                .exceptionHandling(errors -> errors.authenticationEntryPoint((request, response, failure) ->
                        response.setStatus(401)))
                .formLogin(login -> login.loginProcessingUrl("/members/signin")
                        .usernameParameter("userEmail").passwordParameter("userPwd")
                        .successHandler((request, response, authentication) -> response.setStatus(204))
                        .failureHandler((request, response, failure) -> response.setStatus(401)))
                .logout(logout -> logout.logoutUrl("/members/signout")
                        .logoutSuccessHandler((request, response, authentication) -> response.setStatus(204)))
                .build();
    }
}
