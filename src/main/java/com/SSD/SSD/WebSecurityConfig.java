package com.SSD.SSD;

//https://github.com/eugenp/tutorials/blob/master/spring-security-modules/spring-security-web-boot-2/src/main/java/com/baeldung/multiplelogin/MultipleLoginSecurityConfig.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@EnableWebSecurity
public class WebSecurityConfig  {





    @Qualifier("ProfessorDetailsService")
    @Configuration
    @Order(1)
    public static class StudentWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter{

        public StudentWebSecurityConfigurationAdapter(){super();}
        @Autowired
        UserDetailsService userDetailsService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception{
              auth.userDetailsService(userDetailsService);
              auth.inMemoryAuthentication()
                    .withUser("professor").password("password").roles("PROFESSOR");

        }

        protected void configure(HttpSecurity http) throws Exception {
            http

                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("PROFESSOR")
/*
                    .authorizeRequests()
                    .antMatchers("/", "/homeScreen").permitAll()
                    .anyRequest().authenticated()
*/

                    .and()
                    .formLogin()
                    .loginPage("/professor/LoginProfessor")
                    .failureUrl("/professor/LoginProfessor?error=loginError")
                    .defaultSuccessUrl("/hello")
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll();

        }
    }


    @Qualifier("MyUserDetailsService")
    @Configuration
    @Order(2)
    public static class ProfessorWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter{

        public ProfessorWebSecurityConfigurationAdapter(){super();}
        @Autowired
        UserDetailsService userDetailsService;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception{
            auth.userDetailsService(userDetailsService);
            auth.inMemoryAuthentication()
                  .withUser("student").password("password").roles("STUDENT");

        }

        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/student**")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("STUDENT")
                    /*
                    .authorizeRequests()
                    .antMatchers("/", "/homeScreen").permitAll()
                    .anyRequest().authenticated()
*/

                    .and()
                    .formLogin()
                    .loginPage("/student/loginoficial")
                    .failureUrl("/student/loginoficial?error=loginError")
                    .defaultSuccessUrl("/index")
                    .permitAll()

                    .and()
                    .logout()
                    .permitAll();

        }
    }





}