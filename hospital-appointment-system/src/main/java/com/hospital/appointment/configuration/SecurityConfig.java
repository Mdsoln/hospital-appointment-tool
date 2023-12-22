package com.hospital.appointment.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    // TODO: 09/12/2023 b.secure api(s) by roles and authorities c.session handling

    @Autowired
    public UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests((authorise)->
                        authorise
                                .requestMatchers("/api/v1/doctor/add","/api/appointments/**","/api/v1/patient/save")
                                .permitAll()
                                .requestMatchers("/","/index","/index.html")
                                .permitAll()
                                .requestMatchers("/default","/about","/patient","/patient/save","/api/appointments/make")
                                .permitAll()
                ).formLogin(
                       form->
                               form
                                       .loginPage("/login")
                                       .loginProcessingUrl("/login")
                                       .defaultSuccessUrl("/default")
                ).logout(
                        logout->
                                logout
                                        .invalidateHttpSession(true)
                                        .clearAuthentication(true)
                                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
                                        .logoutSuccessUrl("/login?logout")
                );
        return http.build();
    }

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}

