package com.gm.parking.controller;


import com.alibaba.fastjson.JSON;
import com.gm.parking.common.Resp;
import com.gm.parking.entity.Member;
import com.gm.parking.service.MemberService;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger=LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;


    @RequestMapping(value = "/member/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object memberById(@PathVariable("id") Integer id)
    {
        logger.info("进入memberID");
        Member member=memberService.memberById(id);
        if(member!=null)
        {
            logger.info("获取member数据"+member);
            Map<String,Object> result=new HashMap<>();
            result.put("data",member);
            Resp resp=new Resp("200",result,"获取member数据成功");
            return JSON.toJSON(resp);
        }
        Resp resp=new Resp("200",null,"获取member数据失败");
        return JSON.toJSON(resp);
    }

    @DeleteMapping(value = "/member/{id}")
    @ResponseBody
    public Object deleteMemberById(@PathVariable("id")int id)
    {
        logger.info("进入memberDelete");
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

    @RequestMapping(value = "/member",method = RequestMethod.POST,consumes = "application/json;charset=utf8")
    @ResponseBody
    public Object saveMember(@RequestBody Member member)
    {
        logger.info("进入memberPost");
        logger.warn("member is id \t"+member.getId()+"member name is \t"+member.getMemberName());
        boolean flag=memberService.saveMember(member);
        if(flag)
        {
            Resp resp=new Resp("200",null,"插入成功");
            return JSON.toJSON(resp);
        }
        Resp resp=new Resp("200",null,"插入失败");
        return JSON.toJSON(resp);
    }

    @PutMapping(value = "/member",consumes = "application/json;charset=utf8")
    @ResponseBody
    public Object updateMember(@RequestBody Member member)
    {
        logger.warn("member id is \t"+member.getId()+"member name is \t"+member.getMemberName());
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
