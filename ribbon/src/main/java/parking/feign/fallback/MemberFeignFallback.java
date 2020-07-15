package parking.feign.fallback;

import com.alibaba.fastjson.JSON;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import parking.entity.Member;
import parking.feign.MemberFeignClient;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemberFeignFallback implements FallbackFactory<MemberFeignClient> {


    private static final Logger loger=LoggerFactory.getLogger(MemberFeignFallback.class);

    private String msg=null;
    private int code=-1;
    private Map result=new HashMap<String,Object>();


    @Override
    public MemberFeignClient create(Throwable throwable) {

        return new MemberFeignClient() {

            @Override
            public Object memberById(int id) {
                MemberFeignFallback.loger.error("fallback memberById function ;reason as: \t"+throwable);

                msg="获取memberID失败，任务回滚";
                code=10001;
                result.put("code",code);
                result.put("msg",msg);
                return JSON.toJSON(result);
            }

            @Override
            public Object memberList() {

                MemberFeignFallback.loger.error("fallback memberList function ;reason as: \t"+throwable);
                msg="获取memberList失败，任务回滚";
                code=10002;
                result.put("code",code);
                result.put("msg",msg);
                return JSON.toJSON(result);
            }

            @Override
            public Object saveMember(Member member) {

                MemberFeignFallback.loger.error("fallback saveMember function ;reason as: \t"+throwable);
                msg="保存member失败，任务回滚";
                code=10003;
                result.put("code",code);
                result.put("msg",msg);
                return JSON.toJSON(result);
            }

            @Override
            public Object updateMember(Member member) {

                MemberFeignFallback.loger.error("fallback updatemember function ;reason as: \t"+throwable);
                msg="更新member失败，任务回滚";
                code=10004;
                result.put("code",code);
                result.put("msg",msg);
                return JSON.toJSON(result);
            }

            @Override
            public Object deleteMemberById(int id) {

                MemberFeignFallback.loger.error("fallback deletemember function ;reason as: \t"+throwable);
                msg="删除memberId失败，任务回滚";
                code=10005;
                result.put("code",code);
                result.put("msg",msg);
                return JSON.toJSON(result);
            }
        };
    }

}
