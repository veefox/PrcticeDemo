package simple.array;

/**
 * 删除排序数组中的重复项
 */
public class DeleteRepeatArray {

    public static void start() {
        int[] test = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] test1 = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeDuplicates(test));
        System.out.println(removeSame(test1, 2));
    }

    //给定 nums = [0,0,1,1,1,2,2,3,3,4] —> [0,1,2,3,4,*,*,*,*]
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    //移除元素--已提交 击败100%
    //给定 nums = [0,1,2,2,3,0,4,2], val = 2, >>>>> [0,1,3,0,4]
    public static int removeSame(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length ; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


}
