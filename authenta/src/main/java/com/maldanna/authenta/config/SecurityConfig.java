package com.maldanna.authenta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserDetailsService uServiceImpl;
    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    JwtRequestFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf->csrf.ignoringAntMatchers("/h2-console/**"))
            .authorizeRequests(auth->auth
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("user/login").permitAll()
                .anyRequest().authenticated())
            // .userDetailsService(uServiceImpl) for basic or form based authentication
            .exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint).and()
            .csrf().disable();
            //.httpBasic(Customizer.withDefaults()); for rhttpbasic authentication // order imporrtant see  spring security doc
            http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
        return http.build();
        
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder){
        try{
            authenticationManagerBuilder.userDetailsService(uServiceImpl).passwordEncoder(passwordEncoder());
        }
        catch(Exception e){
            System.out.println("Exception occurred !!");
        }
    }

   @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception { 
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    
  /*   @Bean
    protected InMemoryUserDetailsManager configAuthentication() {
        UserDetails admin=User.withUsername("user1")
                            .password("user1")
                            .authorities("ADMIN").build();
       List<UserDetails> users = new ArrayList<>();
       users.add(admin);
       List<GrantedAuthority> adminAuthority = new ArrayList<>();
       adminAuthority.add(new SimpleGrantedAuthority("AUTHENTA"));
       UserDetails admin= new User("user1","user1", adminAuthority);
       users.add(admin);
       return new InMemoryUserDetailsManager(users);
    }
*/





}
