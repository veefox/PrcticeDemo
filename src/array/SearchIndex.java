package array;

/**
 * Created by yaoweiye on 2020年10月22日, 0022
 */
public class SearchIndex {

    public static void start() {

        System.out.println(searchIndex(new int[]{1,3,5,6}, 5));
        System.out.println(search(new int[]{1,3,5,6}, 2));
        System.out.println(searchIndex(new int[]{1,3,5,6}, 7));
        System.out.println(searchIndex(new int[]{1,3,5,6}, 0));
        System.out.println(searchIndex(new int[]{1,3,5,6}, -2));
    }


    //二分法
    // 0 1 2 3 4  5  6  7  8  9
    //[1,3,5,6,8,10,12,13,15,17], 4 输出2
    //[1,3,5,6], 2 输出1
    //[1,3,5,6], 7 输出4
    //[1,3,5,6], 0 输出0
    public static int searchIndex(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;

//        暴力拆解法
//        for (int i = 0; i < nums.length; i++) {
//            if (target <= nums[i]){
//                return i;
//            }
//        }
//        return nums.length;
    }

    //查找不存在元素的区间
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right -left) / 2;  //mid=4;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }

}
