package com.zyj.cms.core.service.geek.aldatastruc.ds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zhouyajun
 * @date: 2020-01-06
 */
public class Compare {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(14);
        integers.add(7);
        integers.add(8);
        integers.add(12);
        integers.add(3);
//        Collections.sort(integers, new Comparator<Integer>(){
//            @Override
//            public int compare(Integer str1, Integer str2){
//
//                return str2.compareTo(str1);
//            }
//        });
//
//        System.out.println(integers);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < integers.size(); i++) {
            priorityQueue.add(integers.get(i));
        }
        System.out.println(priorityQueue);

    }
}
