package simple.Tree;

/**
 * Created by veefox on 2020年11月9日, 0009
 * 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 示例 :
 * 给定二叉树
 *       1
 *      / \
 *     2  3
 *    / \
 *   4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class DiameterOfBinaryTree {

    private static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

//    分析
//    还记不记得如何求二叉树的最大深度，那么如何求穿过根节点的直径，很显然答案就是将左子树的最大深度 + 右子树的最大深度；
//    但是题目中要求最大直径，也就是说最大直径路径不一定是穿过根节点的，所以要设置一个变量max，用来记录所有的子树的直径，然后更新最大值。
//
//    思路
//    设置一个全局变量max；
//    对root进行求最大深度，调用下maxDeepth方法；
//    越过叶子节点，返回0；
//    计算左子树最大深度left；
//    计算右子树最大深度right；
//   （在这个位置：计算直径 = left + right , 然后再维护最大值max）
//    返回左右子树较大者 + 1；
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }


}
