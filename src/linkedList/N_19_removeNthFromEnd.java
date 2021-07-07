package linkedList;

import base.LinkedListUtil;
import base.ListNode;

/**
 * 删除链表中倒数第n个节点（n有效，不会超过链表长度）
 */
public class N_19_removeNthFromEnd {

    /*
    fast先走n步，则快指针为null时，slow为倒数第n个节点
     */
    public static ListNode removeNth(ListNode head, int n) {
        ListNode fast, slow;
        fast = slow = head;
        while (n-- > 0) {
            fast = fast.next;
        }

        //头节点为倒数n节点
        if (fast == null) {
            return head.next;
        }
        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }


    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;

        LinkedListUtil.traverse(node_1);
        ListNode newHead = removeNth(node_1, 2);
        System.out.println();
        LinkedListUtil.traverse(newHead);
    }
}
