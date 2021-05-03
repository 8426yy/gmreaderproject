package com.gm.gmreader.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gm.gmreader.dao.*;
import com.gm.gmreader.impl.ReaderService;
import com.gm.gmreader.impl.RtobtocService;
import com.gm.gmreader.model.*;
import com.gm.gmreader.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.rowset.CachedRowSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ReaderMapper readerMapper;
    @Autowired
    ChapterMapper chapterMapper;
    @Autowired
    BranchMapper branchMapper;
    @Autowired
    LoginlogMapper loginlogMapper;
    @Autowired
    ThumbMapper thumbMapper;
    @Autowired
    DiscussMapper discussMapper;
    @Autowired
    StarMapper starMapper;
    @Autowired
    ReadervoMapper readervoMapper;
    @Autowired
    BranchchaptervoMapper branchchaptervoMapper;
    @Autowired
    BranchvoMapper branchvoMapper;
    @Autowired
    DiscussvoMapper discussvoMapper;
    @Autowired
    StarvoMapper starvoMapper;
    @Autowired
    ThumbvoMapper thumbvoMapper;
    @Autowired
    RtobtocService robtocService;
    @Autowired
    ReaderService readerService;

    @RequestMapping("/data")
    @ResponseBody
    public JsonResult data() {
        Map num =new HashMap();
        long readernum=readerMapper.countByExample(null);
        long chapternum=chapterMapper.countByExample(null);
        long branchnum=branchMapper.countByExample(null);
        long starnum=starMapper.countByExample(null);
        long thumbnum=thumbMapper.countByExample(null);
        long discussnum=discussMapper.countByExample(null);


        LoginlogExample loginlogExample=new LoginlogExample();
        loginlogExample.setOrderByClause("lid DESC LIMIT 30");
        List<Loginlog>loginlist=loginlogMapper.selectByExample(loginlogExample);
        num.put("readernum",readernum);
        num.put("chapternum",chapternum);
        num.put("branchnum",branchnum);
        num.put("starnum",starnum);
        num.put("thumbnum",thumbnum);
        num.put("discussnum",discussnum);

        num.put("loginlog",loginlist);

        JsonResult res = ResultTool.success();
        res.setData(num);
        return res;
    }

    @RequestMapping("/mail")
    @ResponseBody
    public JsonResult mail(Pageparam pageparam) {

        JsonResult res = ResultTool.success();
        return res;
    }

    @RequestMapping("/readerall")
    @ResponseBody
    public JsonResult readerall(Pageparam pageparam) {
        System.out.println(pageparam.toString());
        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        Page<Readervo> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());
        List<Readervo> code = readervoMapper.selectByExample(null);
        p.setTotal(page.getTotal());
        p.setRows(code);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return res;
    }


    @RequestMapping("/deletereader")
    @ResponseBody
    public JsonResult deletereader(Integer userId) {

        if(userId!=null&&userId!=0)
        {
            try {
                readerMapper.deleteByPrimaryKey(userId);
            }
            catch (Exception e)
            {
                JsonResult res = ResultTool.fail(ResultCode.SQL_EXCUTE_ERROR);
                return res;
            }
            JsonResult res = ResultTool.success();
            return res;
        }
        else
        {
            JsonResult res = ResultTool.fail(ResultCode.PARAM_NOT_COMPLETE);
            return res;
        }
    }



    @RequestMapping("/branchall")
    @ResponseBody
    public JsonResult branchall(Pageparam pageparam,Integer userid) {
        System.out.println(pageparam.toString());
        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        Page<Branchvo> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());
        BranchvoExample branchvoExample=new BranchvoExample();
        BranchvoExample.Criteria criteria= branchvoExample.createCriteria();
        if(userid!=0)
        {
            criteria.andAuthoridEqualTo(userid);
        }
        List<Branchvo> code = branchvoMapper.selectByExample(branchvoExample);
        p.setTotal(page.getTotal());
        p.setRows(code);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return res;
    }


    @RequestMapping("/deletebranch")
    @ResponseBody
    public JsonResult deletebranch(Integer branchid) {

        if(branchid!=null&& branchid!=0)
        {
            try {
                branchMapper.deleteByPrimaryKey(branchid);
            }
            catch (Exception e)
            {
                JsonResult res = ResultTool.fail(ResultCode.SQL_EXCUTE_ERROR);
                return res;
            }
            JsonResult res = ResultTool.success();
            return res;
        }
        else
        {
            JsonResult res = ResultTool.fail(ResultCode.PARAM_NOT_COMPLETE);
            return res;
        }
    }

    
    
    
    @RequestMapping("/chapterall")
    @ResponseBody
    public JsonResult chapterall(Pageparam pageparam,Integer branchid) {
        System.out.println(pageparam.toString());
        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        Page<Branchchaptervo> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());

        BranchchaptervoExample example=new BranchchaptervoExample();
        BranchchaptervoExample.Criteria criteria = example.createCriteria();
        if(branchid!=0) {
            criteria.andBidEqualTo(branchid);
        }
        List<Branchchaptervo> code = branchchaptervoMapper.selectByExample(example);
        p.setTotal(page.getTotal());
        p.setRows(code);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return res;
    }

    @RequestMapping("/deletechapter")
    @ResponseBody
    public JsonResult deletechapter(Integer chapterid) {

        if(chapterid!=null&& chapterid!=0)
        {
            try {
                chapterMapper.deleteByPrimaryKey(chapterid);
            }
            catch (Exception e)
            {
                JsonResult res = ResultTool.fail(ResultCode.SQL_EXCUTE_ERROR);
                return res;
            }
            JsonResult res = ResultTool.success();
            return res;
        }
        else
        {
            JsonResult res = ResultTool.fail(ResultCode.PARAM_NOT_COMPLETE);
            return res;
        }
    }



    @RequestMapping("/loginlogall")
    @ResponseBody
    public JsonResult loginlogall(Pageparam pageparam) {
        System.out.println(pageparam.toString());
        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        Page<Loginlog> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());
        List<Loginlog> code = loginlogMapper.selectByExample(null);
        p.setTotal(page.getTotal());
        p.setRows(code);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return res;
    }

    @RequestMapping("/discussall")
    @ResponseBody
    public JsonResult discussall(Integer userid,Pageparam pageparam) {
        System.out.println(pageparam.toString());
        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        DiscussvoExample discussvoExample =new DiscussvoExample();
        DiscussvoExample.Criteria criteria= discussvoExample.createCriteria();
        if(userid!=0)
        {
            criteria.andRidEqualTo(userid);
        }
        Page<Discussvo> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());
        List<Discussvo> code = discussvoMapper.selectByExample(discussvoExample);
        p.setTotal(page.getTotal());
        p.setRows(code);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return res;
    }

    @RequestMapping("/deletediscuss")
    @ResponseBody
    public JsonResult deletediscuss(Integer discussid) {
        System.out.println("discussid is "+discussid);
        System.out.println("discussid is "+discussid);
        if(discussid!=null&& discussid!=0)
        {
            try {
                discussMapper.deleteByPrimaryKey(discussid);
            }
            catch (Exception e)
            {
                JsonResult res = ResultTool.fail(ResultCode.SQL_EXCUTE_ERROR);
                return res;
            }
            JsonResult res = ResultTool.success();
            return res;
        }
        else
        {
            JsonResult res = ResultTool.fail(ResultCode.PARAM_NOT_COMPLETE);
            return res;
        }
    }



    @RequestMapping("/thumball")
    @ResponseBody
    public JsonResult thumball(Integer userid,Pageparam pageparam) {
        System.out.println(pageparam.toString());
        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        ThumbvoExample thumbvoExample=new ThumbvoExample();
        if(userid!=0)
            thumbvoExample.createCriteria().andRidEqualTo(userid);
        Page<Thumbvo> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());
        List<Thumbvo> code = thumbvoMapper.selectByExample(thumbvoExample);
        p.setTotal(page.getTotal());
        p.setRows(code);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return res;
    }


    @RequestMapping("/starall")
    @ResponseBody
    public JsonResult starall(Integer userid,Pageparam pageparam) {
        System.out.println(pageparam.toString());
        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        StarvoExample starvoExample =new StarvoExample();
        if(userid!=0)
        starvoExample.createCriteria().andRidEqualTo(userid);
        Page<Starvo> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());
        List<Starvo> code = starvoMapper.selectByExample(starvoExample);
        p.setTotal(page.getTotal());
        p.setRows(code);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return res;
    }

    @RequestMapping("/userdata")
    @ResponseBody
    public JsonResult userdata(Integer userId) {
        Map num =new HashMap();


        long branchnum=readerService.getuserbranchnum(userId);
        long starnum=readerService.getuserstarNum(userId);
        long thumbnum=readerService.getuserthumbNum(userId);
        long discussnum= readerService.getuserdiscussNum(userId);

        Reader reader=readerService.getReader(userId);

        num.put("branchnum",branchnum);
        num.put("starnum",starnum);
        num.put("thumbnum",thumbnum);
        num.put("discussnum",discussnum);

        num.put("infor",reader);

        JsonResult res = ResultTool.success();
        res.setData(num);
        return res;
    }



    @RequestMapping("/resetuserhead")
    @ResponseBody
    public JsonResult resetuserhead(Integer userId) {
        readerService.resetheader(userId);
        JsonResult res = ResultTool.success();
        return res;
    }





}
