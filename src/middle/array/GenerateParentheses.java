package middle.array;

import java.util.*;

/**
 * Created by veefox on 2020年11月12日, 0012
 * 题目：括号生成
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();




        return null;

    }

    public static class Solution {

        // 做减法

        public static List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            // 特判
            if (n == 0) {
                return res;
            }

            // 执行深度优先遍历，搜索可能的结果
            dfs("", n, n, res);
            return res;
        }

        /**
         * @param curStr 当前递归得到的结果
         * @param left   左括号还有几个可以使用
         * @param right  右括号还有几个可以使用
         * @param res    结果集
         */
        private static void dfs(String curStr, int left, int right, List<String> res) {
            // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
            // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
            if (left == 0 && right == 0) {
                res.add(curStr);
                return;
            }

            // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
            if (left > right) {
                return;
            }

            if (left > 0) {
                dfs(curStr + "(", left - 1, right, res);
            }

            if (right > 0) {
                dfs(curStr + ")", left, right - 1, res);
            }
        }
    }

    //广度遍历优先
    public static class Solution2 {

        static class Node {
            /**
             * 当前得到的字符串
             */
            private String res;
            /**
             * 剩余左括号数量
             */
            private int left;
            /**
             * 剩余右括号数量
             */
            private int right;

            public Node(String str, int left, int right) {
                this.res = str;
                this.left = left;
                this.right = right;
            }
        }

        public static List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            if (n == 0) {
                return res;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node("", n, n));

            while (!queue.isEmpty()) {

                Node curNode = queue.poll();
                if (curNode.left == 0 && curNode.right == 0) {
                    res.add(curNode.res);
                }
                if (curNode.left > 0) {
                    queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
                }
                if (curNode.right > 0 && curNode.left < curNode.right) {
                    queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
                }
            }
            return res;
        }
    }

}
