package bean;

import java.util.Iterator;

public class Node {
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
