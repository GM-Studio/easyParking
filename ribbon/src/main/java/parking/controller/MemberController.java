package parking.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import parking.entity.Card;
import parking.entity.Member;
import parking.feign.CardFeignClient;
import parking.feign.MemberFeignClient;


@Controller
public class MemberController {

    private static final Logger logger=LoggerFactory.getLogger(MemberController.class);

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private MemberFeignClient memberFeignClient;

    @Autowired
    private CardFeignClient cardFeignClient;


    @RequestMapping(value = "/member/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object memberById(@PathVariable("id")int id)
    {
        logger.info("远程调用memberID");
        return memberFeignClient.memberById(id);
    }

    @RequestMapping(value = "/member",method = RequestMethod.GET)
    @ResponseBody
    public Object memberList()
    {
        logger.info("远程调用memberList");
        return memberFeignClient.memberList();
    }

    @RequestMapping(value = "/member",method = RequestMethod.POST,consumes = "application/json;charset=utf8")
    @ResponseBody
    public Object saveMember(@RequestBody Member member)
    {
        logger.warn("member id "+member.getId()+"membername is "+member.getMemberName());

        logger.info("远程调用savemember");
        return memberFeignClient.saveMember(member);
    }

    @PutMapping(value = "/member",consumes = "application/json;charset=utf8")
    @ResponseBody
    public Object updateMember(@RequestBody Member member)
    {
        logger.warn("member id "+member.getId()+"membername is "+member.getMemberName());
        logger.info("远程调用updatemember");
        return memberFeignClient.updateMember(member);
    }

    @DeleteMapping(value = "/member/{id}")
    @ResponseBody
    public Object deleteMemberById(@PathVariable("id")int id)
    {
        logger.info("远程调用deletemember");
        return memberFeignClient.deleteMemberById(id);
    }

    @RequestMapping(value = "/bindMemberCard",method = RequestMethod.POST,consumes = "application/json;charset=utf8")
    @ResponseBody
    public Object bindMemberCard(@RequestBody Card card)
    {
        logger.info("先绑定会员信息");
        Member member=new Member(123,"hello world");
        Object json= memberFeignClient.updateMember(member);
        if(json!=null)
        {
            logger.info("再绑定卡信息");
            return cardFeignClient.saveCard(card);
        }
        return null;
    }

}
