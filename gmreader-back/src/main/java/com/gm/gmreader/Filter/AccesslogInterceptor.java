package com.gm.gmreader.Filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gm.gmreader.utils.GetRequestJsonUtils;

//import org.apache.commons.io.IOUtils;

import com.gm.gmreader.model.Accesslog;
import com.gm.gmreader.dao.AccesslogMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.Date;
import java.util.Enumeration;

@Component

public class AccesslogInterceptor implements HandlerInterceptor {

    //请求开始时间标识
    private static final String LOGGER_SEND_TIME = "SEND_TIME";
    //请求日志实体标识
    private static final String LOGGER_ACCESSLOG = "ACCESSLOG_ENTITY";

    @Autowired
    AccesslogMapper accessLogMapper;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //创建日志实体
        Accesslog accessLog = new Accesslog();
        // 设置IP地址
        accessLog.setIp(request.getRemoteAddr());
        //设置请求方法,GET,POST...
        accessLog.setMethod(request.getMethod());
        //设置请求路径
        accessLog.setUrl(request.getRequestURI());
        //设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME,new Date());
        //设置请求实体到request内，方便afterCompletion方法调用
        request.setAttribute(LOGGER_ACCESSLOG,accessLog);
        return true;
    }



    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        Accesslog accessLog = (Accesslog) request.getAttribute(LOGGER_ACCESSLOG);

        int status = response.getStatus();
        accessLog.setStatus(""+status);

//        try {
//            GenericResponse body = (GenericResponse) request.getAttribute("body");
//
//            String message = body.getMessage();
//
//            accessLog.setMessage(message);
//        } catch (Exception e) {
//            accessLog.setMessage("");
//        }

        try {
            String requestBody =   GetRequestJsonUtils.getRequestPostStr(request);
            if (requestBody.length() >4096) {
                accessLog.setBody(requestBody.substring(0, 4096));
            } else {
                accessLog.setBody(requestBody);
            }
        }
        catch (Exception e)
        {

        }

        JSONObject json=new JSONObject();
        Enumeration em = request.getHeaderNames();

        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getHeader(name);
            json.put(name,value);
                   }
        accessLog.setQuery(json.toString());

//        //当前时间
//        long currentTime = System.currentTimeMillis();

        //请求开始时间
        Date sttime = (Date) request.getAttribute(LOGGER_SEND_TIME);
        accessLog.setSttime(sttime);
        accessLog.setEndtime(new Date());

        accessLogMapper.insert(accessLog);
    }
}
