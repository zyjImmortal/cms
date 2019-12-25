package com.zyj.cms.core.service.geek.AlAndDataStruc.al.sort;

import java.util.Arrays;

/**
 * @author zhouyajun
 * @date 2019/5/16
 */
public class BuddleSort {

    public static void sort(int array[]){
        int temp = 0;
        for (int i = 0; i <  array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void sortV2(int array[]){
        int temp = 0;
        for (int i = 0; i <  array.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {4,2,8,9,2,4};
        BuddleSort.sortV2(array);
    }
}
