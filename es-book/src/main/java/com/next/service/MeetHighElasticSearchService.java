package com.next.service;

public interface MeetHighElasticSearchService {

    public void initEs();

    public void closeEs();
    public void indexDocuments(String indexName, String document);

    void getIndexDocuments(String indexName, String document);

    //以同步的方式校验索引文档是否存在
    void checkExistIndexDocuments(String indexName,String document);

    //以异步的方式校验索引文档是否存在
    void checkExistIndexDocumentsAsync(String indexName,String document);

    //删除文档
    void deleteRequestIndexDocuments(String indexName,String document);

    //异步删除文档
    void deleteRequestIndexDocumentsAsync(String indexName,String document);

    //构建词向量
    public void buildTermVectorsRequest(String indexName , String document , String field);

    //更新文档
    void updateRequestIndexDocuments(String indexName, String document );
}
