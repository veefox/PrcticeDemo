package simple.Tree;

/**
 * Created by veefox on 2020年11月5日, 0005
 * 翻转二叉树
 */
public class InvertBinaryTree {

    public static void start() {
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(9);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        invertTree(treeNode);
    }

    //          4
//            /   \
//           2     7
//          / \   / \
//         1   3 6   9
//        / \  /\/\   /\
//       1  2 3 45 6 7  8
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        fanzhuan(root);
        return root;
    }

    public void fanzhuan(TreeNode a) {
        if (a == null) {
            return;
        }
        TreeNode c = a.left;
        a.left = a.right;
        a.right = c;
        if (a.left != null) {
            fanzhuan(a.left);
        }
        if (a.right != null) {
            fanzhuan(a.right);
        }
    }

}
