package com.janwes.config;

import com.janwes.utils.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

/**
 * @author Janwes
 * @version 1.0.0
 * @package com.janwes.config
 * @date 2022/3/20 11:37
 * @description MongoDB配置类
 */
@Configuration
public class MongoDBConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoDBConfiguration.class);

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory() {
        try {
            // 密文解密
            String realUri = SecurityUtil.decrypt(uri);
            LOGGER.info("===> initialize MongoDBConfiguration,connect to MongoDB server success......");
            return new SimpleMongoClientDatabaseFactory(realUri);
        } catch (Exception e) {
            throw new RuntimeException("===> connect to MongoDB server failure......", e);
        }
    }
}
