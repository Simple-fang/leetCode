package linkedList;

import base.LinkedListUtil;
import base.ListNode;

import java.util.Arrays;

/**
 * K个一组翻转链表，最后不足k个不再翻转
 */
public class N_25_reserveKGroup {


    public static ListNode reserveBetween(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;

        while (cur != b) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static ListNode reserveGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            //base
            if (b == null) {
                return head;
            }
            b = b.next;
        }

        ListNode newHead = reserveBetween(a, b);
        //a是执行局部翻转后新的尾结点
        a.next = reserveGroup(b, k);
        return newHead;

    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.build_rear(new int[]{1,2,3,4,5,6});
        LinkedListUtil.traverse(reserveGroup(head, 2));
    }
}
