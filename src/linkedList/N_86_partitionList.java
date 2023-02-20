package linkedList;

import base.ListNode;

/**
 * 分割链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 */
public class N_86_partitionList {

    private ListNode partition(ListNode head, int x) {
        //存放虚拟头节点
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        //生成结果链表
        ListNode p1 = dummy1, p2 = dummy2;
        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            //切断原链表，防止分割后的链表尾节点仍有链接
            ListNode tmp = p.next;
            p.next = null;
            p = tmp;
        }

        //链接两链表
        p1.next = dummy2.next;

        return dummy1.next;
    }


}
