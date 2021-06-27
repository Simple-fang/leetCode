package linkedList;


import base.LinkedListUtil;
import base.ListNode;

/**
 * 反转链表从m到n位置，返回反转后的链表
 */
public class N_92_reserveListBetween {


    /**
     * 递归思路
     * 首先简化问题：考虑反转链表前N为（也既是m=1）
     * 反转m到n位置，可递归转化为反转head.next的m-1到n-1位置，head.next.next的m-2到n-2的位置
     */


    /*
    递归反转链表前N位，也即是反转head.next的n-1位
    在206_反转链表基础上，head.next不再是null，需记录N+1位置节点，与head连接
     */
    static ListNode joinNode = null;
    public static ListNode reserve_N(ListNode head, int n) {
        if(head.next==null || n==1){
            joinNode = head.next;
            return head;
        }
        ListNode last = reserve_N(head.next, n - 1);
        head.next.next = head;
        head.next = joinNode;
        return last;
    }


    public static ListNode reserveBetween(ListNode head, int m, int n){
        //base case
        if(m==1){
            return reserve_N(head, n);
        }
        head.next = reserveBetween(head.next, m - 1, n - 1);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtil.build_rear(new int[]{1, 2, 3, 4});
        LinkedListUtil.traverse(reserveBetween(head, 2, 3));
    }
}
