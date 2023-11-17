package com.vikas.rest.project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
/*
    // add support for JDBC... no more hardcoded users
    // tells Spring Security to ude JDBC authentication with our data source
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
 */

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");
        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET,"/magic-api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/magic-api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/magic-api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/magic-api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/magic-api/employees/**").hasRole("ADMIN")
        );
        // use HTTP Basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());
        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, GET, DELETE
        httpSecurity.csrf(csrf -> csrf.disable());
        return httpSecurity.build();
    }
}

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        // since we have defined our users, Spring will not use 'user' and 'password' from application.property file
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//        UserDetails suzan = User.builder()
//                .username("suzan")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(john, mary, suzan);
//    }