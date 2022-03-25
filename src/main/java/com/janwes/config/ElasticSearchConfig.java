package com.janwes.config;

import com.janwes.utils.SecurityUtil;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Janwes
 * @version 1.0.0
 * @package com.janwes.config
 * @date 2022/3/25 16:37
 * @description elasticsearch配置类
 * 高级rest客户端配置
 */
@Configuration
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchConfig.class);

    @Autowired
    private ElasticsearchRestClientProperties properties;

    @Override
    @Bean("restHighLevelClient")
    public RestHighLevelClient elasticsearchClient() {
        // 密文解密
        String password = SecurityUtil.decrypt(properties.getPassword());
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(getHostAndPort()) // 设置es服务地址
                .withBasicAuth(properties.getUsername(), password) // 设置用户名、密码
                .withConnectTimeout(properties.getConnectionTimeout()) // 设置连接超时时间
                .withSocketTimeout(properties.getReadTimeout()) // 设置读取超时时间
                .build();
        LOGGER.info("===> initialize ElasticSearchConfig,connect to ElasticSearch server success......");
        return RestClients.create(clientConfiguration).rest();
    }

    /**
     * 获取主机地址和端口号
     *
     * @return
     */
    private String[] getHostAndPort() {
        List<String> uris = properties.getUris();
        List<String> results = new ArrayList<>();
        String[] uriArr = new String[uris.size()];
        for (String uri : uris) {
            // elasticsearch连接服务地址不能包含"http://"
            if (uri.startsWith("http://")) {
                results.add(uri.split("//")[1]);
                continue;
            }
            results.add(uri);
        }
        results.toArray(uriArr);
        return uriArr;
    }
}
