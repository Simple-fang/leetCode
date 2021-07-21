package array;

public class N_27_removeNum {

    /*
    与去重思路相似，使用双指针，不同的是先给arr[slow]赋值，再slow++，保证target值不被复制
     */
    public static int removeNum(int[] arr, int target) {
        int slow=0 , fast=0;
        while (fast < arr.length) {
            if (arr[fast] != target) {
                arr[slow] = arr[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3};
        int res = removeNum(arr, 2);
        System.out.println(res);
        for (int i = 0; i < res; i++) {
            System.out.println(arr[i]);
        }
    }
}
