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
        // 注册跨域配置
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
     * 强散列哈希加密实现
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
                // 添加JWT登录拦截器
                .addFilter(jwtAuthenticationFilter())
                // 添加JWT鉴权拦截器
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                // 设置Session的创建策略为：Spring Security永不创建HttpSession 不使用HttpSession来获取SecurityContext
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
//                .logout()
//                .permitAll()//允许所有用户
//                .logoutSuccessHandler(logoutSuccessHandler)//登出成功处理逻辑
//                .and()
                .csrf().disable();
                //.apply(customUsernamePasswordAuthenticationConfig)
                // deleteCookies("JSESSIONID");//登出之后删除cooki
                //会话管理
                //and().sessionManagement().
                //maximumSessions(1).//同一账号同时登录最大用户数
                //expiredSessionStrategy(sessionInformationExpiredStrategy);//会话信息过期策略会话信息过期策略(账号被挤下线)
    }






}
