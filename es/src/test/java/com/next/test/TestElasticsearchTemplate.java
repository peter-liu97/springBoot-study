package com.next.test;

import com.next.bean.Goods;
import com.next.bean.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@SpringBootTest
public class TestElasticsearchTemplate {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
     void creatIndex(){
        elasticsearchTemplate.createIndex(Goods.class);
        elasticsearchTemplate.putMapping(Goods.class);
    }
}
