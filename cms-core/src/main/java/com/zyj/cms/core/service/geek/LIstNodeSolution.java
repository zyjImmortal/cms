package com.zyj.cms.core.service.geek;

import com.zyj.cms.core.service.geek.ds.ListNode;

/**
 * @author zhouyajun
 * @date 2019/4/18
 */
public class LIstNodeSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode q = l1, p = l2, reslut = new ListNode(0);
        ListNode cur = reslut;
        int carrycarry = 0;
        while (q != null || p != null) {
            int x = q != null ? q.val : 0;
            int y = p != null ? p.val : 0;
            int sum = x + y + carrycarry;
            cur.next = new ListNode(sum / 10);
            carrycarry = sum % 10;
            cur = cur.next;
            if (q != null) {
                q = q.next;
            }
            if (p != null) {
                p = p.next;
            }
        }
        if (carrycarry != 0) {
            cur.next = new ListNode(carrycarry);
        }
        return reslut.next;
    }

}
