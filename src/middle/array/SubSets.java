package middle.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by veefox on 2020年11月19日, 0019
 * 题目：子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class SubSets {

    public static void start() {
        int[] nn = new int[]{1, 2, 3};
        List<List<Integer>> mm = subsets(nn);
        for (List<Integer> da : mm) {
            System.out.print(da.toString() + ", ");
        }
    }

    //[1,2,3,4]
    // 最开始是空集，那么我们现在要处理1，就在空集上加1，为 [1]，
    // 现在我们有两个自己 [] 和 [1]，下面我们来处理2，我们在之前的子集基础上，每个都加个2，
    // 可以分别得到 [2]，[1, 2]，那么现在所有的子集合为 [], [1], [2], [1, 2]，
    // 同理处理3的情况可得 [3], [1, 3], [2, 3], [1, 2, 3], 再加上之前的子集就是所有的子集合了
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        //[] [1]
        //[2] [1,2]
        //[3] [1,3]
        //[2,3] [1,2,3]
        //[4] [1,4] [2,4] [1,2,4] [3,4] [1,3,4] [2,3,4] [1,2,3,4]
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>();
                list.addAll(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
        }
        return result;
    }
}
