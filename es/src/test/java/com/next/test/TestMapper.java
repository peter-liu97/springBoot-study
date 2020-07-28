package com.next.test;

import com.next.bean.Goods;
import com.next.mapper.GoodsMapper;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
public class TestMapper {
    @Autowired
    GoodsMapper goodsMapper;

    @Test
    void insertGoods(){

        List<Goods> list=new ArrayList<>();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = simpleDateFormat.format(new Date());

        for (int i = 1; i <2334 ; i++) {
            Goods good=new Goods(i,"","OPPO R17新年版 2500万美颜拍照 6.4英寸水滴屏 光感屏幕指纹 6G+128G 全网通 移动联通电信4G 双卡双待手机",
                    37400,10000,100,"https://m.360buyimg.com/mobilecms/s720x720_jfs/t1/10441/9/5525/162976/5c177debEaf815b43/3aa7d4dc182cc4d9.jpg!q70.jpg.webp",
                    "https://m.360buyimg.com/mobilecms/s720x720_jfs/t1/10441/9/5525/162976/5c177debEaf815b43/3aa7d4dc182cc4d9.jpg!q70.jpg.webp",
                    10,str,str,"10000243333000",558,"手机","OPPO","{'颜色': '王者荣耀定制版', '版本': 'R17'}",1,1,1);

            list.add(good);
        }

        goodsMapper.saveAll(list);
//        System.out.println(goodsMapper.save(goods));
    }

    @Test
    void search(){
        Optional<Goods> goods = goodsMapper.findById("1001332689");
        System.out.println(goods.get());
    }

    @Test
    void pageSearch(){
        Pageable pageable = PageRequest.of(0,100, Sort.by(Sort.Direction.ASC,"num"));
        Page<Goods> all = goodsMapper.findAll(pageable);
        Iterator<Goods> iterator = all.iterator();
        int count = 0;
        while (iterator.hasNext()){
            Goods next = iterator.next();
            System.out.println(next);
            count++;
        }
        System.out.println(count);
    }

    @Test
    void termGoods(){
        TermsQueryBuilder termsQueryBuilder = new TermsQueryBuilder("category_name","手机");
        Iterable<Goods> search = goodsMapper.search(termsQueryBuilder);
        Iterator<Goods> iterator = search.iterator();
        int count = 0;
        while (iterator.hasNext()){
            Goods next = iterator.next();
            System.out.println(next);
            count++;
        }
        System.out.println(count);
    }

    /**
     * 范围查询
     */
    @Test
    void rangelGoods(){
        RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder("num");
        rangeQueryBuilder.gt(20);
        rangeQueryBuilder.lt(20000);
        Iterable<Goods> search = goodsMapper.search(rangeQueryBuilder);
        Iterator<Goods> iterator = search.iterator();
        int count = 0;
        while (iterator.hasNext()){
            Goods next = iterator.next();
            System.out.println(next);
            count++;
        }
        System.out.println(count);

    }
}
