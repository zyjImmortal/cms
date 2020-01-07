package com.zyj.cms.core.service.geek.aldatastruc.al.dynamic;

public class Dynamic {
    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

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

    public int getMaxW() {
        return maxW;
    }

    public static void main(String[] args) {
        Dynamic dynamic = new Dynamic();
        dynamic.f(0, 0);
        System.out.println(dynamic.getMaxW());
    }
}
