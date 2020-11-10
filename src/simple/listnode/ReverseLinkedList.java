package simple.listnode;

/**
 * Created by veefox on 2020年11月3日, 0003
 * 反转链表
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {
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
//        reverseList(node1);
        reverseList(node1, 0);
    }

    //迭代
//    在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
//    在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    //递归
    public static ListNode reverseList(ListNode head, int test) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next, 0);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
