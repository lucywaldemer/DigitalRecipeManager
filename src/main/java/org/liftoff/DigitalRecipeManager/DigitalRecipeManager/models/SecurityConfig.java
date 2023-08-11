package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register").permitAll() // Whitelist the register page for unauthenticated access
                .anyRequest().authenticated() // All other requests require authentication
                .and()
                .formLogin()
                .loginPage("/login") // Customize login page if needed
                .defaultSuccessUrl("/home").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login?logout").permitAll(); // Customize logout page if needed
    }
}
//Specify the URL for registration:
//In the above configuration class, we've used .antMatchers("/register").permitAll() to allow unauthenticated access to the /register URL. You can replace /register with the actual URL path of your registration page.
//
//Customize login and logout pages (Optional):
//If you have custom login and logout pages, you can use the .formLogin() and .logout() methods to specify their URLs.
//
//Ensure the registration page is accessible:
//Make sure that the registration page's controller and view are correctly configured so that it can be accessed when a user visits the /register URL.
//
//With the above configuration, the registration page should now be accessible without requiring authentication. Other parts of the application will still be secured and require the user to log in. Please note that this is just a basic configuration example, and you may need to adjust it according to your specific application requirements.
//
