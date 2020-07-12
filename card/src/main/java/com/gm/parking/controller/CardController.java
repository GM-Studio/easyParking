package com.gm.parking.controller;


import com.alibaba.fastjson.JSON;
import com.gm.parking.common.Resp;
import com.gm.parking.entity.Card;
import com.gm.parking.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Squirrel-Chen
 */
@Controller
public class CardController {

    private final Logger logger=LoggerFactory.getLogger(CardController.class);

    @Autowired
    private CardService cardService;


    @RequestMapping(value = "/card/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object memberById(@PathVariable("id") Integer id)
    {
        Card card=cardService.cardById(id);
        if(card!=null)
        {
            Map<String,Object> result=new HashMap<>();
            result.put("data",card);
            Resp resp=new Resp("200",result,"获取member数据成功");
            return JSON.toJSON(resp);
        }
        Resp resp=new Resp("200",null,"获取member数据失败");
        return JSON.toJSON(resp);
    }

    @RequestMapping(value = "/card/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteMemberById(@PathVariable("id")int id)
    {
        boolean flag=cardService.deleteCard(id);
        if(flag)
        {
            Resp resp=new Resp("200",null,"删除成功");
            return JSON.toJSON(resp);
        }
        Resp resp=new Resp("200",null,"删除失败");
        return JSON.toJSON(resp);
    }

    @RequestMapping(value = "/card",method = RequestMethod.GET)
    @ResponseBody
    public Object memberList()
    {
        List<Card> members=cardService.cardList();
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

    @RequestMapping(value = "/card",method = RequestMethod.POST)
    @ResponseBody
    public Object saveMember(Card card)
    {
        boolean flag=cardService.saveCard(card);
        if(flag)
        {
            Resp resp=new Resp("200",null,"插入成功");
            return JSON.toJSON(resp);
        }
        Resp resp=new Resp("200",null,"插入失败");
        return JSON.toJSON(resp);
    }

    @RequestMapping(value = "/card",method = RequestMethod.PUT)
    @ResponseBody
    public Object updateMember(Card card)
    {
        boolean flag=cardService.updateCard(card);
        if(flag)
        {
            Resp resp=new Resp("200",null,"更新成功");
            return JSON.toJSON(resp);
        }
        Resp resp=new Resp("200",null,"更新失败");
        return JSON.toJSON(resp);
    }


    @RequestMapping(value = "/member/{uid}",method = RequestMethod.GET)
    @ResponseBody
    public Object bindMemberCard(@PathVariable("uid")int uid)
    {

        logger.info("进入服务间的http调用");

        if(uid!=0)
        {
            Date sysDate=new Date();
            Card card=new Card(100,sysDate,sysDate,uid);
            boolean flag=cardService.saveCard(card);
            if(flag)
                {
                    logger.warn("http调用服务成功");
                    Resp resp=new Resp("200",null,"绑定会员卡成功");
                    return JSON.toJSON(resp);
                }

        }
        logger.warn("http调用服务失败");
        Resp resp=new Resp("200",null,"绑定会员卡失败");
        return JSON.toJSON(resp);
    }









}
