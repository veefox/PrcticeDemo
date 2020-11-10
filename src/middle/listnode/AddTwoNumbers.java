package middle.listnode;

import simple.listnode.ListNode;

import java.util.LinkedList;

/**
 * Created by veefox on 2020年11月9日, 0009
 * 题目:两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * <p>
 * 输入：(2 -> 4 -> 7) + (5 -> 8 -> 9)
 * 输出：7 -> 12 -> 16 + 1
 * 输出：7 -> 2 -> 17
 * 输出：7 -> 2 -> 7 -> 1
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    //    输入：
//            [9,9,9,9,9,9,9]
//            [9,9,9,9]
//    输出：
//            [8,9,9,9,9,1]
//    预期结果：
//            [8,9,9,9,0,0,0,1]
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int j = 0;
        LinkedList<ListNode> queue = new LinkedList<>();
        queue.offer(l1);
        queue.offer(l2);
        while (!queue.isEmpty()) {
            ListNode node1 = queue.remove();
            ListNode node2 = queue.remove();
            if (node1.val + node2.val + j > 9) {
                node1.val = (node1.val + node2.val + j) % 10;
                j = 1;
            } else {
                node1.val = node1.val + node2.val + j;
                j = 0;
            }
            if (node1.next != null || node2.next != null) {
                if (node1.next == null) {
                    node1.next = new ListNode(0);
                }
                if (node2.next == null) {
                    node2.next = new ListNode(0);
                }
                queue.offer(node1.next);
                queue.offer(node2.next);
            } else {
                if (j == 1) {
                    ListNode node = new ListNode();
                    node.val = 1;
                    node1.next = node;
                }
            }
        }
        return l1;
    }
}
