package com.academy.airline.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import jakarta.servlet.DispatcherType;



@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean 
    public PasswordEncoder passwordEncoder() { 
        return new BCryptPasswordEncoder(); 
    }

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Bean
    public SecurityFilterChain fillterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        return http
            .authorizeHttpRequests((auth) -> auth
                .requestMatchers(AntPathRequestMatcher.antMatcher("/employee/**")).hasRole("HR")
                .requestMatchers(AntPathRequestMatcher.antMatcher("/employee")).hasRole("HR")
                .requestMatchers(AntPathRequestMatcher.antMatcher("/")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/css/**")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/images/**")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/js/**")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/schedule")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/account")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/registration")).anonymous()
                .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR, DispatcherType.INCLUDE).permitAll()
                .anyRequest().authenticated())
            .formLogin((form) -> form
                .loginPage("/login")
                .defaultSuccessUrl("/account")
                .permitAll()
            )
            .logout((page) -> page
                .permitAll()
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
            )
            .build();
    } 

}
