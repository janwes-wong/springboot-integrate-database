package com.janwes.mgrepository;

import com.janwes.domain.mgdb.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Janwes
 * @version 1.0.0
 * @package com.janwes.mgrepository
 * @date 2022/3/25 10:20
 * @description
 */
public interface ArticleMongoRepository extends MongoRepository<Article, String> {

}
