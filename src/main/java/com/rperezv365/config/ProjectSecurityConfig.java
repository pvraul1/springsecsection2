package com.rperezv365.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * ProjectSecurityConfig
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 14/03/2025 - 21:02
 * @since 1.17
 */
@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) -> request
                .requestMatchers("/myAccount","/myBalance","/myLoans","myCards").authenticated()
                .requestMatchers("/notices","/contact","/error").permitAll());
        http.formLogin(Customizer.withDefaults());
        //http.formLogin(flc -> flc.disable());
        http.httpBasic(Customizer.withDefaults());
        //http.httpBasic((flb -> flb.disable()));

        return http.build();
    }


}
