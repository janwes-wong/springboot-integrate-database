package com.janwes.repository.esrepository;

import com.janwes.domain.esdb.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Janwes
 * @version 1.0.0
 * @package com.janwes.repository.esrepository
 * @date 2022/3/25 14:59
 * @description
 */
public interface ItemEsRepository extends ElasticsearchRepository<Item, Long> {
}
