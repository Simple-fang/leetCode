package array;

/**
 *将数组中为0元素移到末尾
 * 2。如果保证原数组元素相对顺序不变呢
 */
public class N_283_moveZeros {


    /*
    使用左右指针，将0移到末尾即可
     */
    private static void solution_1(int[] arr) {
        int left = 0, right = arr.length-1;
        while (left < right) {
            while (left < right && arr[left] != 0) {
                left++;
            }
            while (left < right && arr[right] == 0) {
                right--;
            }
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
    }

    /*
    如果要求非0元素相对顺序不变，就不能使用首尾双指针交换
    可在N_27（删除指定元素）基础上，使用快慢指针删除0元素，再将后续元素填充为0
     */
    private static void solution_2(int[] arr){
        int p = remove(arr, 0);
        for (; p < arr.length; p++) {
            arr[p] = 0;
        }
    }

    private static int remove(int[] arr, int target) {
        int slow=0, fast=0;
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
        int[] arr = new int[]{0,1,0,2,3,4,0};
        solution_1(arr);
        for(int i : arr)
            System.out.print(i + " ");

        int[] arr2 = new int[]{0,1,0,2,3,4,0};
        solution_2(arr2);
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }
}
