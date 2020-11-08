package listnode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedListCycle {

    //用哈希表 往set集合里添加节点 如果添加失败代表集合里有这个节点了
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public class MinStack {

        // 数据栈
        private Stack<Integer> data;
        // 辅助栈
        private Stack<Integer> helper;

        public MinStack() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        // 思路 1：数据栈和辅助栈在任何时候都同步
        public void push(int x) {
            // 数据栈和辅助栈一定会增加元素
            data.add(x);
            if (helper.isEmpty() || helper.peek() >= x) {
                helper.add(x);
            } else {
                helper.add(helper.peek());
            }
        }

        public void pop() {
            // 两个栈都得 pop
            if (!data.isEmpty()) {
                helper.pop();
                data.pop();
            }
        }

        public int top() {
            if(!data.isEmpty()){
                return data.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }

        public int getMin() {
            if(!helper.isEmpty()){
                return helper.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }
    }

}
