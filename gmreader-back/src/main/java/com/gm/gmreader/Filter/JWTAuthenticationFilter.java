package com.gm.gmreader.Filter;

import com.alibaba.fastjson.JSONObject;
import com.gm.gmreader.config.UserInfo;
import com.gm.gmreader.impl.LoginService;
import com.gm.gmreader.model.Readervo;
import com.gm.gmreader.utils.*;
import com.alibaba.fastjson.JSON;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/**
 * 验证用户名密码正确后 生成一个token并将token返回给客户端
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    LoginService loginService;

   // private AuthenticationManager authenticationManager;

//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager)
//    {
//        this.authenticationManager = authenticationManager;
//    }


    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    //    this.authenticationManager=authenticationManager;
    }

    /**
     * 验证操作 接收并解析用户凭证
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,HttpServletResponse response) throws AuthenticationException {
        JSONObject json = null;
        try {
            json = GetRequestJsonUtils.getRequestJsonObject(request);
        } catch (IOException e) {
            throw new  RuntimeException("无法解析的头");
        }
        String username = json.getString("username");
        String password = json.getString("password");
        // 创建一个token并调用authenticationManager.authenticate() 让Spring security进行验证
        return super.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(username,password));
    }

    /**
     * 验证【成功】后调用的方法
     * 若验证成功 生成token并返回
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,HttpServletResponse response,FilterChain chain,Authentication authResult) throws IOException {
        UserInfo user= (UserInfo) authResult.getPrincipal();
        Readervo uservo= user.getReadervo();

        // 从User中获取权限信息
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        String token = JwtTokenUtil.createToken(uservo.getRid().toString(), authorities.toString());
//        System.out.println(user.getReadervo().getRid().toString() +token);
//        System.out.println(request.toString());
        loginService.userlog(uservo.getRid(), uservo.getRname(),request.getRemoteAddr(),authorities.toString());

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setContentType("text/json;charset=utf-8");

        JSONObject data=new JSONObject();
        data.put("token",JwtTokenUtil.TOKEN_PREFIX + token);
        data.put("infor",user.getReadervo());

        JsonResult result = ResultTool.success(ResultCode.SUCCESS_LOGIN);
        result.setData(data);
        response.getWriter().write(JSON.toJSONString(result));
    }

    /**
     * 验证【失败】调用的方法
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        JsonResult result = null;
        if (failed instanceof AccountExpiredException) {
            //账号过期
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_EXPIRED);
        } else if (failed instanceof BadCredentialsException) {
            //密码错误
            result = ResultTool.fail(ResultCode.USER_CREDENTIALS_ERROR);
        } else if (failed instanceof CredentialsExpiredException) {
            //密码过期
            result = ResultTool.fail(ResultCode.USER_CREDENTIALS_EXPIRED);
        } else if (failed instanceof DisabledException) {
            //账号不可用
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_DISABLE);
        } else if (failed instanceof LockedException) {
            //账号锁定
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_LOCKED);
        } else if (failed instanceof InternalAuthenticationServiceException) {
            //用户不存在
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_NOT_EXIST);
        }else
        {
            //其他错误
            result = ResultTool.fail(ResultCode.COMMON_FAIL);
        }

        System.out.println(result);
        // 处理编码方式 防止中文乱码
        response.setContentType("text/json;charset=utf-8");
        // 将反馈塞到HttpServletResponse中返回给前台
        response.getWriter().write(JSON.toJSONString(result));




    }
}