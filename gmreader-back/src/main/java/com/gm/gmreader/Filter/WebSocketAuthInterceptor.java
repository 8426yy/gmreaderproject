package com.gm.gmreader.Filter;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gm.gmreader.impl.UserDetailsServiceImpl;
import com.gm.gmreader.utils.GetRequestJsonUtils;
import com.gm.gmreader.utils.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

@Component
public class WebSocketAuthInterceptor implements HandshakeInterceptor {

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        System.out.println("this is handler shake");
        ServletServerHttpRequest req = (ServletServerHttpRequest) serverHttpRequest;
        HttpServletRequest request = req.getServletRequest();

        String tokenHeader = request.getHeader("ws-token");
        System.out.println(request.getHeader("ws-token"));

        if (tokenHeader != null && tokenHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
            String token = tokenHeader.replace(JwtTokenUtil.TOKEN_PREFIX, "");
            String userid = JwtTokenUtil.getUsername(token);
            System.out.println(userid);
            if (userid != null) {
                System.out.println("ws-token access success");
                map.put("WEBSOCKET_USERID", userid);
                return true;
            }
        }
        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e)
    {
    }
}
