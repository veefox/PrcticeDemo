package simple.listnode;

/**
 * Created by yaoweiye on 2020年10月30日, 0030
 * 相交链表
 */
public class IntersectionOfTwoLinkedLists {

    //相交链表
    //输入：intersectVal = 8, listA = [1,4,1,8,4,5], listB = [2,2,4,5], skipA = 4, skipB = 2
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        while (ha != hb) {
            ha = ha != null ? ha.next : headB;
            hb = hb != null ? hb.next : headA;
        }
        return ha;

    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
}
