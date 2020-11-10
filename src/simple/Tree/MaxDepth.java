package simple.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

    //广度优先搜索
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。
//        LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
//        queue.offer();//添加元素
//        queue.poll();//返回第一个元素，并删除
//        queue.peek();////返回第一个元素，不删除
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();//返回第一个元素，并在队列中删除
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
