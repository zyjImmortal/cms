package com.zyj.cms.core.service.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : zhouyajun
 * @date : 2020/9/9
 */
public class Persion {
    private String name;
    private int salary;

    // 构造方法
    public Persion(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        List<Persion> persions = new ArrayList<>();
        persions.add(new Persion("Tom", 8900));
        persions.add(new Persion("Jack", 7000));
        persions.add(new Persion("Lily", 9000));


        List<Integer> intList = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        List<Integer> collect = intList.stream().filter(x -> x > 7).collect(Collectors.toList());
        System.out.println(collect);

        persions.stream().filter(x -> x.getSalary() > 8000).collect(Collectors.toList());

        System.out.println(persions.toString());
    }
}
