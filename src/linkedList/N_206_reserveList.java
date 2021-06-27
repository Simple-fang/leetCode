package linkedList;


import base.LinkedListUtil;
import base.ListNode;

public class N_206_reserveList {


    //递归翻转链表
    public static ListNode reserve_1(ListNode head) {
        //base
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reserve_1(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     *迭代翻转链表
     * 更改当前节点next为前一节点，由于无法通过当前节点获得前一节点，需保存前一节点
     * 为保证正常遍历，更改指针指向前还需保存下一节点，以便继续遍历
     */
    public static ListNode reserve_2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.build_rear(new int[]{1, 2, 3, 4});
        LinkedListUtil.traverse(head);
        System.out.println();
        head = reserve_1(head);
        LinkedListUtil.traverse(head);
        System.out.println();
        head = reserve_2(head);
        LinkedListUtil.traverse(head);
    }
}
