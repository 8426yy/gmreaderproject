package com.gm.gmreader.impl;

import com.gm.gmreader.dao.LoginlogMapper;
import com.gm.gmreader.model.Loginlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class LoginService {
    @Autowired
    LoginlogMapper loginlogMapper;


    public void userlog(Integer userid,String username,String ip ,String role )
    {
        Date date=new Date();
        Loginlog loginlog=new Loginlog();
        loginlog.setRid(userid);
        loginlog.setRname(username);
        loginlog.setRip(ip);
        loginlog.setTime(date);
        loginlog.setRole(role);
        loginlogMapper.insert(loginlog);
    }

}
