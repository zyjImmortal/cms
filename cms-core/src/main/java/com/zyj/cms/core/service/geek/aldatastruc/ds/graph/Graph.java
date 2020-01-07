package com.zyj.cms.core.service.geek.aldatastruc.ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : zhouyajun
 * @date : 2020-01-07
 */
public class Graph {
    private int v;
    private LinkedList[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            // 初始化存储每个顶点相连顶点的链表
            adj[i] = new LinkedList<>();
        }
    }

    public void addRdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索算法
     *
     * 思路：
     * 用邻接表的方式存储一个无向图，每个顶点的值，都是一个链表，存储的是和自己有关系的顶点
     * 对于一个图数据结构来说，广度优先搜索就是一层层搜索下去，
     * 这个每一层的顶点都是和上一层相连接的顶点，所以要记录上一层的顶点
     * 在搜索过程中需要记录已经和目标顶点比较过的顶点，防止重复搜索
     * 要记录搜索的路径
     * ，
     * @param s 起始顶点
     * @param t 终止顶点
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        // 用来已经被访问的顶点，避免顶点被重复访问
        boolean[] visited = new boolean[v];
        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        // prev存储的是搜索的路径
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }

        while (queue.size() != 0) {
            // 移除队首元素，如果不存在返回null，
            // 此处是获取上层的顶点，根据这个顶点获取当前层的顶点
            int w = queue.poll();
            // 内层的for循环访问的是，和某个顶点有链接关系的顶点
            for (int i = 0; i < adj[w].size(); i++) {
                int q = (int) adj[w].get(i);
                // 当前层出现的顶点可能会对应到同一个上层顶点，在访问路径中只记录一个上层顶点，这样最后记录的路径就是最短路径
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }

            }
        }

    }

    boolean found = false;
    public void dfs(int s, int t){
        if (s == t) {
            return;
        }
        found = false;
        boolean[] visited = new boolean[v];
        visited[s] = true;
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    public void recurDfs(int w, int t, boolean[] visited, int[] prev){
        if (found){
            return;
        }
        visited[w] = true;
        if (w == t){
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int q = (int) adj[w].get(i);
            if (!visited[q]){
                prev[q] = w;
                // 以和w连接的第一个顶点作为，新的起始顶点继续查找
                recurDfs(q, t, visited, prev);
            }
        }
    }


    private void print(int[] prev, int s, int t) {
        // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addRdge(2, 3);
        System.out.println(Arrays.deepToString(graph.adj));
    }
}
