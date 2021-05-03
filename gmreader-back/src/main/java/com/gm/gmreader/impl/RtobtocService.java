package com.gm.gmreader.impl;

import com.gm.gmreader.dao.*;
import com.gm.gmreader.model.*;
import com.gm.gmreader.utils.JsonResult;
import com.gm.gmreader.utils.ResultTool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RtobtocService {
    @Autowired
    RtobMapper rtobMapper;
    @Autowired
    BtocMapper btocMapper;
    @Autowired
    ReaderMapper readerMapper;
    @Autowired
    BranchMapper branchMapper;
    @Autowired
    ChapterMapper chapterMapper;

    public boolean bisfromr(Integer bid,Integer rid)
    {
        RtobExample rtobExample = new RtobExample();
        RtobExample.Criteria criteria = rtobExample.createCriteria();
        criteria.andBidEqualTo(bid);
        criteria.andRidEqualTo(rid);
        List<Rtob>list=rtobMapper.selectByExample(rtobExample);
        return list.size() > 0;
    }

    public Integer getcid(Chapter chapter)
    {
        ChapterExample chapterExample=new ChapterExample();
        ChapterExample.Criteria criteria= chapterExample.createCriteria();
        criteria.andCtitleEqualTo(chapter.getCtitle());
        criteria.andCbodyEqualTo(chapter.getCbody());
//        criteria.andCtimeEqualTo(chapter.getCtime());
        chapterExample.setOrderByClause("cid DESC");
        List<Chapter> list=chapterMapper.selectByExample(chapterExample);
        if(list.size()>0)
        {
            return list.get(0).getCid();

        }
        else {
            return 0;
        }
    }

    public Integer getBid(Branch branch)
    {
        BranchExample branchExample=new BranchExample();
        BranchExample.Criteria criteria= branchExample.createCriteria();
        criteria.andBnameEqualTo(branch.getBname());
        criteria.andBintroEqualTo(branch.getBintro());
//        criteria.andBtimeEqualTo(branch.getBtime());
        branchExample.setOrderByClause("bid DESC");
        List<Branch>list=branchMapper.selectByExample(branchExample);
        if(list.size()>0)
        {
            return list.get(0).getBid();

        }
        else {
            return 0;
        }
    }
    public Integer insertChapter(Integer branchid,String title,String body)
    {
        Date date=new Date();
        Chapter chapter=new Chapter();
        chapter.setCtitle(title);
        chapter.setCbody(body);
        chapter.setCtime(date);

        chapterMapper.insert(chapter);
        System.out.println(chapter.toString());
        Integer cid=getcid(chapter);
        System.out.println(cid);
        if(cid!=0)
        {
            Btoc btoc = new Btoc();
            btoc.setBid(branchid);
            btoc.setCid(cid);
            btocMapper.insert(btoc);
            return cid;
        }
        return 0;
    }

    public Integer insertBranch(Integer rid,String title,String introduce ,String img,Integer pre)
    {
        Date date=new Date();
        Branch branch=new Branch();
        branch.setBname(title);
        branch.setBintro(introduce);
        if(pre!=0)
            branch.setBpre(pre);
        branch.setBtime(date);
        branch.setBhimg(img);
        branchMapper.insert(branch);
        Integer bid=getBid(branch);
        if(bid!=0)
        {
            Rtob rtob=new Rtob();
            rtob.setRid(rid);
            rtob.setBid(bid);
            rtobMapper.insert(rtob);
            return bid;
        }
        return 0;

    }

    public void updateBranch(Integer bid,String title,String introduce ,String img)
    {
        Branch branch=branchMapper.selectByPrimaryKey(bid);
        if(!StringUtils.isEmpty(title))
            branch.setBname(title);
        if(!StringUtils.isEmpty(introduce))
            branch.setBintro(introduce);
        if(!StringUtils.isEmpty(img))
            branch.setBhimg(img);
        branchMapper.updateByPrimaryKeySelective(branch);

    }





}
