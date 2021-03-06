package com.zyj.cms.core.service.geek.leetcode;

import com.zyj.cms.core.service.geek.aldatastruc.ds.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhouyajun
 * @date 2019/4/18
 */
public class ListNodeSolution {


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

    /**
     * 两个单链表的相交起始节点
     *
     * @param headA
     * @param headB
     * @return 思路"暴力法，对headA中的每个节点都遍历一遍B，看节点是否相等，注意是节点相等不是节点的value相等
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tem = headB;
        while (headA != null) {
            tem = headB;
            while (tem != null) {
                if (headA == tem) {
                    return tem;
                }
                tem = tem.next;
            }
            headA = headA.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNodeV3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ArrayList<ListNode> listNodes = new ArrayList<ListNode>();
        while (headA != null) {
            listNodes.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (listNodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head; // 形成一个环
        ListNode new_tail = head;
        // k有两种情况，当k小于n的时候，new_tail 就是n-k的位置,当k>=n的时候，new_tail就是n-k%n的位置,因为k>n的时候
        // 相当于链表全部由后至前全部旋转一遍，和初始一样的状态，这个时候需要继续旋转剩余的k-n次，
        // 两种情况合并到一起就是 n - k%n，如果k小于n，k%n等于k，大于的时候,就是k多出n的部分
        for (int i = 1; i < n - k % n; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;
        new_tail.next = null;
        return new_head;
    }

    public ListNode rotateRightV2(ListNode head, int k) {
        ListNode pre = head;
        int temp = k;
        while (temp > 0) {
            pre = pre.next;
            temp--;
        }
        return null;
    }

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度
     *
     * 实现思路： 将列表中的所有节点组成一个小顶堆，每次取出堆顶节点，也就是最小的节点，
     * 然后构造一个新的链表，将取出的节点追加到链表的末尾
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if (length == 0 || lists == null) {
            return null;
        }
        ListNode temp = new ListNode(0);
        ListNode currentNode = temp;
        // PriorityQueue优先队列需要传入自定义的比较器
        PriorityQueue<ListNode> queue = new PriorityQueue<>(length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 将不为空的节点传入队列中，队列会根据比较器自动构造一个基于数组存储的小顶堆
        for (ListNode node : lists) {
            if (node == null){
                continue;
            }
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            // 获取堆顶元素，也就是最小的元素，插入到temp中，
            ListNode node = queue.poll();
            currentNode.next = node;
            currentNode = currentNode.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return temp.next;

    }

    public static void main(String[] args) {
//        ListNode node = new ListNode(5);
//        node.next = new ListNode(4);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(2);
//        node.next.next.next.next = new ListNode(1);
//        ListNodeSolution solution = new ListNodeSolution();
//        System.out.println(solution.rotateRight(node,2));
        System.out.println(3 % 5);
        System.out.println(-1 % 4);
    }

}
