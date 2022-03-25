package com.janwes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Janwes
 * @version 1.0.0
 * @package com.janwes
 * @date 2022/3/19 17:12
 * @description
 */
@SpringBootApplication
@MapperScan({"com.janwes.mapper"})
public class IntegrateApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegrateApplication.class, args);
    }
}
