package parking.service.impl;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value ="card-service")
public interface CardFeignService {

    @GetMapping("/card")
    public Object cardList();

}
