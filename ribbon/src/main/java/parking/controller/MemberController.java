package parking.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import parking.entity.Member;
import parking.service.impl.CardFeignService;
import parking.service.impl.MemberService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@FeignClient(value="card-service")
public class MemberController {

//    @GetMapping("/card")
//    public Object cardList();


    @Autowired
    private CardFeignService cardFeignService;
    @Autowired
    private MemberService memberService;

//    @Autowired
//    private RestTemplate restTemplate;

    @RequestMapping(value = "/card",method = RequestMethod.GET)
//    @GetMapping("/card")
    @ResponseBody
    public Object memberList()
    {
        Map resultmap = new HashMap();
        resultmap.put("cardlist",cardFeignService.cardList());
        resultmap.put("memberlist",memberService.memberList());

        return JSON.toJSON(resultmap);
//        return cardFeignService.cardList();
//        return restTemplate.getForObject("http://card-service/card", Object.class);
//        return memberService.memberList();
    }




}
