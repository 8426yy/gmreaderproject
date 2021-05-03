package com.gm.gmreader.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gm.gmreader.Handler.SpringWebSocketHandler;
import com.gm.gmreader.config.ConfigConstant;
import com.gm.gmreader.dao.*;
import com.gm.gmreader.impl.ReaderService;
import com.gm.gmreader.impl.RtobtocService;
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


import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    ReadervoMapper readervoMapper;
    @Autowired
    BranchchaptervoMapper branchchaptervoMapper;
    @Autowired
    ChapterMapper chapterMapper;
    @Autowired
    BranchvoMapper branchvoMapper;
    @Autowired
    DiscussvoMapper discussvoMapper;
    @Autowired
    ThumbMapper thumbMapper;
    @Autowired
    StarvoMapper starvoMapper;
    @Autowired
    ReaderService readerService;
    @Autowired
    StarMapper starMapper;
    @Autowired
    DiscussMapper discussMapper;
    @Autowired
    RtobMapper rtobMapper;
    @Autowired
    BtocMapper btocMapper;
    @Autowired
    BranchMapper branchMapper;
    @Autowired
    RtobtocService rtobtocService;
    @Autowired
    ChatvoMapper chatvoMapper;
    @Autowired
    ChatMapper chatMapper;
    @Autowired
    SpringWebSocketHandler springWebSocketHandler;

    @RequestMapping("/test1")
    @ResponseBody
    public JsonResult test1(Integer x,Integer y,String z)
    {
        System.out.println(z+x+y);
        JsonResult res= ResultTool.success();
        return res;
    }

    @RequestMapping("/test2")
    @ResponseBody
    public JsonResult test2()
    {
        JsonResult res= ResultTool.success();
        return res;
    }

    @RequestMapping("/test3")
    @ResponseBody
    public JsonResult test3(@RequestBody Integer x)
    {
        System.out.println(x);
        JsonResult res= ResultTool.success();
        return res;
    }

    @RequestMapping(value="/test4")
    @ResponseBody
    public JsonResult test4(@RequestBody Map map)
    {
        for (Object key : map.keySet()) {

            System.out.println("key = " + key.toString());
        }
        // 遍历map中的值
        for (Object  value : map.values()) {
            System.out.println(value.getClass());
            System.out.println("key = " + value.toString());
        }
        JsonResult res= ResultTool.success();
        return res;
    }

    @RequestMapping(value="/test5")
    @ResponseBody
    public JsonResult test5(@RequestBody List<String> macroPath)
    {
        for(String sPath :macroPath) {
            System.out.println(sPath);
        }
        JsonResult res= ResultTool.success();
        return res;
    }
    @RequestMapping(value="/test6")
    @ResponseBody
    public JsonResult test6(@RequestBody List<Integer> macroPath)
    {
        for(Integer sPath :macroPath) {
            System.out.println(sPath);
        }
        JsonResult res= ResultTool.success();
        return res;
    }





    @RequestMapping("/validate")
    @ResponseBody
    public JsonResult data(@RequestParam("token") String token) {
        String username = JwtTokenUtil.getUsername(token);
        if (username != null)
        {
            String role = JwtTokenUtil.getUserRole(token);
            String[] roles = StringUtils.strip(role, "[]").split(", ");
            Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
            for (String s:roles)
            {
                authorities.add(new SimpleGrantedAuthority(s));
            }
            ReadervoExample readervoExample=new ReadervoExample();
            ReadervoExample.Criteria criteria = readervoExample.createCriteria();
            criteria.andRmailEqualTo(username);
            List<Readervo>list= readervoMapper.selectByExample(readervoExample);
            if(list.size()>0)
            {
                JsonResult res = ResultTool.success();
                Map data = new HashMap();
                String newtoken = JwtTokenUtil.createToken(username, authorities.toString());
                data.put("token", newtoken);
                data.put("infor", list.get(0));
                res.setData(data);
                return res;
            }
            else
            {
                JsonResult res=ResultTool.fail(ResultCode.USER_ACCOUNT_DISABLE);
                return res;
            }
        }
        else
        {
            JsonResult res=ResultTool.fail(ResultCode.PARAM_NOT_VALID);
            return res;
        }

    }




    @GetMapping("/getstar")
    @ResponseBody
    public JsonResult getstar() {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user= authenticationToken.getPrincipal().toString();
        int userId=Integer.parseInt(user);
        StarvoExample starvoExample = new StarvoExample();
        StarvoExample.Criteria criteria = starvoExample.createCriteria();
        criteria.andRidEqualTo(userId);
        List<Starvo> list=starvoMapper.selectByExample(starvoExample);
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



    @GetMapping("/getbranch")
    @ResponseBody
    public JsonResult getbranch(Pageparam pageparam) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user= authenticationToken.getPrincipal().toString();
        int userId=Integer.parseInt(user);
        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        Page<Branchvo> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());
        BranchvoExample branchvoExample = new BranchvoExample();
        BranchvoExample.Criteria criteria = branchvoExample.createCriteria();
        criteria.andAuthoridEqualTo(userId);
        List<Branchvo> list = branchvoMapper.selectByExample(branchvoExample);

        p.setTotal(page.getTotal());
        p.setRows(list);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return  res;
    }


    @PostMapping("/putstar")
    @ResponseBody
    public JsonResult putstar(@RequestParam("branchid") int branchid) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user= authenticationToken.getPrincipal().toString();
        int userId=Integer.parseInt(user);
        StarExample starExample=new StarExample();
        StarExample.Criteria criteria = starExample.createCriteria();
        criteria.andBidEqualTo(branchid);
        criteria.andRidEqualTo(userId);

        List<Star> list=starMapper.selectByExample(starExample);
        if(list.size()>0)
        {
            Star star=list.get(0);
            Date date=new Date();
            star.setSttime(date);
            starMapper.updateByPrimaryKey(star);
            JsonResult res = ResultTool.success();
            return res;
        }
        else
        {
            Star star=new Star();
            star.setBid(branchid);
            star.setRid(userId);
            Date date=new Date();
            star.setSttime(date);
            starMapper.insert(star);
            JsonResult res = ResultTool.success();
            return res;
        }
    }

    @PostMapping ("/deletestar")
    @ResponseBody
    public JsonResult deletestar(@RequestBody List<Integer> list) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user= authenticationToken.getPrincipal().toString();
        int userId=Integer.parseInt(user);
        StarExample starExample = new StarExample();
        StarExample.Criteria criteria = starExample.createCriteria();
        criteria.andRidEqualTo(userId);
        criteria.andBidIn(list);
        try {
            starMapper.deleteByExample(starExample);
        }
        catch (Exception e)
        {
            JsonResult res = ResultTool.fail(ResultCode.SQL_NOTFIND_ERROR);
            return res;
        }
        JsonResult res = ResultTool.success();
        return res;
    }






    @RequestMapping("/putthumb")
    @ResponseBody
    public JsonResult putthumb(@RequestParam("branchid") int branchid,@RequestParam("thumbkind") boolean thumbkind) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user= authenticationToken.getPrincipal().toString();
        int userId=Integer.parseInt(user);

        ThumbExample example = new ThumbExample();
        ThumbExample.Criteria criteria = example.createCriteria();
        criteria.andBidEqualTo(branchid);
        criteria.andRidEqualTo(userId);

        List<Thumb>list=thumbMapper.selectByExample(example);
        if(list.size()>0)
        {
            Thumb thumb=list.get(0);
            boolean kind=thumb.getTheva();
            Date date = new Date();
            thumb.setTheva(thumbkind);
            thumb.setThtime(date);
            thumbMapper.updateByExample(thumb,example);
            JsonResult res = ResultTool.success();
            res.setData(kind==thumbkind?1:2);
            return res;

        }
        else
        {
            Thumb thumb=new Thumb();
            thumb.setBid(branchid);
            thumb.setRid(userId);
            Date date = new Date();
            thumb.setTheva(thumbkind);
            thumb.setThtime(date);
            thumbMapper.insert(thumb);
            JsonResult res = ResultTool.success();
            res.setData(0);
            return res;
        }

    }

    @RequestMapping("/updateself")
    @ResponseBody
    public  JsonResult updateself(MultipartFile file) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user = authenticationToken.getPrincipal().toString();
        int userId = Integer.parseInt(user);
        String filename = FileUtil.Save(file);
        if (filename == null)
        {
            filename=ConfigConstant.readerimg;
        }
            try {
                readerService.updatereader(userId,filename);
            }
            catch (Exception e)
            {
                JsonResult res=ResultTool.fail();
                return res;
            }

            JsonResult res=ResultTool.success();
            return res;

    }




    @RequestMapping("/putdiscuss")
    @ResponseBody
    public JsonResult putdiscuss(@RequestParam("branchid") int branchid,@RequestParam("comment")String comment) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user = authenticationToken.getPrincipal().toString();
        int userId = Integer.parseInt(user);
        Date date = new Date();
        Discuss discuss=new Discuss();
        discuss.setBid(branchid);
        discuss.setRid(userId);
        discuss.setComment(comment);
        discuss.setTime(date);

        try {
            discussMapper.insert(discuss);
        }
        catch (Exception e)
        {
            JsonResult res=ResultTool.fail();
            return res;
        }
        JsonResult res=ResultTool.success();
        return res;

    }

    @RequestMapping("/getdiscuss")
    @ResponseBody
    public JsonResult getdiscuss(Pageparam pageparam) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user = authenticationToken.getPrincipal().toString();
        int userId = Integer.parseInt(user);
        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        Page<Discussvo> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());
        DiscussvoExample discussvoExample = new DiscussvoExample();
        DiscussvoExample.Criteria criteria = discussvoExample.createCriteria();
        criteria.andRidEqualTo(userId);
        discussvoExample.setOrderByClause("time ASC");
        List<Discussvo> list = discussvoMapper.selectByExample(discussvoExample);

        p.setTotal(page.getTotal());
        p.setRows(list);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return res;
    }

    @RequestMapping("/deletediscuss")
    @ResponseBody
    public JsonResult deletediscuss(@RequestParam("discussid") int discussid) {
        
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user= authenticationToken.getPrincipal().toString();
        int userId=Integer.parseInt(user);

        try {
            discussMapper.deleteByPrimaryKey(discussid);
        }
        catch (Exception e)
        {
            JsonResult res = ResultTool.fail(ResultCode.SQL_NOTFIND_ERROR);
            return res;
        }
        JsonResult res = ResultTool.success();
        return res;
    }



    @RequestMapping("/putchapter")
    @ResponseBody
    public JsonResult putchapter(@RequestParam("branchid") int branchid,String title,String body) {

        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(body) ) {
            JsonResult res= ResultTool.fail(ResultCode.PARAM_NOT_COMPLETE);
            return res;
        }

        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user = authenticationToken.getPrincipal().toString();
        int userId = Integer.parseInt(user);
        if(!rtobtocService.bisfromr(branchid,userId))
        {
            JsonResult res= ResultTool.fail(ResultCode.NO_PERMISSION);
            return res;
        }


        try {
            rtobtocService.insertChapter(branchid,title,body);
        }
        catch (Exception e)
        {
            JsonResult res=ResultTool.fail();
            return res;
        }
        JsonResult res=ResultTool.success();
        return res;
    }

    @RequestMapping("/putbranch")
    @ResponseBody
    public JsonResult putbranch(MultipartFile file, HttpServletRequest request) {
        String title=request.getParameter("title");
        String introduce=request.getParameter("introduce");
        Integer pre=Integer.parseInt(request.getParameter("pre"));
        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(introduce) ) {
            JsonResult res= ResultTool.fail(ResultCode.PARAM_NOT_COMPLETE);
            return res;
        }

        String filename=FileUtil.Save(file);
        if(filename==null)
            filename= ConfigConstant.bookimg;

        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user = authenticationToken.getPrincipal().toString();
        int userId = Integer.parseInt(user);
        Integer bid=0;
        try {
          bid=rtobtocService.insertBranch(userId,title,introduce,filename,pre);
        }
        catch (Exception e)
        {
            JsonResult res=ResultTool.fail();
            return res;
        }
        if(bid==0)
        {
            JsonResult res=ResultTool.fail();
            return res;
        }
        JsonResult res=ResultTool.success();
        res.setData(bid);
        return res;
    }

    @RequestMapping("/updatebranch")
    @ResponseBody
    public JsonResult updatebranch(MultipartFile file, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user = authenticationToken.getPrincipal().toString();
        int userId = Integer.parseInt(user);

        String title=request.getParameter("title");
        String introduce=request.getParameter("introduce");
        Integer branchid=Integer.parseInt(request.getParameter("branchid"));

        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(introduce) ) {
            JsonResult res= ResultTool.fail(ResultCode.PARAM_NOT_COMPLETE);
            return res;
        }

        if(!rtobtocService.bisfromr(branchid,userId))
        {
            JsonResult res= ResultTool.fail(ResultCode.NO_PERMISSION);
            return res;
        }

        String filename=FileUtil.Save(file);
        if(filename==null)
            filename= ConfigConstant.bookimg;


        try {
            rtobtocService.updateBranch(branchid,title,introduce,filename);
        }
        catch (Exception e)
        {
            JsonResult res=ResultTool.fail();
            return res;
        }
        JsonResult res=ResultTool.success();
        return res;
    }

    @RequestMapping("/getchat")
    @ResponseBody
    public JsonResult getchat(@RequestParam("to") Integer to, Pageparam pageparam) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user = authenticationToken.getPrincipal().toString();
        int userId = Integer.parseInt(user);

        Pager p = new Pager(pageparam.getPageNum(), pageparam.getPageSize());
        Page<Chatvo> page = PageHelper.startPage(pageparam.getPageNum(), pageparam.getPageSize());
        ChatvoExample chatvoExample=new ChatvoExample();
        ChatvoExample.Criteria criteria1 = chatvoExample.createCriteria();
        criteria1.andFromidEqualTo(userId);
        criteria1.andToidEqualTo(to);
        ChatvoExample.Criteria criteria2 =chatvoExample.or();
        criteria2.andFromidEqualTo(to);
        criteria2.andToidEqualTo(userId);
        chatvoExample.setOrderByClause("time DESC");
        List<Chatvo>list=chatvoMapper.selectByExample(chatvoExample);
        p.setTotal(page.getTotal());
        p.setRows(list);
        JsonResult res = ResultTool.success();
        res.setData(p);
        return res;
    }


    @RequestMapping("/pushchat")
    @ResponseBody
    public JsonResult pushchat(@RequestParam("to") Integer to,String content) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String user = authenticationToken.getPrincipal().toString();
        int userId = Integer.parseInt(user);
        springWebSocketHandler.sendToUser(userId,to,content);
        JsonResult res = ResultTool.success();
        return res;
    }

}
