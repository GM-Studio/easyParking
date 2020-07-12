package com.gm.parking.controller;


import com.alibaba.fastjson.JSON;
import com.gm.parking.common.Resp;
import com.gm.parking.entity.Member;
import com.gm.parking.service.MemberService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Squirrel-Chen
 */
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;


    @RequestMapping(value = "/member/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object memberById(@PathVariable("id") Integer id)
    {
        Member member=memberService.memberById(id);
        if(member!=null)
        {
            Map<String,Object> result=new HashMap<>();
            result.put("data",member);
            Resp resp=new Resp("200",result,"获取member数据成功");
            return JSON.toJSON(resp);
        }
        Resp resp=new Resp("200",null,"获取member数据失败");
        return JSON.toJSON(resp);
    }

    @RequestMapping(value = "/member/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteMemberById(@PathVariable("id")int id)
    {
        boolean flag=memberService.deleteMemberById(id);
        if(flag)
        {
            Resp resp=new Resp("200",null,"删除成功");
            return JSON.toJSON(resp);
        }
        Resp resp=new Resp("200",null,"删除失败");
        return JSON.toJSON(resp);
    }

    @RequestMapping(value = "/member",method = RequestMethod.GET)
    @ResponseBody
    public Object memberList()
    {
        List<Member> members=memberService.memberList();
        if(members!=null&&members.size()!=0)
        {
            Map<String, Object> result=new HashMap<>();
            result.put("data",members);
            Resp resp=new Resp("200",result,"获取成功");
            return JSON.toJSON(resp);
        }
        Resp resp=new Resp("200",null,"获取失败");
        return JSON.toJSON(resp);
    }

    @RequestMapping(value = "/member",method = RequestMethod.POST)
    @ResponseBody
    public Object saveMember(Member member)
    {
        boolean flag=memberService.saveMember(member);
        if(flag)
        {
            Resp resp=new Resp("200",null,"插入成功");
            return JSON.toJSON(resp);
        }
        Resp resp=new Resp("200",null,"插入失败");
        return JSON.toJSON(resp);
    }

    @RequestMapping(value = "/member",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateMember(Member member)
    {
        boolean flag=memberService.updateMember(member);
        if(flag)
        {
            Resp resp=new Resp("200",null,"更新成功");
            return JSON.toJSON(resp);
        }
        Resp resp=new Resp("200",null,"更新失败");
        return JSON.toJSON(resp);
    }










}
