package com.zyj.cms.core.service.book.logic.fanxing;


/**
 * T 是类型参数，这里可以传入多个<T, U>
 * @param <T>
 */
public class Pair<T> {

    private T first;
    private T second;

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return this.first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<Integer>(2,3);
        Pair<String> pair1 = new Pair<String>("first", "second");
    }
}
