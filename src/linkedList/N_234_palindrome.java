package linkedList;

import base.LinkedListUtil;
import base.ListNode;
import jdk.nashorn.internal.runtime.regexp.joni.constants.Traverse;

import java.rmi.server.RemoteServer;

/**
 * 判断回文单链表
 *
 * 问题关键在于，单链表无法倒着遍历，无法使用双指针
 */
public class N_234_palindrome {


    /*
    递归 ： 借助二叉树后序遍历思路，不需要显式翻转链表也能实现倒序遍历链表
     */
    static ListNode left;
    private static boolean isPalindrome(ListNode head){
        left = head;
        return traverse(head);
    }

    private static boolean traverse(ListNode right){
        if(right==null)
            return true;
        boolean res = traverse(right.next);
        res = res && (left.val==right.val); //后序遍历
        left = left.next;
        return res;
    }


    /*
    递归解法利用了函数的堆栈，空间复杂度为O（N），如何不使用额外空间解决这个问题？
    1.快慢指针技巧找到链表中点
    2.如果长度为奇数，慢指针+1
    3.翻转中点后的链表后，比较回文串
     */
    private static boolean isPalindrome_2(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //链表长度为奇数，slow需再前进一步
        if (fast != null) {
            slow = slow.next;
        }

        //翻转中点后链表
        ListNode left = head;
        ListNode right = reserve(slow);
        //回文匹配
        while (right != null) {
            if(left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    //翻转指定节点后的链表
    private static ListNode reserve (ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }



    public static void main(String[] args) {
        ListNode head = LinkedListUtil.build_rear(new int[]{1, 2, 3, 3, 2, 1});
        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome_2(head));
    }

}
