package base;

public class LinkedListUtil {

    //头插法逆序建立单链表
    public static ListNode build_head(int[] arr){
        ListNode head = null;

        for (int i = 0; i < arr.length; i++) {
            ListNode tmp = new ListNode(arr[i]);
            if (head == null) {
                head = tmp;
            }else {
                tmp.next = head;
                head = tmp;
            }
        }

        return head;
    }

    //使用虚拟头节点，不需要额外判断头节点
    public static ListNode build_head2(int[] arr) {
        ListNode head = new ListNode(-1);
        for (int i = 0; i < arr.length; i++) {
            ListNode tmp = new ListNode(arr[i]);
            tmp.next = head.next;
            head.next = tmp;
        }
        return head.next;
    }

    //尾插法顺序建立单链表
    public static ListNode build_rear(int[] arr){
        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < arr.length; i++) {
            ListNode tmp = new ListNode(arr[i]);
            if (head == null) {
                head = tail = tmp;
            }else{
                tail.next = tmp;
                tail = tmp;
            }
        }
        return head;
    }

    //使用虚拟头节点，不需要额外判断头节点
    public static ListNode build_rear2(int[] arr) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;

        for (int i = 0; i < arr.length; i++) {
            ListNode tmp = new ListNode(arr[i]);
            tail.next = tmp;
            tail = tmp;
        }
        return head.next;
    }



    public static void traverse(ListNode head){
        if (head == null) {
            return;
        }
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.val + ",");
            }else{
                System.out.print(head.val);
            }

            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        traverse(build_head2(arr));
        System.out.println();
        traverse(build_rear2(arr));
    }
}
