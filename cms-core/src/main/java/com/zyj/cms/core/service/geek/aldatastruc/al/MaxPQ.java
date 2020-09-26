package com.zyj.cms.core.service.geek.aldatastruc.al;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;

    private int N = 0;

    public MaxPQ(int cap){
        pq = (Key[]) new Comparable[cap+1];
    }

    public Key max(){
        return pq[1];
    }

    public void insert(Key key){
        N++;
        pq[N] = key;
        swim(N);
    }

    public Key deleteMax(){
        Key max = pq[1];
        exch(1, N);
        pq[N] = null;
        sink(1);
        return max;
    }

    /**
     * 上浮第k个元素以维护最大堆的性质
     * @param k
     */
    private void swim(int k){
        // 当k大于1的时候并且当前节点比父节点大才进行上浮操作
        while (k > 1 && less(parent(k), k)){
            exch(parent(k), k); // 交换当前节点和父节点
            k = parent(k); // k指向父节点
        }
    }

    /**
     * 下沉第k个元素，以维护最大堆的性质
     * @param k
     */
    private void sink(int k){
        // 因为是完全二叉树，所以先要考虑左子节点，
        // 如果一个节点的左子节点的索引等于了数组的大小，那么就意味着已经是最后一个节点了
        while (left(k) <= N){
            int older = left(k);
            if (right(k) <= N && less(older, right(k))){
                older = right(k);
            }
            exch(k, older);
            k = older;
        }
    }

    private void exch(int i, int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * 判断pq[i]是不是比pq[j]小
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i , int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private int parent(int i){
        return i / 2;
    }

    private int right(int i){
        return 2 * i + 1;
    }

    private int left(int i){
        return i * 2;
    }



    public static void main(String[] args) {
        System.out.println(5 / 2);
    }
}
