package com.gm.gmreader.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gm.gmreader.dao.BranchchaptervoMapper;
import com.gm.gmreader.dao.BranchvoMapper;
import com.gm.gmreader.dao.ChapterMapper;
import com.gm.gmreader.dao.DiscussvoMapper;
import com.gm.gmreader.impl.MailService;
import com.gm.gmreader.impl.ReaderService;
import com.gm.gmreader.model.*;
import com.gm.gmreader.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.tools.Tool;
import java.io.Console;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping("/api")
public class OpenapiController {

    @Autowired
    MailService mailService;
    @Autowired
    ReaderService readerService;
    @Autowired
    BranchvoMapper branchvoMapper;
    @Autowired
    BranchchaptervoMapper branchchaptervoMapper;
    @Autowired
    ChapterMapper chapterMapper;
    @Autowired
    DiscussvoMapper discussvoMapper;


    @RequestMapping("/filetest")
    @ResponseBody
    public  JsonResult filetest( HttpServletRequest request ,MultipartFile file){
        System.out.println(  request.getRequestURI() );
        System.out.println( request.getQueryString() );
        System.out.println(  request.getRemoteHost() );
        System.out.println( request.getRemoteAddr()	  );
        Enumeration em = request.getParameterNames();
        while (em.hasMoreElements()) {
        String name = (String) em.nextElement();
        String value = request.getParameter(name);
        System.out.println(name+" "+value);
        }

        String filename=FileUtil.Save(file);
        if(filename==null)
        {
            JsonResult res=ResultTool.fail();
            return res;
        }
            JsonResult res=ResultTool.success();
            return res;


    }



