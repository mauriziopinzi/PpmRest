package com.cedacri.ppmrest;

import com.cedacri.ppmrest.error.RestAccessDeniedHandler;
import com.cedacri.ppmrest.error.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${ldap.urls}")
    private String ldapUrls;

    @Value("${ldap.base.dn}")
    private String ldapBaseDn;

    @Value("${ldap.username}")
    private String ldadUsername;

    @Value("${ldap.password}")
    private String ldapPassword;

    @Value("${ldap.user.dn.pattern}")
    private String ldapUserDnPattern;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

            http
                    .authorizeRequests()
                    .antMatchers("/**")
                    .authenticated()
                    .and().httpBasic()
                    .and().csrf().disable()
                    .exceptionHandling()
                        .accessDeniedHandler(accessDeniedHandler()).
                        authenticationEntryPoint(authenticationEntryPoint());;

    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .contextSource()
                .url(ldapUrls + ldapBaseDn)
                .managerDn(ldadUsername)
                .managerPassword(ldapPassword)
                .and()
                .userDnPatterns(ldapUserDnPattern);
    }

    @Bean
    RestAccessDeniedHandler accessDeniedHandler() {
        return new RestAccessDeniedHandler();
    }

    @Bean
    RestAuthenticationEntryPoint authenticationEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

}

