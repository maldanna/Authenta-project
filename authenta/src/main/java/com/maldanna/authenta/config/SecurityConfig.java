package com.maldanna.authenta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.maldanna.authenta.service.UserServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserServiceImpl uServiceImpl;

    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


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
                .anyRequest().authenticated())
            .userDetailsService(uServiceImpl)
            .exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint).and()
            .csrf().disable()
            .httpBasic(Customizer.withDefaults()); // order imporrtant see  spring security doc
        return http.build();
    }
    

  /*  @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception { 
        return authenticationConfiguration.getAuthenticationManager();
    }
    */
    
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
