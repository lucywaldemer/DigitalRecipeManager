//package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;
////package org.liftoff.DigitalRecipeManager.DigitalRecipeManager.models;
//import net.bytebuddy.build.Plugin;
//import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
////// Updated web security for 5.8 and higher https://docs.spring.io/spring-security/reference/5.8/migration/servlet/config.html#use-new-requestmatchers
//////    @Configuration
//////    @EnableWebSecurity
//////    public class SecurityConfig {
//////
//////        @Bean
//////        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//////            http
//////                    .authorizeHttpRequests((authz) -> authz
//////                            .requestMatchers().permitAll()
//////                            .anyRequest().authenticated()
//////                    );
//////            return http.build();
//////        }
//////
//////    }
////// THE ABOVE CODE WAS COMMENTED OUT, THE BELOW CODE WAS UNCOMMENTED
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/","/search","/login","/register","/recipes", "/recipes/view/*", "/ingredients").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .permitAll()
////                .and()
////                .logout()
////                .permitAll();
//    }

////
//////    @Override
//////    protected void configure(HttpSecurity http) throws Exception {
//////        http
////
//////                .authorizeRequests()
//////                .antMatchers( "/register").permitAll() // Whitelist the register page for unauthenticated access
//////                .anyRequest().authenticated() // All other requests require authentication
//////                .and()
//////                .formLogin()
//////                .loginPage("/login").permitAll() // Customize login page if needed
//////                .defaultSuccessUrl("/home").permitAll()
//////                .and()
//////                .logout().logoutSuccessUrl("/login?logout").permitAll(); // Customize logout page if needed
////
//////    }
//}
////Specify the URL for registration:
//////In the above configuration class, we've used .antMatchers("/register").permitAll() to allow unauthenticated access to the /register URL. You can replace /register with the actual URL path of your registration page.
//////
//////Customize login and logout pages (Optional):
//////If you have custom login and logout pages, you can use the .formLogin() and .logout() methods to specify their URLs.
//////
//////Ensure the registration page is accessible:
//////Make sure that the registration page's controller and view are correctly configured so that it can be accessed when a user visits the /register URL.
//////
//////With the above configuration, the registration page should now be accessible without requiring authentication. Other parts of the application will still be secured and require the user to log in. Please note that this is just a basic configuration example, and you may need to adjust it according to your specific application requirements.
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////    @Bean
////    public InMemoryUserDetailsManager userDetailsManager()  {
////        UserDetails user = User()
////                .username("user")
////                .password("password")
////                .roles("USER")
////                .build();
////
////        UserDetails admin = User()
////                .username("user")
////                .password("password")
////                .roles("AdMIN")
////                .build();
////        return new InMemoryUserDetailsManager(user, admin);
////
////    }
////    @Bean
////   public SecurityFilterChain configure(HttpSecurity http)  throws Exception {
////       return http
////               .csrf(csrf   ->  csrf.disable())
////               .authorizeRequests(auth -> {
////                   auth.antMatchers("/").permitAll();
////                   auth.antMatchers("/user").hasRole("USER");
////                   auth.antMatchers("/admin").hasRole("ADMIN");
////               })
////               .httpBasic(Customizer.withDefaults())
////               .build();
////
////    }
////}

// THE ABOVE CODE WAS COMMENTED OUT, THE BELOW CODE WAS UNCOMMENTED
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers( "/register").permitAll() // Whitelist the register page for unauthenticated access
//                .antMatchers("/styles/**").permitAll()
//                .antMatchers("/login*").permitAll()
//                .anyRequest().authenticated() // All other requests require authentication
//                .and()
//

//                These lines are commented out to fix the redirect causing login to fail.
//
//                .formLogin()
//                .loginPage("/login").permitAll() // Customize login page if needed
//                .defaultSuccessUrl("/home").permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/login?logout").permitAll(); // Customize logout page if needed
//
//    }
//}
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


