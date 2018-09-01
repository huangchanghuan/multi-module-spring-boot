package com.yimi.product.turbineserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
// @EnableTurbine注解包含了@EnableDiscoveryClient注解
@EnableTurbine
@EnableHystrixDashboard
public class TurbineServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurbineServerApplication.class, args);
    }
}
