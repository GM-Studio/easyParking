package parking;


import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class RibbonApplication {

  public  static final Logger logger= LoggerFactory.getLogger(RibbonApplication.class);


  public static void main(String[] args) {
    SpringApplication.run(RibbonApplication.class, args);
    logger.info("application is running ");
  }

//  @Bean
//  @LoadBalanced
//    RestTemplate restTemplate()
//  {
//      return new RestTemplate();
//  }

  @Bean
  public Sampler defaultSampler()
  {
    return Sampler.ALWAYS_SAMPLE;
  }


}
