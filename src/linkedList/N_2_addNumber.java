package linkedList;

import base.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 */
public class N_2_addNumber {

    //链表对应节点两数相加，需要考虑的是进位
    private static ListNode solution(ListNode head1, ListNode head2) {
        ListNode head, tail;
        head = tail = null;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int num1 = head1!=null ? head1.val : 0;
            int num2 = head2!=null ? head2.val : 0;
            int sum = num1 + num2 + carry;
            int val = sum % 10;
            carry = sum / 10;
            if (head == null) {
                head = new ListNode(val);
                tail = head;
            }else{
                tail.next = new ListNode(val);
                tail = tail.next;
            }

            if (head1 != null) {
                head1 = head1.next;
            }
            if(head2 != null)
                head2 = head2.next;


        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }

    public static void main(String[] args) {

    }
}
