import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 题目：用两个队列实现栈
 */
public class No9_2 {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStackImpl();
        stack.push("a")
                .push("b")
                .push("c");
        stack.pop();
        stack.push("d")
                .push("e");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }

    public interface MyStack<T> {
        MyStack<T> push(T t);

        T pop();
    }

    public static class MyStackImpl implements MyStack<String> {

        private Queue<String> queue1 = new ArrayDeque<>();
        private Queue<String> queue2 = new ArrayDeque<>();

        @Override
        public MyStack<String> push(String t) {
            Queue<String> q = queue2.isEmpty() ? queue1 : queue2;
            q.add(t);
            return this;
        }

        @Override
        public String pop() {
            Queue<String> insertQueue = queue1.isEmpty() ? queue1 : queue2;
            Queue<String> deleteQueue = queue1.isEmpty() ? queue2 : queue1;
            while (deleteQueue.size() > 1) {
                insertQueue.add(deleteQueue.remove());
            }
            String obj = deleteQueue.remove();
            System.out.print(obj + "->");
            return obj;
        }
    }
}


