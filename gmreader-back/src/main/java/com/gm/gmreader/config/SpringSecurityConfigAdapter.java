package com.gm.gmreader.config;

import com.gm.gmreader.Filter.JWTAuthenticationFilter;
import com.gm.gmreader.Filter.JWTAuthorizationFilter;
import com.gm.gmreader.Handler.CustomizeAuthenticationEntryPoint;
import com.gm.gmreader.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.annotation.Resource;

@Configuration
public class SpringSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsServiceImpl userDetailsService() {

        return new UserDetailsServiceImpl();
    }

    ;
    @Resource
    public CustomizeAuthenticationEntryPoint authenticationEntryPoint;
//    @Resource
//    public CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;
//    @Resource
//    public CustomizeAuthenticationFailureHandler authenticationFailureHandler;
//    @Resource
//    public CustomizeLogoutSuccessHandler logoutSuccessHandler;

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // ??????????????????
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }


    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    JWTAuthenticationFilter jwtAuthenticationFilter()
    {
        return new JWTAuthenticationFilter();
    }


    /**
     * ???????????????????????????
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(bCryptPasswordEncoder());
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws  Exception
    {
        User.UserBuilder builder = User.builder().passwordEncoder(bCryptPasswordEncoder()::encode);
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        //auth.userDetailsService(userDetailsService());
     auth.authenticationProvider(authenticationProvider());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.cors()
                .and()
                .authorizeRequests()
                .antMatchers("/ws","/login","./admin/**","/","/static/**","/templates/**","/api/**")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
//                .successHandler(authenticationSuccessHandler)
//                .failureHandler(authenticationFailureHandler)
                .permitAll()
                .failureUrl("/login/error")
                .and()
                .authorizeRequests()
                .antMatchers("/reader/**").hasAuthority("ROLE_READER")
                .and()
                // ??????JWT???????????????
                .addFilter(jwtAuthenticationFilter())
                // ??????JWT???????????????
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                // ??????Session?????????????????????Spring Security????????????HttpSession ?????????HttpSession?????????SecurityContext
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
//                .logout()
//                .permitAll()//??????????????????
//                .logoutSuccessHandler(logoutSuccessHandler)//????????????????????????
//                .and()
                .csrf().disable();
                //.apply(customUsernamePasswordAuthenticationConfig)
                // deleteCookies("JSESSIONID");//??????????????????cooki
                //????????????
                //and().sessionManagement().
                //maximumSessions(1).//???????????????????????????????????????
                //expiredSessionStrategy(sessionInformationExpiredStrategy);//????????????????????????????????????????????????(??????????????????)
    }






}
