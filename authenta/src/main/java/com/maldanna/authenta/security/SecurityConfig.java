package com.maldanna.authenta.security;

import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected InMemoryUserDetailsManager configAuthentication() {
        UserDetails admin=User.withUsername("user1")
                            .password("user1")
                            .authorities("ADMIN").build();


       List<UserDetails> users = new ArrayList<>();
       users.add(admin);
       /*List<GrantedAuthority> adminAuthority = new ArrayList<>();
       adminAuthority.add(new SimpleGrantedAuthority("AUTHENTA"));
       UserDetails admin= new User("user1","user1", adminAuthority);
       users.add(admin);

      /List<GrantedAuthority> employeeAuthority = new ArrayList<>();
       adminAuthority.add(new SimpleGrantedAuthority("USER"));
       UserDetails employee= new User("user2","user2",employeeAuthority);
       users.add(employee);*/

       return new InMemoryUserDetailsManager(users);

    }
    
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf->csrf.disable())
            .authorizeRequests(auth->{
                /*auth.antMatchers("authena/home").permitAll();
                auth.antMatchers("/authenta/**").hasAuthority("ADMIN");
                auth.antMatchers("/user/**").hasAuthority("ADMIN");
                auth.anyRequest().authenticated();*/
                auth.anyRequest().permitAll();

            })  ;      
            //.httpBasic(Customizer.withDefaults());
           
           
            /* 
             .antMatchers("/admin").hasAuthority("ADMIN")
            .antMatchers("/emp").hasAuthority("EMPLOYEE")
            .antMatchers("/mgr").hasAuthority("MANAGER")
            .antMatchers("/common").hasAnyAuthority("EMPLOYEE","MANAGER")

            
        // Any other URLs which are not configured in above antMatchers
        // generally declared aunthenticated() in real time
           .anyRequest().authenticated()

        // Login Form Details
           .and()
           .formLogin()
           .defaultSuccessUrl("/welcome", true)

        // Logout Form Details
          .and()
          .logout()
         .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

        // Exception Details 
         .and() 
         .exceptionHandling()
         .accessDeniedPage("/accessDenied");
        */
        return http.build();


    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

  /*  @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception { 
        return authenticationConfiguration.getAuthenticationManager();
    }
    */

    

}
