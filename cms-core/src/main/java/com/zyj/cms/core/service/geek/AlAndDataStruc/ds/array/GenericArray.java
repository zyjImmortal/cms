package com.zyj.cms.core.service.geek.AlAndDataStruc.ds.array;

/**
 * @author : zhouyajun
 * @date : 2019-12-24
 */
public class GenericArray<T> {
    private T[] data;
    private int size;

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int getCount() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Required index >=0 and index < size");
        }
    }

    private void checkIndexForRemove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed! Required index >=0 and index < size");
        }
    }

    public void add(int index, T e) {
        checkIndexForAdd(index);
        // 如果元素个数等于数组容量，则将数组扩容为原来的2倍
        if (size == data.length) {
            resize(2 * data.length);
        }
        // 将index后面的元素全部往后移动一位
        for (int i = size - 1; i >= index; i--) {
            data[size + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(T e) {
        add(0, e);
    }

    public void addLast(T e) {
        add(size, e);
    }

    public T remove(int index) {
        checkIndexForRemove(index);
        T ret = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public int remove(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
        return index;
    }

    public boolean contain(T e) {
        int index = find(e);
        if (index != -1) {
            return true;
        }
        return false;
    }

    public T get(int index) {
        checkIndexForAdd(index);
        return data[index];
    }

    public void set(int index, T e) {
        checkIndexForAdd(index);
        data[index] = e;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size -1){
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        GenericArray<String> arrays = new GenericArray<String>(5);
        arrays.addLast("a");
        arrays.addLast("a");
        arrays.addLast("a");
        arrays.addLast("a");
        arrays.addLast("a");
        arrays.addLast("a");
        System.out.println(arrays);
    }

}
