package com.next.controller;

import com.next.service.MeetHighElasticSearchService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springboot/es/hight")
public class MeetHighElasticSearchController {
    @Autowired
    private MeetHighElasticSearchService meetHighElasticSearchService;

    @RequestMapping("/index/put")
    public String putIdexInHighElasticSearch(String indexName ,String document ){
        if(Strings.isEmpty(indexName)||Strings.isEmpty(document)){
            return "Parameters  are  error !";
        }
        meetHighElasticSearchService.indexDocuments(indexName,document);
        return "Index High ElasticSearch Client Successed!";
    }

    @RequestMapping("/index/get")
    public String gettIdexInHighElasticSearch(String indexName ,String document ){
        if(Strings.isEmpty(indexName)||Strings.isEmpty(document)){
            return "Parameters  are  error !";
        }
        meetHighElasticSearchService.getIndexDocuments(indexName,document);
        return "get Index High ElasticSearch Client Successed!";
    }

    @RequestMapping("/index/delete")
    public String deleteIdexInHighElasticSearch(String indexName ,String document ){
        if(Strings.isEmpty(indexName)||Strings.isEmpty(document)){
            return "Parameters  are  error !";
        }
        meetHighElasticSearchService.deleteRequestIndexDocuments(indexName,document);
        return "delete Index High ElasticSearch Client Successed!";
    }
}
