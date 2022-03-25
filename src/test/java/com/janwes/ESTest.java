package com.janwes;

import com.janwes.domain.esdb.Item;
import com.janwes.repository.esrepository.ItemEsRepository;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author Janwes
 * @version 1.0.0
 * @package com.janwes
 * @date 2022/3/25 11:56
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ESTest {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private ItemEsRepository itemEsRepository;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void save() {
        Item item = itemEsRepository.save(
                new Item(3L, "蓝胖子",
                        "澳洲",
                        "致力于婴幼儿智力健康发展", 99.9, new Date(), new Date()));
        System.out.println(item);
    }
}
