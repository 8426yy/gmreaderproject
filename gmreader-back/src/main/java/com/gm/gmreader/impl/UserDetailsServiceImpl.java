package com.gm.gmreader.impl;


import com.gm.gmreader.config.UserInfo;
import com.gm.gmreader.dao.ReaderMapper;
import com.gm.gmreader.model.Reader;
import com.gm.gmreader.model.ReaderExample;
import com.gm.gmreader.model.Readervo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private ReaderMapper readermapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new RuntimeException("用户不能为空");
        }
        System.out.println("login username is "+username);
        if(username.equals("admin"))
        {
            //return null;
            Readervo readervo= new Readervo();
            readervo.setRid(0);
            readervo.setRhimg("xxx.jpg");
            readervo.setRmail("000@163.com");
            readervo.setRname("管理员");

            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(grantedAuthority);
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


            return new UserInfo(username,passwordEncoder.encode("admin"), grantedAuthorities,readervo);
        }

        ReaderExample readerExample=new ReaderExample();
        ReaderExample.Criteria criteria=readerExample.createCriteria();
        criteria.andRmailEqualTo(username);
        List <Reader> list = readermapper.selectByExample(readerExample);
        if (list.size() ==0) {
            throw new RuntimeException("用户不存在");
        }
        Reader reader=list.get(0);
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_READER");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(grantedAuthority);


        Readervo readervo=new Readervo();
        BeanUtils.copyProperties(reader, readervo);
        UserInfo userinfo=new UserInfo(username,reader.getRpwd().trim(), grantedAuthorities,readervo);
        return userinfo;
    }

    public UserDetails loadUserByUserid(Integer uid)
    {
        Reader reader=readermapper.selectByPrimaryKey(uid);
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_READER");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(grantedAuthority);
        Readervo readervo=new Readervo();
        BeanUtils.copyProperties(reader, readervo);
        UserInfo userinfo=new UserInfo(reader.getRname(),reader.getRpwd().trim(), grantedAuthorities,readervo);
        return userinfo;
    }
}