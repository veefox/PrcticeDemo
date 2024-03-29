package middle.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by veefox on 2020年11月18日, 0018
 * 题目：组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class CombinationSum {
    public static class Solution {
        static List<List<Integer>> ans = new ArrayList<>();
        static List<Integer> tempRes = new ArrayList<>();

        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(0, 0, candidates, target);
            return ans;
        }

//               * 输入：candidates = [2,3,5], target = 8,
//                * 所求解集为：
//                * [
//                * [2,2,2,2],
//                * [2,3,3],
//                * [3,5]
//                * ]
        public static void dfs(int cur, int sum, int[] candidates, int target) {
            if (sum == target) {
                ans.add(new ArrayList<>(tempRes));
                return;
            }
            for (int i = cur; i < candidates.length; i++) {
                if (sum + candidates[i] <= target) {
                    tempRes.add(candidates[i]);
                    dfs(i, sum + candidates[i], candidates, target);
                    tempRes.remove(tempRes.size() - 1);
                } else {//由于candidates升序排序，如果出现sum > target,直接break即可
                    break;
                }

            }
        }
    }
}
