package listnode;

/**
 * 合并两个有序链表
 * 示例：
 输入：1->2->4, 1->3->4
 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public static void start() {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();

        node1.val = 1;
        node1.next = node2;
        node2.val = 2;
        node2.next = node3;
        node3.val = 3;
        node3.next = null;

        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        ListNode node6 = new ListNode();
        node4.val = 2;
        node4.next = node5;
        node5.val = 3;
        node5.next = node6;
        node6.val = 4;
        node6.next = null;
        sys(mergeTwoLists(node1, node4));
    }

    public static void sys(ListNode node) {
        System.out.print(node.val + "、");
        if (node.next != null) {
            sys(node.next);
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
