package com.search.bo;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Builder
@Document(indexName = "article")
public class Article {

    @Id
    private String id;
    private String title;
    private String content;
    private Integer userId;
    private Date createTime;

}
