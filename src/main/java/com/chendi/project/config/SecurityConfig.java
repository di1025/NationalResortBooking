package com.chendi.project.config;

import com.chendi.project.extend.security.JwtAuthenticationFilter;
import com.chendi.project.extend.security.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailService;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
//    step 1
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication().withUser(“user1”)
//            .password(“{noop}password”).roles(“REGISTERED_USER”);
//    }
//
//    protected void configure(HttpSecurity http) throws Exception{
//        http.csrf().disable()
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin();
//    }

    //step 2
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication().withUser(“user”)
//                .password(“{noop}password”).roles(“REGISTERED_USER”);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailService).passwordEncoder(encoder);// use loaduserbyusername;
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();}

    protected void configure(HttpSecurity http) throws Exception{
//
        http.csrf().disable()
                .addFilterAt(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests().antMatchers("/api/users/login","/api/user/login","/api/user/signup","/api/users/signup","/api/image").permitAll()
                .and()
                .authorizeRequests().antMatchers("/api/**").hasAnyRole("REGISTERED_USER")
         //.authenticated()
//         .and().formLogin();
           .and().exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint);
     }
}
