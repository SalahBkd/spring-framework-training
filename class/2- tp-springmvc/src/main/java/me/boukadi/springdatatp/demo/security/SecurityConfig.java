package me.boukadi.springdatatp.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("user")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        //http.httpBasic(); // HTTP BASED LOGIN FORM
        http.authorizeRequests().antMatchers("/save**/**", "/delete**/**", "/form**/**").hasRole("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.csrf(); // preventing from CSRF attack by adding the SYNCHRONIZED TOKEN to the HTML pages e.g: Forms.
        http.exceptionHandling().accessDeniedPage("/notAuthorized");
        //http.csrf().disabled(); // when using stateless authentication e.g: JWT
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
