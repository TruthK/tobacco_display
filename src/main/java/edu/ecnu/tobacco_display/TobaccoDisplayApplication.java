package edu.ecnu.tobacco_display;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("edu.ecnu.tobacco_display.mapper")
@EnableTransactionManagement
public class TobaccoDisplayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TobaccoDisplayApplication.class, args);
    }

}
