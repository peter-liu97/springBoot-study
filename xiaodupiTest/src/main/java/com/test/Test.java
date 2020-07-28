package com.test;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        Bargain bargain = new Bargain();
        double oldUser = bargain.randomReducePrice(91, 0, 0, "oldUser");
        System.out.println("当次砍价 ： " + oldUser);
        System.out.println();

        int sum = 0;
        List<User> list = bargain.getAllUser();
        for (User user : list) {
            System.out.println(user.getUserType() + "    " + user.getBargain());
            sum += user.getBargain() * 100;
        }


        System.out.println("已砍总价格 : " + sum / 100.00 + " 砍刀人数： " + list.size());
    }

}