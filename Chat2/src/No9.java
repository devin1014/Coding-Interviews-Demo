import java.util.Stack;

/**
 * 题目：用两个栈实现队列
 * 描述：队列声明如下，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入和队列头部删除节点的功能。
 */
public class No9 {
    public static void main(String[] args) {
        //栈的结构：先进后出
        //队列结构：先进先出
        //解法：栈1只进栈，出栈时，如果栈2为空，栈1数据导入栈2，这样栈2的头节点就是最先入栈1的节点也是应该出队列的节点。
        //如果栈2不为空先出栈，否则从栈1导入数据然后出栈。
        //如下应该输出结果和入栈的序列相同：a,b,c,d,e,f
        MyQueue<String> queue = new MyQueueImpl();
        queue.appendTail("a")
                .appendTail("b")
                .appendTail("c")
                .deleteHead();
        queue.appendTail("d")
                .appendTail("e");
        queue.deleteHead();
        queue.deleteHead();
        queue.appendTail("f");
        queue.deleteHead();
        queue.deleteHead();
        queue.deleteHead();
    }

    public interface MyQueue<T> {
        MyQueue<T> appendTail(T t);

        T deleteHead();
    }

    public static class MyQueueImpl implements MyQueue<String> {

        private Stack<String> stack1 = new Stack<>();
        private Stack<String> stack2 = new Stack<>();

        @Override
        public MyQueue<String> appendTail(String t) {
            stack1.push(t);
            return this;
        }

        @Override
        public String deleteHead() {
            if (stack2.isEmpty() && !stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            String head = stack2.pop();
            System.out.print(head + "->");
            return head;
        }
    }
}


