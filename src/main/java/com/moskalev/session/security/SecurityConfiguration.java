package com.moskalev.session.security;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //работающий тестовый вариант
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/session/**").authenticated() //пускать на корень session и далее, аутентифицир пользователей
//               // .antMatchers("/username/**").hasRole("ADMIN", "SUPERADMIN") //пускать с конкретной ролью
//                .and()
//                //.httpBasic() //базовая аутентификация
//                .formLogin() //кастомная форма логина
//                //.loginProcessingUrl("/hellologin")//означает что логгинг отправит запрос на обработку по указанному адресу
//               // .successHandler()// если пользователь прошел аутентитифкацию, повесить обработчик
//                .and()
//                .logout().logoutSuccessUrl("/"); //после выхода, попадать в корень приложения
//    }

    //работающий In-Memory аутентификация (необходим PasswordEncoder)
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser("user")
//                .password("1")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("1")
//                .roles("ADMIN");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().defaultSuccessUrl("/session")
                .and().logout().logoutSuccessUrl("/");
    }


    //еще один способ In-Memory аутентификация без configure выше
//    @Bean
//    public UserDetailsService users(){
//        UserDetails user= User.builder()
//                .username("user")
//                .password("{bcrypt}$2a$12$8lRUSYG3Gs6TdT7R1QsM.eCwzWF3RQVMNpuxIW5MgkNcnqaD47YDS")
//                .roles("USER")
//                .build();
//
//        UserDetails admin= User.builder()
//                .username("admin")
//                .password("{bcrypt}$2a$12$8lRUSYG3Gs6TdT7R1QsM.eCwzWF3RQVMNpuxIW5MgkNcnqaD47YDS")
//                .roles("ADMIN","USER")
//                .build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }

}

