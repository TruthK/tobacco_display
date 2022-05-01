package edu.ecnu.tobacco_display;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@MapperScan("edu.ecnu.tobacco_display.mapper")
@EnableTransactionManagement
@EnableOpenApi
public class TobaccoDisplayApplication {
    public static void main(String[] args) {
        SpringApplication.run(TobaccoDisplayApplication.class, args);
    }

}
