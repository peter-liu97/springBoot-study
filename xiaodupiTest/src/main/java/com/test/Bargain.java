package com.test;

import java.util.ArrayList;
import java.util.List;

public class Bargain {
    private static final double totalPrice = 100;

    public Bargain() {

    }


    /**
     * @param price          总价格
     * @param bargainedPrice 已砍价格
     * @param bargainedNum   已砍价人数
     * @param userType       用户类型
     * @return 本次砍价金额
     */
    public double randomReducePrice(double price, double bargainedPrice, int bargainedNum, String userType) {

        List<Integer> allSituation = new ArrayList<>();
        if (bargainedPrice >= price) {
            return 0;
        }

        //如果当前已砍价人数小于10并且已砍价格小于总价格的二分之一为前10名剩余用户分配砍价情况
        if (bargainedNum < 10 && bargainedPrice < price / 2) {
            search(price / 2 - bargainedPrice, 10 - bargainedNum, allSituation);
            search(price - (price / 2 - bargainedPrice), 90, allSituation);
        }

        //如果当前砍价人数大于10重新分配剩余用户的砍价情况
        if (bargainedNum >= 10) {
            search(price - bargainedPrice, 100 - bargainedNum, allSituation);
        }

        if (userType.equals("oldUser")) {
            return allSituation.size() != 0 ? allSituation.get(0) / 100.00 : 0;
        } else {
            int result = 0;
            int allSituationSize = allSituation.size();
            if (allSituationSize >= 10) {
                for (int i = 0; i < 10; i++) {
                    result += allSituation.get(i);
                }
            } else {
                for (int i = 0; i < allSituationSize; i++) {
                    result += allSituation.get(i);
                }
            }
            return result / 100.00;
        }
    }

    /**
     * @return 商品从100元 砍到 0元 所有数据
     */
    public List<User> getAllUser() {
        List<Integer> allSituation = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        search(totalPrice / 2, 10, allSituation);
        search(totalPrice - totalPrice / 2, 90, allSituation);
        int i = 0;
        while (true) {
            int allSituationSize = allSituation.size();
            String userType = Math.random() * 10 < 1 ? "newUser" : "oldUser";
            if (i >= allSituationSize) {
                break;
            }
            if (userType.equals("oldUser")) {
                userList.add(new User(i, userType, allSituation.get(i) / 100.00));
                i++;
            } else {
                int result = 0;
                for (int j = 0; j < 10 && i < allSituationSize; j++) {
                    result += allSituation.get(i);
                    i++;
                }
                userList.add(new User(i, userType, result == 0 ? 0 : result / 100.00));
            }
        }
        return userList;
    }


    /**
     * 随机分配情况
     *
     * @param money      要拆分的总金额
     * @param shard      拆分个数
     * @param randomList 拆分之后存储的数组
     */
    private static void search(double money, int shard, List<Integer> randomList) {
        int price = (int) money * 100;

        if (shard == 1) {
            randomList.add(price);
        }
        double avg = money / shard * 100;
        int tail = 0;
        while (true) {
            int rint = (int) Math.rint(Math.random() * (avg * 0.2) + avg * 0.9);
            rint = rint < 1 ? 1 : rint;
            tail += rint;
            if (tail >= price) {
                randomList.add(price - (tail - rint));
                break;
            }
            randomList.add(rint);
        }
    }
}
