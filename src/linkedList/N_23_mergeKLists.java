package linkedList;

import base.ListNode;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 1.正常遍历方法，关键是如何从K个链表中拿到最小节点（利用优先级队列）
 *
 * 2.分治思想，合并子数组，最后转化为合并两个链表
 */
public class N_23_mergeKLists {

    //分治思路
    /*
    private ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode l = mergeKLists(lists, 0, mid);
        ListNode r = mergeKLists(lists, mid + 1, end);
        return mergeTwoList(l, r);
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }
    */

    //借助优先级队列找到k个链表中最小值节点
    private ListNode mergeKLists(ListNode[] listNodes) {

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        //优先级队列,最小堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1,o2) -> {
            return o1.val - o2.val;
        });
        for (ListNode node : listNodes) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return dummy.next;
    }



}
