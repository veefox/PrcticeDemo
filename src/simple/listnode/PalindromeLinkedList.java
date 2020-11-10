package simple.listnode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaoweiye on 2020年11月5日, 0005
 * 回文链表
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinkedList {

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
        System.out.println(isPalindrome1(node1));
//        printListNode(node1);
    }

    //方法一
    //使用额外的数组空间
    public static boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // 将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 使用双指针判断是否回文
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    static ListNode temp;

    //方法二
    //迭代法
    public static boolean isPalindrome1(ListNode head) {
        temp = null;
        temp = head;
        return check(head);
    }

    private static boolean check(ListNode head) {
        if (head == null)
            return true;
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }

    //小知识点
    //逆序打印链表
    private static void printListNode(ListNode head) {
        if (head == null)
            return;
        printListNode(head.next);
        System.out.println(head.val);
    }
}
