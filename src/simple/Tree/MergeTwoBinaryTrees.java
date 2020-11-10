package simple.Tree;

import java.util.LinkedList;

/**
 * Created by veefox on 2020年11月9日, 0009
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * 示例 1:
 * 输入:
 * simple.Tree 1                   simple.Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始
 */
public class MergeTwoBinaryTrees {

    //递归
//    合并两个数组很直观，将数组 2 的值合并到数组 1 中，再返回数组 1 就可以了。
//    对于二叉树来说，如果我们像遍历数组那样，挨个遍历两颗二叉树中的每个节点，再把他们相加，那问题就比较容易解决了。
//    遍历二叉树很简单，用 前序 遍历就可以了，再依次把访问到的节点值相加，因为题目没有说不能改变树的值和结构，我们不用再创建新的节点了，直接将树2合并到树1上再返回就可以了。
//    需要注意：这两颗树并不是长得完全一样，有的树可能有左节点，但有的树没有。
//    对于这种情况，我们统一的都把他们挂到树 1 上面就可以了，对于上面例子中的两颗树，合并起来的结果如下：
//    相当于树1少了一条腿，而树 2 有这条腿，那就把树 2 的拷贝过来。
//    总结下递归的条件：
//    终止条件：树 1 的节点为 null，或者树 2 的节点为 null
//    递归函数内：将两个树的节点相加后，再赋给树 1 的节点。再递归的执行两个树的左节点，递归执行两个树的右节点
    class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if(t1==null || t2==null) {
                return t1==null? t2 : t1;
            }
            return dfs(t1,t2);
        }

        TreeNode dfs(TreeNode r1, TreeNode r2) {
            // 如果 r1和r2中，只要有一个是null，函数就直接返回
            if(r1==null || r2==null) {
                return r1==null? r2 : r1;
            }
            //让r1的值 等于  r1和r2的值累加，再递归的计算两颗树的左节点、右节点
            r1.val += r2.val;
            r1.left = dfs(r1.left,r2.left);
            r1.right = dfs(r1.right,r2.right);
            return r1;
        }
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }

    //迭代-广度优先算法
//              * simple.Tree 1                   simple.Tree 2
//            *      1                         2
//            *     / \                       / \
//            *    3   2                     1   3
//            *   / \                       /  \   \
//            *  5   4                     2    4   7
//            *      3
//            *     / \
//            *    4   5
//            *   / \   \
//            *  7   8   7
    public static TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        //如果 t1和t2中，只要有一个是null，函数就直接返回
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(t1);
        queue.add(t2);
        while (queue.size() > 0) {  // 5 2 4 4
            TreeNode r1 = queue.remove();
            TreeNode r2 = queue.remove();
            r1.val += r2.val;
            //如果r1和r2的左子树都不为空，就放到队列中
            //如果r1的左子树为空，就把r2的左子树挂到r1的左子树上
            if (r1.left != null && r2.left != null) {
                queue.add(r1.left);
                queue.add(r2.left);
            } else if (r1.left == null) {
                r1.left = r2.left;
            }
            //对于右子树也是一样的
            if (r1.right != null && r2.right != null) {
                queue.add(r1.right);
                queue.add(r2.right);
            } else if (r1.right == null) {
                r1.right = r2.right;
            }
        }
        return t1;
    }


}
