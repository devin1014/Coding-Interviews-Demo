import util.LogUtil;

import java.util.Iterator;
import java.util.Stack;

/**
 * 题目：从尾到头打印列表
 * 描述：输入一个链表的头节点，从尾到头倒序打印每个节点的值。
 * 节点定义如下：
 * struct{
 * int key;
 * struct next;
 * }
 */
public class No6 {

    public static void main(String[] args) {
        //解法：倒序输出，利用栈结构，后进先出
        //初始化链表
        Node link = new Node(0);
        Node _link = link;
        for (int i = 1; i < 10; i++) {
            _link.next = new Node(i);
            _link = _link.next;
        }
        LogUtil.logNode(link.generate());

        Stack<Node> stack = new Stack<>();
        Node node = link;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static class Node {
        public final int key;
        public Node next;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return String.valueOf(key);
        }

        public Iterator<Node> generate() {
            return new NodeIterator(this);
        }

        private static class NodeIterator implements Iterator<Node> {
            private Node node;

            public NodeIterator(Node node) {
                this.node = node;
            }

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Node next() {
                Node result = node;
                node = node.next;
                return result;
            }
        }
    }
}
