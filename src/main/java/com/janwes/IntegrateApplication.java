package com.janwes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Janwes
 * @version 1.0.0
 * @package com.janwes
 * @date 2022/3/19 17:12
 * @description
 */
@SpringBootApplication
@EnableElasticsearchRepositories({"com.janwes.repository.esrepository"}) // 开启elasticsearch包实例扫描
@EnableMongoRepositories({"com.janwes.repository.mgrepository"}) // 开启MongoDB包实例扫描
@MapperScan({"com.janwes.mapper"})
public class IntegrateApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegrateApplication.class, args);
    }
}
