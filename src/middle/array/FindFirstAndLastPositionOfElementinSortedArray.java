package middle.array;

/**
 * Created by veefox on 2020年11月17日, 0017
 * 题目：在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [0,1,2,3,4,5], target = 8
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 3:
 * 输入: nums = [0,1,2,3,4,5], target = 8
 * 输入: nums = [5,8,8,9,9,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,8,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementinSortedArray {


    public static void start() {
        int[] nn = new int[]{1};
        int[] mm = searchRange(nn, 1);
        for (int a : mm) {
            System.out.print(a + ", ");
        }

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int n = nums.length;
        int left = 0, right = n;
        int lo = testLeft(left, right, nums, target);
        int hi = testRight(left, right, nums, target) - 1;
        if (lo >= nums.length || nums[lo] != target) {
            return result;
        }
        result[0] = lo;
        result[1] = hi;
        return result;
    }
    //5,7,7,8,8,8,8,8,8,8,8,10
    //5,7,7,8,8,9,9,9,9,9,9,10

    //5,7,7,7,7,7,8,8,8,8,8,10
    //5,7,7,8,8,8,8,8,8,8,8,10
    private static int testLeft(int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //6,7,8,8,8,8,8,8,8
    private static int testRight(int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static class Solution {
        // returns leftmost (or rightmost) index at which `target` should be
        // inserted in sorted array `nums` via binary search.
        private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
            int lo = 0;
            int hi = nums.length;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (nums[mid] > target || (left && target == nums[mid])) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return lo;
        }

        public static int[] searchRange(int[] nums, int target) {
            int[] targetRange = {-1, -1};
            int leftIdx = extremeInsertionIndex(nums, target, true);
            // assert that `leftIdx` is within the array bounds and that `target`
            // is actually in `nums`.
            if (leftIdx == nums.length || nums[leftIdx] != target) {
                return targetRange;
            }
            targetRange[0] = leftIdx;
            targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;
            return targetRange;
        }
    }
}
