import bean.LinkNode;
import util.LogUtil;

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
        LinkNode link = new LinkNode(0);
        LinkNode _link = link;
        for (int i = 1; i < 10; i++) {
            _link.next = new LinkNode(i);
            _link = _link.next;
        }
        LogUtil.logNode(link.generate());

        Stack<LinkNode> stack = new Stack<>();
        LinkNode node = link;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
