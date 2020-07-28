package com.next.service.impl;

import com.next.service.MeetHighElasticSearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.support.replication.ReplicationOperation;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.core.TermVectorsRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.VersionType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class MeetHighElasticSearchServiceImpl implements MeetHighElasticSearchService {


    private RestHighLevelClient restHighLevelClient;

    @Override
    @PostConstruct
    public void initEs() {
        restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost("121.199.65.11", 9200, "http")));

        log.info("hElasticSearch init in service");
    }

    @Override
    public void closeEs() {
        try {
            restHighLevelClient.close();
            log.info("es close !");
        } catch (IOException e) {
            log.error("es IOException,e:{}", e);
            e.printStackTrace();

        }

    }

    /**
     * 基于String构建IndexRequest
     *
     * @param indexName
     * @param document
     */
    public void buildIndexRequestWithString(String indexName, String document) {
        //索引名称
        IndexRequest request = new IndexRequest(indexName);

        //文档id
        request.id(document);
        String jsonString = "{" + "\"user\":\"nuidong\"," + "\"postDate\":\"2019-07-30\","
                + "\"message\":\"Hello ElasticSearch\"" + "}";

        request.source(jsonString, XContentType.JSON);
    }

    /**
     * 基于Map构建IndexRequest
     */

    public void buildIndexRequestWithMap(String indexName, String document) {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "niudong");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "Hello ElasticSearch");

        IndexRequest indexRequest = new IndexRequest(indexName).id(document).source(jsonMap);
    }

    /**
     * 基于XcontentBuilder构建IndexRequest
     */
    public void buildIndexRequestWithXcontentBuilder(String indexName, String document) {
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject();
            builder.field("user", "nuidong");
            builder.field("postDate", new Date());
            builder.field("message", "Hello Es");
            builder.endObject();
            IndexRequest indexRequest = new IndexRequest(indexName).id(document).source(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于键值队构建IndexRequest
     */
    public void buildIndexRequestWithKV(String indexName, String document) {
        IndexRequest indexRequest = new IndexRequest(indexName).id(document).source(
                "user", "niudong", "postDate", new Date(), "message", "Hello Es"
        );
    }

    public void buildIndexRequestWithParam(String indexName, String document) {
        IndexRequest indexRequest = new IndexRequest(indexName).id(document).source(
                "user", "niudong", "postDate", new Date(), "message", "Hello Es"
        );
        //设置路由值
        indexRequest.routing("routing");
        indexRequest.timeout(TimeValue.timeValueSeconds(1)); //设置超时时间
        indexRequest.timeout("ls");

        //设置超时策略
        indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
        indexRequest.setRefreshPolicy("wait_for");

        //设置版本
        indexRequest.version(2);

        //设置版本类型
        indexRequest.versionType(VersionType.EXTERNAL);

        //设置操作类型
        indexRequest.opType("create");

        //在索引文档之前要执行的接受管道的名称
        indexRequest.setPipeline("pipeline");
    }

    /**
     * 同步方式
     *
     * @param indexName
     * @param document
     */
    public void indexDocuments(String indexName, String document) {
        IndexRequest indexRequest = new IndexRequest(indexName).id(document).source(
                "user", "niudong", "postDate", new Date(), "message", "Hello Es"
        );
        try {
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            processIndexResponse(indexResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeEs();
    }

    @Override
    public void getIndexDocuments(String indexName, String document) {
        GetRequest getRequest = new GetRequest(indexName,document);

        try {
            GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            processGetResponsee(getResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeEs();
    }

    @Override
    public void checkExistIndexDocuments(String indexName, String document) {
        GetRequest getRequest = new GetRequest(indexName, document);
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");
        try {
            boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
            log.info("索引"+indexName+"下的"+document+"文档的存在性是"+exists);
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeEs();
    }

    @Override
    public void checkExistIndexDocumentsAsync(String indexName, String document) {
        GetRequest getRequest = new GetRequest(indexName, document);
        getRequest.fetchSourceContext(new FetchSourceContext(false));

        ActionListener<Boolean> listener = new ActionListener<Boolean>() {
            @Override
            public void onResponse(Boolean aBoolean) {
                log.info("索引"+indexName+"下的"+document+"文档的存在性是"+aBoolean);
            }

            @Override
            public void onFailure(Exception e) {
            }
        };
        try {
            restHighLevelClient.existsAsync(getRequest,RequestOptions.DEFAULT,listener);
        }catch (Exception e){
            e.printStackTrace();
        }

        closeEs();
    }

    @Override
    public void deleteRequestIndexDocuments(String indexName, String document) {
        DeleteRequest deleteRequest = new DeleteRequest(indexName, document);
//        //设置路由
//        deleteRequest.routing("routing");
//        //设置超时
//        deleteRequest.timeout(TimeValue.timeValueSeconds(2));
//        deleteRequest.timeout("2m");
//        //设置刷新策略
//        deleteRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
//        deleteRequest.setRefreshPolicy("wait_for");
//        //设置版本
//        deleteRequest.version(2);
//        //设置版本类型
//        deleteRequest.versionType(VersionType.EXTERNAL);
        try {
            DeleteResponse delete = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        closeEs();
    }

    @Override
    public void deleteRequestIndexDocumentsAsync(String indexName, String document) {
        DeleteRequest deleteRequest = new DeleteRequest(indexName, document);
        ActionListener listener = new ActionListener<DeleteResponse>() {

            @Override
            public void onResponse(DeleteResponse deleteResponse) {
                String id = deleteResponse.getId();
                String index = deleteResponse.getIndex();
                long version = deleteResponse.getVersion();

                log.info("delete id is"+id+",index is"+index+",version is"+version);
            }

            @Override
            public void onFailure(Exception e) {

            }
        };
    }

    @Override
    public void buildTermVectorsRequest(String indexName, String document, String field) {
        TermVectorsRequest request = new TermVectorsRequest(indexName, document, field);
        request.setFields(field);
    }

    @Override
    public void updateRequestIndexDocuments(String indexName, String document) {
        UpdateRequest updateRequest = new UpdateRequest(indexName,document);
    }

    /**
     * 异步方式
     */
    public void indexDocumentsAsync(String indexName, String document) {
        IndexRequest indexRequest = new IndexRequest(indexName).id(document).source(
                "user", "niudong", "postDate", new Date(), "message", "Hello Es"
        );
        ActionListener listener = new ActionListener<IndexResponse>() {
            @Override
            public void onResponse(IndexResponse indexResponse) {
            }

            @Override
            public void onFailure(Exception e) {
            }
        };
        restHighLevelClient.indexAsync(indexRequest, RequestOptions.DEFAULT, listener);
    }

    /**
     * 解析结果
     */
    private void processIndexResponse(IndexResponse indexResponse) {
        String index = indexResponse.getIndex();
        String id = indexResponse.getId();
        log.info("index is" + index + ",id is" + id);
        if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
            //文档创建时
            log.info("Document is created");
        } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
            log.info("Document is update");
        }
        ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
        if (shardInfo.getTotal() != shardInfo.getSuccessful()) {
            //处理成功 shards 小于总 shards 的情况
            log.info("Success shards are not enough!");
        }
        if (shardInfo.getFailed() > 0) {

            for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {
                String reason = failure.reason();
                log.info("Fail reason is" + reason);
            }
        }
    }

    /**
     * 处理getResponse
     */
    private void processGetResponsee(GetResponse getResponse){
        String index = getResponse.getIndex();
        String id = getResponse.getId();
        log.info("id is "+id+",index is" + index);

        if(getResponse.isExists()){
            long version = getResponse.getVersion();
            //以字符串形式检索
            String sourceAsString = getResponse.getSourceAsString();
            //以Map形式检索
            Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
            //以bytr形式检索
            byte[] sourceAsBytes = getResponse.getSourceAsBytes();

            log.info("version"+version+",SourceAsString is" + sourceAsString);
        }else {
        }
    }

    private void processDeleteRequest(DeleteResponse deleteResponse){
        String id = deleteResponse.getId();
        String index = deleteResponse.getIndex();
        long version = deleteResponse.getVersion();
        log.info("delete id is"+id+",index"+ index+",version"+version);
        ReplicationResponse.ShardInfo shardInfo = deleteResponse.getShardInfo();
        if(shardInfo.getTotal()!=shardInfo.getSuccessful()){
            log.info("Success shard are not enough");
        }

        if(shardInfo.getFailed()>0){
            for (ReplicationResponse.ShardInfo.Failure failure : shardInfo.getFailures()) {
                String reason = failure.reason();
                log.info("Fail reason is" + reason);
            }
        }
    }


}
