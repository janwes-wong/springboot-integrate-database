package com.janwes.domain.esdb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Janwes
 * @version 1.0.0
 * @package com.janwes.domain.esdb
 * @date 2022/3/25 14:49
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "item_index_001")
public class Item implements Serializable {

    private static final long serialVersionUID = 1523117979479944104L;

    /**
     * 表示该字段的值存放到索引库的_id字段上，表示主键
     */
    @Id
    private Long id;

    /**
     * index默认为true
     */
    @Field(index = true, type = FieldType.Text, analyzer = "ik_smart", store = false, searchAnalyzer = "ik_smart")
    private String itemName;

    @Field(index = true, type = FieldType.Text, analyzer = "ik_smart", store = false, searchAnalyzer = "ik_smart")
    private String productArea;

    @Field(index = true, type = FieldType.Text, analyzer = "ik_smart", store = false, searchAnalyzer = "ik_smart")
    private String productDesc;

    @Field(index = true, type = FieldType.Double)
    private Double price;

    /**
     * type类型为Date时间时，必须添加format时间格式，否则启动报错
     */
    @Field(index = true, type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date createDate;

    @Field(index = true, type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date updateDate;
}
