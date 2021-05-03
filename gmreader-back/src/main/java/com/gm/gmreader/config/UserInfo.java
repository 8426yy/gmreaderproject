package com.gm.gmreader.config;

import com.alibaba.fastjson.JSONObject;
import com.gm.gmreader.model.Readervo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserInfo extends User {

    public Readervo getReadervo() {
        return readervo;
    }

    public void setReadervo(Readervo readervo) {
        this.readervo = readervo;
    }

    Readervo readervo;
    public UserInfo(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserInfo(String username, String password, Collection<? extends GrantedAuthority> authorities, Readervo readervo) {
        super(username, password, authorities);
        this.readervo=readervo;
    }

}
