/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtn.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author tuann
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.vtn.controllers",
    "com.vtn.repository",
    "com.vtn.service"
})
public class SecurityConfigs extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password");
        
        http.formLogin().defaultSuccessUrl("/")
                .failureUrl("/login?error");
        
        http.logout().logoutSuccessUrl("/login");
        
        http.exceptionHandling()
                .accessDeniedPage("/login?accessDenied");
        
        http.authorizeRequests().antMatchers("/**").hasRole("ADMIN");
             
//                .access("hasRole('ROLE_ADMIN')");
//        .antMatchers("/**/pay")
//                .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
        http.csrf().disable();
    }
    
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary
                = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "dage0bjr6",
                        "api_key", "199369517429492",
                        "api_secret", "A9ysVaH6hZVGMHKCUeTNCx6P9EY",
                        "secure", true));
        return cloudinary;
    }
}
