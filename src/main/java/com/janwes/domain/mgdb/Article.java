package com.janwes.domain.mgdb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author Janwes
 * @version 1.0.0
 * @package com.janwes.domain.mgdb
 * @date 2022/3/20 10:29
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "e_article")
public class Article {

    private ObjectId id;

    private String title;

    private String author;

    private Double price;

    private Long publishTime;

    private Date createDate;

    private Date updateDate;
}
