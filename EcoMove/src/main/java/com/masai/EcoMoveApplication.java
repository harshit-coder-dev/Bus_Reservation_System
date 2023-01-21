package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.masai")
public class EcoMoveApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcoMoveApplication.class, args);
    }

}
