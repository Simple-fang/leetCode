package search;

/*
 * 查找非递减排序数组中元素的第一个位置和最后一个位置
 * 元素不存在返回【-1，-1】
 */
public class N_34_searchRange {

	// 普通二分查找
	private static int binarySearch(int[] arr, int target) {
		int left=0 , right=arr.length-1;
		
		while(left<=right) {
			int mid = left + (right-left)/2;
			if(arr[mid] == target)
				return mid;
			else if(arr[mid] > target)
				right = mid - 1;
			else if(arr[mid] < target)
				left = mid + 1;
		}
		
		return -1;
	}
	
	
	//查找左边界
	private static int leftBound(int[] arr, int target) {
		int left = 0 , right = arr.length-1;
		
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] == target)
				right = mid - 1;
			else if(arr[mid] > target)
				right = mid - 1;
			else if(arr[mid] < target)
				left = mid + 1;
		}
		
		//	如果target大于数组中所有数 或 小于数组中所有数
		if(left >= arr.length || arr[left] != target)
			return -1;
		return left;
	}
	
	//查找右边界
	private static int rightBound(int[] arr, int target) {
		int left = 0, right = arr.length-1;
		
		while(left<=right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] == target)
				left = mid + 1;
			else if(arr[mid] < target)
				left = mid + 1;
			else if(arr[mid] > target)
				right = mid - 1;
		}
		//	如果target大于数组中所有数 或 小于数组中所有数
		if(right<0 || arr[right] != target)
			return -1;
		return right;
	}
	
	
	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
        res[0] = leftBound(nums, target);
        res[1] = rightBound(nums, target);
        return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,1,2,2,2,3,4,5};
		System.out.println(binarySearch(arr, 3));
		System.out.println(leftBound(arr, 2));
		System.out.println(rightBound(arr, 2));
		
		int[] res = searchRange(arr, 2);
		
		System.out.println("["+res[0]+","+res[1]+"]");
	}

}
