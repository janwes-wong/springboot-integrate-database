package com.janwes;

import com.janwes.domain.mgdb.Article;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author Janwes
 * @version 1.0.0
 * @package com.janwes
 * @date 2022/3/20 10:57
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoDBTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insert() {
        Article article = new Article();
        //article.setId(ObjectId.get()); // 设置id,也可以通过MongoDB自动生成ObjectId
        article.setTitle("战争与和平");
        article.setAuthor("CCTV");
        article.setPrice(23.9);
        article.setPublishTime(System.currentTimeMillis());
        article.setCreateDate(new Date());
        article.setUpdateDate(new Date());
        Article result = mongoTemplate.save(article);
        System.out.println(result);
    }
}
