package com.janwes;

import com.janwes.domain.mgdb.Article;
import com.janwes.repository.mgrepository.ArticleMongoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

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

    /**
     * 基于spring中的标准模板模式的MongoTemplate实现一些简单api操作
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 以Spring Data为中心的方法，基于所有Spring数据项目中众所周知的访问模式，提供更加灵活和复杂的api操作
     */
    @Autowired
    private ArticleMongoRepository articleMongoRepository;

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

    @Test
    public void save() {
        Article article = new Article();
        article.setTitle("高山下的花环");
        article.setAuthor("阿六");
        article.setPrice(36.1);
        article.setPublishTime(System.currentTimeMillis());
        article.setCreateDate(new Date());
        article.setUpdateDate(new Date());
        article = articleMongoRepository.save(article);
        System.out.println(article);
    }

    @Test
    public void update() {
        // 根据id获取
        Optional<Article> articleOptional = articleMongoRepository.findById("623d2af18eda5a6b40042b54");
        Article article = new Article();
        if (articleOptional.isPresent()) {
            article = articleOptional.get();
        }
        article.setAuthor("尼古拉斯·赵四");
        article.setPrice(36.1);
        // 存在id结果则修改，不存在则新增
        article = articleMongoRepository.save(article);
        System.out.println(article);
    }
}