    @PostMapping("/register")
    @ResponseBody
    public JsonResult register(String username,String password,String mail,String code)
    {

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(mail)||StringUtils.isEmpty(code)) {
            JsonResult res= ResultTool.fail(ResultCode.PARAM_NOT_COMPLETE);
            return res;
        }
        if(!VerfityUtil.isEmail(mail))
        {
            JsonResult res= ResultTool.fail(ResultCode.PARAM_NOT_VALID);
            return res;
        }
        Object obj=VerfityUtil.get(mail);
        if(obj==null)
        {
            JsonResult res= ResultTool.fail(ResultCode.PARAM_CODE_NOTVAILD);
            return res;
        }
        else
        {
            String vercode=(String)obj;
            if(!vercode.equals(code))
            {
                JsonResult res= ResultTool.fail(ResultCode.PARAM_CODE_NOTVAILD);
                return res;
            }
        }
        try {
            readerService.addreader(username,password,mail);
        }
        catch (Exception e) {
            JsonResult res=ResultTool.fail();
            return res;
        }
        JsonResult res=ResultTool.success();
            return res;

    }

    @PostMapping("/sendcode")
    @ResponseBody
    public JsonResult sendcode(@RequestParam String mail) {
        if(!VerfityUtil.isEmail(mail))
        {
            JsonResult res= ResultTool.fail(ResultCode.PARAM_NOT_VALID);
            return res;
        }
        Object obj=VerfityUtil.get(mail);
        String code="";
        if(obj==null)
        {
            code=VerfityUtil.generateVerifyCode();
            VerfityUtil.put(mail,code);
        }
        else
        {
            code=(String)obj;
        }
        mailService.sendSimpleMail(mail,"古木阅读-验证码","您的验证码为："+code+" ，五分钟内有效。");
        JsonResult res=ResultTool.success();
        return res;
    }

    @PostMapping("/validate")
    @ResponseBody
    public  JsonResult validate(@RequestParam String token)
    {
        token = token.replace(JwtTokenUtil.TOKEN_PREFIX, "");
        if(JwtTokenUtil.isExpiration(token))
        {
            JsonResult res=ResultTool.fail(ResultCode.USER_ACCOUNT_EXPIRED);
            return res;
        }

        String username = JwtTokenUtil.getUsername(token);

        if (username != null) {

            String role = JwtTokenUtil.getUserRole(token);
            token =JwtTokenUtil.createToken(username,role);

            Readervo readervo=readerService.getreaderById(Integer.parseInt(username));

            JSONObject data=new JSONObject();
            data.put("token",JwtTokenUtil.TOKEN_PREFIX + token);
            data.put("infor",readervo);
            JsonResult result = ResultTool.success();
            result.setData(data);
            return result;
        }
        else
        {
            JsonResult result = ResultTool.fail();
            return result;
        }

    }

    @RequestMapping("/getbranch")
    @ResponseBody
    public JsonResult getbranch(@RequestParam("branchid") int branchid) {
        BranchvoExample branchvoExample=new BranchvoExample();
        BranchvoExample.Criteria criteria = branchvoExample.createCriteria();
        criteria.andBidEqualTo(branchid);
        List<Branchvo> list =branchvoMapper.selectByExample(branchvoExample);
        if(list.size()>0)
        {
            JsonResult res = ResultTool.success();
            res.setData(list.get(0));
            return res;
        }
        else
        {
            JsonResult res = ResultTool.fail(ResultCode.SQL_NOTFIND_ERROR);
            return res;
        }
    }

    @RequestMapping("/getchapterlist")
    @ResponseBody
    public JsonResult getchapterlist(Pageparam pageparam,Integer branchid,boolean order) {
        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        Page<Branchchaptervo> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());
        BranchchaptervoExample example=new BranchchaptervoExample();
        BranchchaptervoExample.Criteria criteria=example.createCriteria();
        criteria.andBidEqualTo(branchid);
        example.setOrderByClause(order?"cid DESC":"cid ASC");
        List<Branchchaptervo> code =branchchaptervoMapper.selectByExample(example);
        p.setTotal(page.getTotal());
        p.setRows(code);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return res;
    }

    @RequestMapping("/getchapterbody")
    @ResponseBody
    public JsonResult getchapterbody(@RequestParam("chapterid") int chapterid) {
        Chapter chapter =  chapterMapper.selectByPrimaryKey(chapterid);
        if(chapter !=null)
        {
            JsonResult res = ResultTool.success();
            res.setData(chapter);
            return res;
        }
        else
        {
            JsonResult res = ResultTool.fail(ResultCode.SQL_NOTFIND_ERROR);
            return res;
        }
    }

    @RequestMapping("/getchapterbranch")
    @ResponseBody
    public JsonResult getchapeterbranch(@RequestParam("chapterid") int chapterid) {

        BranchvoExample branchvoExample=new BranchvoExample();
        BranchvoExample.Criteria criteria = branchvoExample.createCriteria();
        criteria.andBpreEqualTo(chapterid);
        criteria.andNumNotEqualTo((long)0);
        branchvoExample.setOrderByClause("up DESC");
        List<Branchvo> list =branchvoMapper.selectByExample(branchvoExample);

        if(list.size()>0)
        {
            JsonResult res = ResultTool.success();
            res.setData(list);
            return res;
        }
        else
        {
            JsonResult res = ResultTool.fail(ResultCode.SQL_NOTFIND_ERROR);
            return res;
        }
    }
    @RequestMapping("/getdiscuss")
    @ResponseBody
    public JsonResult getdiscuss(Pageparam pageparam,@RequestParam("branchid") int branchid) {
        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        Page<Discussvo> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());

        DiscussvoExample discussvoExample = new DiscussvoExample();
        DiscussvoExample.Criteria criteria = discussvoExample.createCriteria();
        criteria.andBidEqualTo(branchid);
        discussvoExample.setOrderByClause("time DESC");
        List<Discussvo> list = discussvoMapper.selectByExample(discussvoExample);

        p.setTotal(page.getTotal());
        p.setRows(list);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return res;
    }

    @RequestMapping("/getrecommend")
    @ResponseBody
    public JsonResult getrecommend() {
        BranchvoExample branchvoExample=new BranchvoExample();
        branchvoExample.setOrderByClause("RAND() LIMIT 3");
        List<Branchvo> list =branchvoMapper.selectByExample(branchvoExample);
        Map map=new HashMap();
        map.put("random",list);
        BranchvoExample branchvoExample1=new BranchvoExample();
        branchvoExample1.setOrderByClause("up DESC LIMIT 3");
        List<Branchvo> list1 =branchvoMapper.selectByExample(branchvoExample1);
        map.put("thumb",list1);
        JsonResult res = ResultTool.success();
        res.setData(map);
        return res;
    }

    @RequestMapping("/getnewbranch")
    @ResponseBody
    public JsonResult getnewbranch(Pageparam pageparam) {
        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        Page<Branchvo> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());

        BranchvoExample branchvoExample=new BranchvoExample();
        branchvoExample.setOrderByClause("btime DESC");
        List<Branchvo> list = branchvoMapper.selectByExample(branchvoExample);

        p.setTotal(page.getTotal());
        p.setRows(list);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return res;
    }


    @RequestMapping("/search")
    @ResponseBody
    public JsonResult search(Pageparam pageparam, String query) {
        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        Page<Branchvo> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());

        BranchvoExample branchvoExample=new BranchvoExample();
        BranchvoExample.Criteria criteria = branchvoExample.createCriteria();
        criteria.andBnameLike("%"+query+"%");
        BranchvoExample.Criteria criteria1 = branchvoExample.or();
        criteria1.andAuthornameLike("%"+query+"%");
        List<Branchvo> list = branchvoMapper.selectByExample(branchvoExample);
        p.setTotal(page.getTotal());
        p.setRows(list);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return res;
    }




}
