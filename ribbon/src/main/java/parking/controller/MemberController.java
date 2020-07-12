package parking.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import parking.entity.Member;
import parking.service.impl.CardFeignService;

import java.util.List;

@Controller
//@FeignClient(value="card-service")
public class MemberController {

//    @GetMapping("/card")
//    public Object cardList();


    @Autowired
    private CardFeignService cardFeignService;

//    @Autowired
//    private RestTemplate restTemplate;

    @RequestMapping(value = "/card",method = RequestMethod.GET)
//    @GetMapping("/card")
    @ResponseBody
    public Object memberList()
    {
        return cardFeignService.cardList();
//        return restTemplate.getForObject("http://card-service/card", Object.class);
    }


}
