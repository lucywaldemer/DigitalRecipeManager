package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
// Updated web security for 5.8 and higher https://docs.spring.io/spring-security/reference/5.8/migration/servlet/config.html#use-new-requestmatchers
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/register").permitAll() // Whitelist the register page for unauthenticated access
                .antMatchers("/styles/**").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/home").authenticated() // Require authentication for /home
                .anyRequest().authenticated() // All other requests require authentication
                .and()

//        These lines are commented out to fix the redirect causing login to fail.
//                .formLogin()
//                .loginPage("/login").permitAll() // Customize login page if needed
//                .defaultSuccessUrl("/home").permitAll()
//                .and()
                .logout().logoutSuccessUrl("/login?logout").permitAll(); // Customize logout page if needed

    }
}