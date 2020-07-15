package parking.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import parking.config.FeignLogConfiguration;
import parking.entity.Member;
import parking.feign.fallback.MemberFeignFallback;

@FeignClient(value = "member-service",fallbackFactory = MemberFeignFallback.class)
public interface MemberFeignClient {


    @RequestMapping(value = "/member/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Object memberById(@PathVariable(value="id") int id);

    @RequestMapping(value = "/member",method = RequestMethod.GET)
    @ResponseBody
    public Object memberList();

    @RequestMapping(value = "/member",method = RequestMethod.POST,consumes = "application/json;charset=utf8")
    @ResponseBody
    public Object saveMember(@RequestBody Member member);

    @PutMapping(value = "/member",consumes = "application/json;charset=utf8")
    @ResponseBody
    public Object updateMember(@RequestBody Member member);

    @DeleteMapping(value = "/member/{id}")
    @ResponseBody
    public Object deleteMemberById(@PathVariable(value="id") int id);

}
