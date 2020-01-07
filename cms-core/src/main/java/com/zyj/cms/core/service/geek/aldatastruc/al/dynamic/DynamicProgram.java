package com.zyj.cms.core.service.geek.aldatastruc.al.dynamic;

/**
 * Author: zhouyajun
 * Date: 2019-11-21
 */
public class DynamicProgram {
    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量
    // 用二维数据来表示所有可能的状态，这里的状态指的是，决策到第i个品时当前背包重量是否计算过
    // 纵向代表第几个物品，横向代表当前背包重量，背包重量范围为0-w，即不装(0)和装满(9)
    private boolean[][] mem = new boolean[n][w + 1];

    /**
     * 用递归的方式穷举所有可能，找出所有组合中在满足条件的情况下，最大的哪一个
     *
     * @param i  表示将要决策i个物品是否放入背包
     * @param cw 当前背包重量，决策前的重量
     *           每个阶段会决策一个物品是否放到背包中。每个物品决策（放入或者不放入背包）完之后，背包中的物品的重量会有多种情况
     *           整体决策过程类似于一颗递归树
     *           f(0,0)
     *           /       \
     *           f(1,0)        f(1,2)
     *           /    \         /    \
     *           f(2,0)  f(2,2)  f(2,2)   f(2,4)
     */
    public void f(int i, int cw) {
        if (cw == w || i == n) { // 递归的终止条件,cw == w 表示装满了，i == n考察完了
            if (cw > maxW) {
                maxW = cw;
            }
        }

        f(i + 1, cw); // 决策第i个物品不放入背包，背包当前重量不变
        // 如果当前背包重量加上即将要放入物品重量(第i个物品重量)小于等于背包可承受总重量，才能放入背包
        if (cw + weight[i] <= w) {
            f(i + 1, weight[i] + cw);
        }
    }

    /**
     * 从上面的递归树中可以看出，在递归的过程中会有很多重复计算的状态，
     * 如果我们使用备忘录将一些计算状态保存，每次要进行决策之前，从备忘录中查找一下
     * 是否有计算好的，如果有直接返回
     * 备忘录解释：
     *
     * @param i
     * @param cw
     */
    public void fv2(int i, int cw) {
        if (cw == w || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
        }
        if (mem[n][cw]) {
            return;
        }
        mem[n][cw] = true;
        f(i + 1, cw);
        if (cw + weight[i] <= w) {
            f(i + 1, weight[i] + cw);
        }
    }

    /**
     * 动态规划解决背包问题
     * 从上面的递归树种看出，整个求解过程分为n(物品总数)个阶段,每个阶段都会决策一个物品是否放到背包里，
     * 在决策完之后，背包的重量都会有多种状态，也就是对应到树种的不同节点，那么我们把每一层重复的状态合并，
     * 只保留不重复的状态，就可以保证每一层的不同状态个数不会超过w个(背包的承载总重量)，就可以成功避免计算状态的指数级增长，
     * 因为所有计算状态的背包重量都会小于w，我们再合并掉重复的，所有状态都是唯一，所以一定会小于w，
     * 还有，在决策时都是基于前一层的计算状态
     *
     * @param weight 物品重量数组
     * @param n      物品个数
     * @param w      背包可承受对打重量
     */
    public int knapsack(int[] weight, int n, int w) {
        // 用一个二维数组来保存计算状态
        boolean[][] states = new boolean[n][w + 1]; // 默认值false
        // 第一层状态是开始，要进行手动赋值
        states[0][0] = true;
        if (weight[0] < w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            // 根据上一层的所有状态，在不放入物品的情况下，标记当前层的所有计算状态
            // 其实就是把上一层的状态复制到当前层
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }
            // w - weight[i] 背包剩余可容纳重量
            // 根据上一层的所有状态，在放入物品的情况下，标记当前层的所有计算状态
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        // 在最后一层，找一个值为true的最接近w的值，就是背包中物品总重量的最大值。
        // 从w开始，从后往前遍历，遇到的第一个true就为最大值
        for (int i = w; i >= 0; i--) {
            if (states[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 上面的算法中，使用的是二维数组来记录状态，但是在实际使用这个二维数组的时候，发现，我们其实只需要
     * 前一层的计算状态，来计算当前层状态，最后得出结论也是看最后一层计算状态，那么我们完全可以用一个一维数组保存前一层计算状态就可以。
     * 每次决策只要更新这个数组，把新的计算状态加进去。
     * 数组中的值为状态，索引为当前背包重量
     *
     * @param weight 物品重量数组
     * @param n      物品个数
     * @param w      背包可承受对打重量
     * @return
     */
    public int knapsack2(int[] weight, int n, int w) {
        boolean[] states = new boolean[w + 1];
        // 初始化第一个物品决策后的状态
        states[0] = true;
        if (weight[0] <= w) {
            states[weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < w - weight[i]; j++) {
//                if (states[j]) {
//                    states[j + weight[i]] = true;
//                }
//            }
            for (int j = w - weight[i]; j >= 0; --j) {
                if (states[j]) {
                    states[j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) {
            if (states[i]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 回溯法求解最短路径
     *
     * @param i    行
     * @param j    列
     * @param dist 当前点到起点的距离
     * @param w    二维数组
     * @param n    行、列数
     */
    private int minDist = Integer.MAX_VALUE;

    public void minDistBT(int i, int j, int dist, int[][] w, int n) {
        if (i == n || j == n) {
            if (dist < minDist) {
                minDist = dist;
            }
        }

        if (i < n) {
            minDistBT(i + 1, j, dist + w[i][j], w, n);
        }

        if (j < n) {
            minDistBT(i, j + 1, dist + w[i][j], w, n);
        }
    }

    /**
     * 状态迁移表法
     * @param matrix
     * @param n
     * @return
     */
    public int minDistDP(int[][] matrix, int n) {
        int[][] states = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[0][i];
            states[0][i] = sum;
        }
        sum = 0;
        for (int i = 1; i < n; i++) {
            sum += matrix[0][i];
            states[i][0] = sum;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                states[i][j] = matrix[i][j] + Math.min(states[i - 1][j], states[i][j - 1]);
            }
        }

        return states[n - 1][n - 1];
    }

    public static void main(String[] args) {
        int[] weight = {2, 2, 4, 6, 3};
        DynamicProgram dynamicProgram = new DynamicProgram();
        System.out.println(dynamicProgram.knapsack(weight, 5, 9));
    }
}
