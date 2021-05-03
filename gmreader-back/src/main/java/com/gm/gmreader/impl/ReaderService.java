package com.gm.gmreader.impl;

import com.gm.gmreader.config.ConfigConstant;
import com.gm.gmreader.dao.*;
import com.gm.gmreader.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReaderService {
    @Autowired
    ReaderMapper readerMapper;
    @Autowired
    ReadervoMapper readervoMapper;
    @Autowired
    StarMapper starMapper;
    @Autowired
    DiscussMapper discussMapper;
    @Autowired
    ThumbMapper thumbMapper;
    @Autowired
    RtobMapper rtobMapper;

    @Autowired
    public void bCryptPasswordEncoder(BCryptPasswordEncoder passwordEncoder)
    {
        this.passwordEncoder=passwordEncoder;
    }

    private BCryptPasswordEncoder passwordEncoder;

    public boolean addreader(String name,String pwd,String mail)
    {
        Reader reader=new Reader();
        reader.setRname(name);
        reader.setRmail(mail);
        reader.setRpwd(passwordEncoder.encode(pwd));
        reader.setRstate("normal");
        reader.setRtime(new Date());
        reader.setRhimg(ConfigConstant.readerimg);
        int res=readerMapper.insert(reader);
        return res==1;
    }
    public Readervo getreaderById(Integer id)
    {

       Reader reader=readerMapper.selectByPrimaryKey(id);
       Readervo readervo=new Readervo();
       BeanUtils.copyProperties(reader,readervo);
       return readervo;
    }
    public void updatereader(Integer rid,String img)
    {
        Reader reader=readerMapper.selectByPrimaryKey(rid);
        reader.setRhimg(img);
        readerMapper.updateByPrimaryKey(reader);
    }
    public long getuserstarNum(Integer userId)
    {
        StarExample starExample = new StarExample();
        StarExample.Criteria criteria = starExample.createCriteria();
        criteria.andRidEqualTo(userId);
        return starMapper.countByExample(starExample);
    }
    public long getuserdiscussNum(Integer userId)
    {
        DiscussExample discussExample = new DiscussExample();
        DiscussExample.Criteria criteria = discussExample.createCriteria();
        criteria.andRidEqualTo(userId);
        return discussMapper.countByExample(discussExample);
    }
    public long getuserthumbNum(Integer userId)
    {
        ThumbExample thumbExample = new ThumbExample();
        ThumbExample.Criteria criteria = thumbExample.createCriteria();
        criteria.andRidEqualTo(userId);
        return thumbMapper.countByExample(thumbExample);
    }

    public long getuserbranchnum(Integer userId)
    {
        RtobExample rtobExample=new RtobExample();
        RtobExample.Criteria criteria = rtobExample.createCriteria();
        criteria.andRidEqualTo(userId);
        long num=rtobMapper.countByExample(rtobExample);
        return num;
    }
    public Reader getReader(Integer userId)
    {
        return readerMapper.selectByPrimaryKey(userId);
    }
    public void resetheader(Integer userId)
    {
        Reader reader =new Reader();
        reader.setRid(userId);
        reader.setRhimg(ConfigConstant.readerimg);
        readerMapper.updateByPrimaryKeySelective(reader);
    }


}
