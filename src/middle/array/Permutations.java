package middle.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by veefox on 2020年11月18日, 0018
 * 题目：全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {

    public static void start() {
        int[] nn = new int[]{1,2,3,4};
        Solution.permute(nn);
    }

    static class Solution {

        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();

            List<Integer> output = new ArrayList<Integer>();
            for (int num : nums) {
                output.add(num); //1,2,3,4
            }

            int n = nums.length;  //3
            backtrack(n, output, res, 0);
            return res;
        }

        public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
            // 所有数都填完了
            if (first == n) {
                res.add(new ArrayList<Integer>(output));
                String tmp = "";
                for (int i = 0; i < n; i++)
                    tmp += output.get(i) + ",";
                System.out.println(tmp);
            }
            for (int i = first; i < n; i++) {
                // 动态维护数组
                Collections.swap(output, first, i);
                // 继续递归填下一个数
                backtrack(n, output, res, first + 1);
                // 撤销操作
                Collections.swap(output, first, i);
            }
        }
    }


    /**
     * 将list中，下标为i和下标为j的两个元素交换
     */
    public static void swap(int[] list, int i, int j) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    public static void perm(int[] list, int start, int end) {
        if (start == end - 1) {
            String tmp = "";
            for (int i = 0; i < end; i++)
                tmp += list[i] + ",";
            System.out.println(tmp);
        } else {
            for (int i = start; i < end; i++) {
                swap(list, start, i);
                perm(list, start + 1, end);
                swap(list, start, i);
            }
        }
    }

}
