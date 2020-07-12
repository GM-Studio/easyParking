package com.gm.parking;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(" com.gm.parking.mapper")
public class CardApplication {

  public static   Logger logger=LoggerFactory.getLogger(CardApplication.class);


  public static void main(String[] args) {
    SpringApplication.run(CardApplication.class, args);
    logger.info("application is running ");
  }
}
