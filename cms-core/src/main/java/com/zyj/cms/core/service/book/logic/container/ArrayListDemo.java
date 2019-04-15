package com.zyj.cms.core.service.book.logic.container;

import java.util.ArrayList;

/**
 * @author zhouyajun
 * @date 2019/4/15
 */
public class ArrayListDemo {

    /**
     * 对于ArrayList，它的特点是：内部采用动态数组实现，这决定了：
     *
     * 可以随机访问，按照索引位置进行访问效率很高，用算法描述中的术语，效率是O(1)，简单说就是可以一步到位。
     * 除非数组已排序，否则按照内容查找元素效率比较低，具体是O(N)，N为数组内容长度，也就是说，性能与数组长度成正比。
     * 添加元素的效率还可以，重新分配和拷贝数组的开销被平摊了，具体来说，添加N个元素的效率为O(N)。
     * 插入和删除元素的效率比较低，因为需要移动元素，具体为O(N)。
     */
    private ArrayList<String> arrayList = new ArrayList<String>();

    public static void main(String[] args) {

    }
}
