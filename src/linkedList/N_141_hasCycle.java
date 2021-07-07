package linkedList;

import base.ListNode;
import org.w3c.dom.ls.LSInput;

/**
 * 1.判断链表是否有环
 * 2.已知链表有环，返回环的起始位置
 */
public class N_141_hasCycle {

    /*
    快慢指针判断链表是否有环
     */
    public static boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }

    /*
    返回链表中环起始位置
    1.快慢指针，快指针多走K步与慢指针在环中某点相遇，则说明K是环长度的整数倍
    2.假设相遇点与环起始点相距m， 则头结点到环起始点需走k-m；由于K是环长度整数倍，快指针再走K步（不管在环里走了几圈）一定还在相遇点，则走K-m步也到达环起始点
    3.则在相遇点，慢指针指向头结点，则两节点再次相遇，则为起始点
     */
    public static ListNode firstStartCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        //说明链表没有环
        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_2;

        System.out.println(hasCycle(node_1));
        System.out.println(firstStartCycle(node_1).val);
    }
}
