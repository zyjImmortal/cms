package com.zyj.cms.core.service.geek.codedesign.metrics.TestStream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author : zhouyajun
 * @date : 2020/9/10
 */
public class TestStream {

    @Test
    public void test_stream_array() {
        int[] arr = new int[]{1, 2, 34, 5};
        IntStream intStream = Arrays.stream(arr);

        Stream<Integer> stream1 = Stream.of(1, 2, 34, 5, 67);
        Stream<int[]> stream2 = Stream.of(arr);
        stream1.forEach(System.out::println);
    }

    @Test
    public void test_stream_collect() {
        List<String> strs = Arrays.asList("11212", "dfd", "2323", "dfhgf");
        Stream<String> stream = strs.stream();

        stream.filter(x -> x.startsWith("d")).forEach(System.out::println);

    }

    @Test
    public void test_stream_match() {
        List<Integer> list = Arrays.asList(10, 7, 6, 9, 3, 8, 2, 1);
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).sorted().findFirst();

        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();

//        System.out.println(findFirst);
        System.out.println(findAny);
    }

    @Test
    public void test_stream_comparator() {
        List<String> list = Arrays.asList("adnm", "admmt", "pot");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println(max);

        List<Integer> list2 = Arrays.asList(7, 6, 9);
//        Optional<Integer> maxInteger = list2.stream().max(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        Optional<Integer> maxInteger = list2.stream().max((o1, o2) -> o2.compareTo(o1));

        Optional<Integer> maxInteger = list2.stream().max(Comparator.reverseOrder());
        System.out.println(maxInteger);
    }

    @Test
    public void test_stream_map() {
        String[] strArr = {"abcd", "bcdd", "defde", "ftr"};
//        Arrays.stream(strArr).map(x -> x.toUpperCase()).forEach(System.out::println);
        Arrays.stream(strArr).map(String::toUpperCase).forEach(System.out::println);
    }
}
