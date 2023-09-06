package com.moskalev.session;

import com.moskalev.session.session.SessionUserProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SessionUserProperties.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        //ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
       //RedisUtils.saveTestDataForRedis(context);


    }


}
