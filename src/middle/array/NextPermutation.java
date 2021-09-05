package middle.array;

/**
 * Created by veefox on 2020年11月13日, 0013
 * 题目：下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * 输入：nums = [1,2,1,6,4,3,2]
 * 输入：nums = [1,2,6,1,4,3,2]
 * 输出：       [1,2,6,1,2,3,4]
 * <p>
 * 示例 4：
 * 输入：nums = [1,3,2]
 * 输出：[2,1,3]
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class NextPermutation {

    public static void start() {//2 2 1 3 4 5
        int[] nn = new int[]{2, 3, 6, 5, 4, 3, 2}; //1 3 2
//      int[] nn = new int[]{2, 3, 6, 5, 4, 3, 2};
        int[] nl = new int[]{2, 4, 2, 3, 3, 5, 6};
        int[] mm = nextPermutation(nn);
        for (int i : mm) {
            System.out.print(i + ",");
        }
    }

    public static int[] nextPermutation(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = n - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        index = i;
                        break;
                    }
                }
                break;
            }
        }
        for (int i = index; i < n - 1; i++) {
            int min = i; // 遍历的区间最小的值
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[min]) {
                    // 找到当前遍历区间最小的值的索引
                    min = j;
                }
            }
            if (min != i) {
                // 发生了调换
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }


}
