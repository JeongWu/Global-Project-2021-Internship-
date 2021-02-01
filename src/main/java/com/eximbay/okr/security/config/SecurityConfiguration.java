package com.eximbay.okr.security.config;

import com.eximbay.okr.security.CustomAccessDeniedHandler;
import com.eximbay.okr.security.CustomAuthenticationFailureHandler;
import com.eximbay.okr.security.CustomAuthenticationProvider;
import com.eximbay.okr.security.CustomLogoutSuccessHandler;
import com.eximbay.okr.security.CustomWebAuthenticationDetailsSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // @Autowired
    // private UserDetailsService userDetailsService;

    @Autowired
    private CustomWebAuthenticationDetailsSource authenticationDetailsSource;

    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
 
    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/team/**").hasRole("TEAM")
            .antMatchers("/member/**").hasRole("MEMBER")
            .antMatchers("/assets/**").permitAll()
            .antMatchers("/h2/**").permitAll()
            .antMatchers("/api/**").permitAll()
            .antMatchers("/login*").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/perform_login")
            .defaultSuccessUrl("/okr", true)
            .failureUrl("/login?error=true")
            .failureHandler(authenticationFailureHandler())
            .authenticationDetailsSource(authenticationDetailsSource)
            .and()
            .logout()
            .logoutUrl("/logout")
            .deleteCookies("JSESSIONID")
            .logoutSuccessHandler(logoutSuccessHandler())
            ;
            http.headers().frameOptions().disable();
    }

    // @Bean
    // public DaoAuthenticationProvider authProvider() {
    //     final CustomAuthenticationProvider authProvider = new CustomAuthenticationProvider();
    //     //authProvider.setUserDetailsService(userDetailsService);
    //     authProvider.setPasswordEncoder(passwordEncoder());
    //     //authProvider.setPostAuthenticationChecks(differentLocationChecker);
    //     return authProvider;
    // }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}