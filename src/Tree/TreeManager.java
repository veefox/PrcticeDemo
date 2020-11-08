package Tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaoweiye on 2020年10月28日, 0028
 */
public class TreeManager {

    private static int count = 1;
    private static int count1 = 1;

    public static void start() {
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(4);

//        treeNode.left = treeNode1;
//        treeNode.right = treeNode2;
//
//        treeNode1.left = treeNode3;
//        treeNode1.right = treeNode4;
//
//        treeNode2.left = treeNode5;
//        treeNode2.right = treeNode6;

        //对称二叉树
//        System.out.println(isSymme(treeNode));
//        isSymmetric(treeNode);

        //最大深度
        System.out.println(maxDepth(treeNode));
        System.out.println(MaxDepth.maxDepth(treeNode));
        depth(treeNode);
        System.out.println(Math.max(count, count1));
    }

    //对称二叉树-递归方法
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    //对称二叉树-迭代
    public static boolean isSymme(TreeNode root) {
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return true;
        //左子节点和右子节点同时入队
        queue.add(root.left);
        queue.add(root.right);
        //如果队列不为空就继续循环
        while (!queue.isEmpty()) {
            //每两个出队
            TreeNode left = queue.poll(), right = queue.poll();
            //如果都为空继续循环
            if (left == null && right == null)
                continue;
            //如果一个为空一个不为空，说明不是对称的，直接返回false
            if (left == null ^ right == null)
                return false;
            //如果这两个值不相同，也不是对称的，直接返回false
            if (left.val != right.val)
                return false;
            //这里要记住入队的顺序，他会每两个两个的出队。
            //左子节点的左子节点和右子节点的右子节点同时
            //入队，因为他俩会同时比较。
            //左子节点的右子节点和右子节点的左子节点同时入队，
            //因为他俩会同时比较
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    //二叉树最大深度
//    思路与算法
//    如果我们知道了左子树和右子树的最大深度 ll 和 rr，那么该二叉树的最大深度即为
//    max(l,r) + 1
//    max(l,r)+1
//    而左子树和右子树的最大深度又可以以同样的方式进行计算。因此我们在计算当前二叉树的最大深度时，可以先递归计算出其左子树和右子树的最大深度
//    然后在 O(1)O(1) 时间内计算出当前二叉树的最大深度。递归在访问到空节点时退出
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void depth(TreeNode root) {
        if (root.left != null) {
            depth(root.left);
            count += 1;
        }
        if (root.right != null) {
            depth(root.right);
            count1 += 1;
        }
    }

//             1              1
//          2     2        2     2
//       3   4  4   3       4
//      5 9 6    6 9 5
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

}
