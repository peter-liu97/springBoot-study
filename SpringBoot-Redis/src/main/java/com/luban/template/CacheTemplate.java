package com.luban.template;

import com.luban.filter.RedisBloomFilter;
import com.luban.mapper.OrderMapper;
import com.luban.pojo.NullValueResultDO;
import com.luban.pojo.R;
import org.redisson.Redisson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CacheTemplate<T> {

    @Autowired
    private ValueOperations<String,Object> valueOperations;

    @Autowired
    RedisBloomFilter bloomFilter;


    @Autowired
    private Redisson redisson;

    @Autowired
    OrderMapper orderMapper;




    public R findCache(String key, long expire, TimeUnit unit, CacheLoadble<T> cacheLoadble){
        //查询缓存
        Object redisObj = valueOperations.get(String.valueOf(key));
        if(redisObj!=null){
            R r =new R();
            r.setCode(200);
            r.setData(redisObj);
            r.setMsg("OK");
            return r;
        }
        synchronized (this){
            redisObj = valueOperations.get(String.valueOf(key));
            if(redisObj!=null){
                R r =new R();
                r.setCode(200);
                r.setData(redisObj);
                r.setMsg("OK");
              return r;
            }
            T load = cacheLoadble.load();
            valueOperations.set(String.valueOf(key), load,expire, unit);  //加入缓存
            R r =new R();
            r.setCode(200);
            r.setData(load);
            r.setMsg("OK");
            return r;
        }
    }

    public R redisFindCache(String key, long expire, TimeUnit unit, CacheLoadble<T> cacheLoadble,boolean b){
        if (!bloomFilter.isExist(key)){
            R r =new R();
            r.setCode(200);
            r.setData(null);
            r.setMsg("OK");
            return r;
        }
        //查询缓存
        Object redisObj = valueOperations.get(String.valueOf(key));
        //命中缓存
        if(redisObj != null) {
            //正常返回数据
            R r =new R();
            r.setCode(200);
            r.setData(redisObj);
            r.setMsg("OK");
            return r;
        }
        T load = cacheLoadble.load();//查询数据库
        if (load != null) {
            valueOperations.set(key, load,expire, unit);  //加入缓存
            R r =new R();
            r.setCode(200);
            r.setData(load);
            r.setMsg("OK");
            return r;
        }
        R r =new R();
        r.setCode(500);
        r.setData(null);
        r.setMsg("查询无果");
        return r;
    }
}
