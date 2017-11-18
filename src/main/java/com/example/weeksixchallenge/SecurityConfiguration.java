package com.example.weeksixchallenge;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers ( "/" ).access ( "hasAuthority('USER') or hasAuthority ('ADMIN')")
                .antMatchers ( "/admin" ).access ( "hasAuthority('ADMIN')" )
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll();
        http
                .csrf ().disable ();
        http
                .headers ().frameOptions ().disable ();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception{

            auth.inMemoryAuthentication().withUser("user").password("password").authorities ( "USER" ).and()
                    .withUser ( "yonatan" ).password ( "yonatan" ).authorities ( "ADMIN");
        }
}

