package parking;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrixDashboard
public class HystrixApplication {

    private static final Logger logger=LoggerFactory.getLogger(HystrixApplication.class);

  public static void main(String[] args) {

      SpringApplication.run(HystrixApplication.class,args);
      logger.info("HystrixApplication is Running");
  }
}
