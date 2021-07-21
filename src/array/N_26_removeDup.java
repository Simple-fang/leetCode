package array;

public class N_26_removeDup {

    /*
    删除重复元素
     */
    private static int removeDup(int[] arr) {

        int slow, fast;
        slow = fast = 0;
        for (; fast < arr.length; ) {
            if (arr[slow] != arr[fast]) {
                slow++;             //先执行slow++，保存第一个重复元素
                arr[slow] = arr[fast];
            }
            fast++;
        }

        return slow + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,3,4};
        int res = removeDup(arr);
        System.out.println(res);
        for (int i = 0; i < res; i++) {
            System.out.println(arr[i]);
        }
    }
}
