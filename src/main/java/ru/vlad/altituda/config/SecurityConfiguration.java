package ru.vlad.altituda.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.vlad.altituda.JDBC.DbSource;

//@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {



//    protected void configure(AuthenticationManagerBuilder auth){
//            throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(DbSource)
//                .usersByUsernameQuery("select email,password,enabled "
//                        + "from users2 "
//                + "where email = ?")
//                .authoritiesByUsernameQuery("select email,authority "
//                + "from authorities "
//                + "where email = ?");

    }
//        http.formLogin();
//
//        http.authorizeRequests()
//                .antMatchers("/devs/*").hasAnyRole("boss", "dev")
//                .antMatchers("/boss/*").hasRole("boss")
//                .antMatchers("/").permitAll();
//    }


