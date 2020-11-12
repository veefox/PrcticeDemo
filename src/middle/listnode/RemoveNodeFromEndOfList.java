package middle.listnode;

import simple.listnode.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by veefox on 2020年11月12日, 0012
 * 题目：删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * 双指针最牛逼
 */
public class RemoveNodeFromEndOfList {

    public static void start() {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();
        ListNode node5 = new ListNode();
        node1.val = 1;
        node1.next = node2;
        node2.val = 2;
        node2.next = node3;
        node3.val = 3;
        node3.next = node4;
        node4.val = 4;
        node4.next = node5;
        node5.val = 5;
        node5.next = null;
        ListNode node = removeNthFromEnd3(node1, 2);
        System.out.println(node);
    }

    //自己写的
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode cur = list.get(list.size() - n);
        if (n == list.size()) {
            cur.next = null;
            if (list.size() > 1) {
                return list.get(1);
            } else {
                return null;
            }
        }
        ListNode last = list.get(list.size() - n - 1);
        last.next = cur.next;
        cur.next = null;
        return list.get(0);
    }

    //计算链表长度
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    //栈
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    //双指针                    p  s           f
//    给定一个链表: 1->2->3->4->5->6->7->8->9, 和 n = 4.
//    当删除了倒数第二个节点后，链表变为 1->2->3->4->6->7->8.
    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        //双指针找倒数第n个节点
        ListNode slow = head, fast = head, pre = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (slow == head) {
            return head.next;
        }
        pre.next = slow.next;
        return head;
    }
}
