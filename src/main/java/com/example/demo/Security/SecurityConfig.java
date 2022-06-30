package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.server.WebFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private AccountService accountService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws  Exception{
//        return auth.getAuthenticationManager();
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/image/**").permitAll()
                    .antMatchers("/h2-console/**").permitAll()
                    .antMatchers("/login","/regist").anonymous()
                    .antMatchers("/tag/{id}","/product/{id}").permitAll()
                    .antMatchers("/cart").permitAll()
                    .antMatchers("/add/{\\d+}").hasAuthority(Role.CUSTOMER.name())
                    .antMatchers("/book/add","/book/update/{\\d+}").hasAuthority(Role.ADMIN.name())
                    .antMatchers("/tag/add","/tag/update/{\\d+}").hasAuthority(Role.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/login").defaultSuccessUrl("/")
                .and()
                    .logout().logoutSuccessUrl("/");
        http.headers().frameOptions().disable();
        return http.build();
    }
}
