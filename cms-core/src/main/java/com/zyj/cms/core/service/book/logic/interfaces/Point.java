package com.zyj.cms.core.service.book.logic.interfaces;

/**
 * @author zhouyajun
 * @date 2019/4/15
 */
public class Point implements MyComparable {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(x * x + y * y);
    }

    public int comparable(Object other) {
        // 这种显式的类型检查和强制转换是可以使用泛型机制避免的
        if (!(other instanceof Point)) {
            throw new IllegalArgumentException();
        }
        Point otherPoint = (Point) other;
        double delta = this.distance() - otherPoint.distance();
        if (delta < 0) {
            return -1;
        } else if (delta > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
