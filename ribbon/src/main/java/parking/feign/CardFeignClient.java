package parking.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import parking.config.FeignLogConfiguration;
import parking.entity.Card;


@FeignClient(value = "card-service",configuration = FeignLogConfiguration.class)
public interface CardFeignClient {


    @RequestMapping(value = "/card/{id}",method = RequestMethod.GET)
    public Object cardById(@PathVariable("id")int id);

    @RequestMapping(value = "/card",method = RequestMethod.GET)
    public Object cardList();

    @RequestMapping(value = "/card",method = RequestMethod.POST)
    @ResponseBody
    public Object saveCard(@RequestBody Card card);

    @RequestMapping(value = "/card",method = RequestMethod.PUT)
    public Object updateCard(@RequestBody Card card);

    @RequestMapping(value = "/card/{id}",method = RequestMethod.DELETE)
    public Object deleteCardById(@PathVariable("id")int id);


}
