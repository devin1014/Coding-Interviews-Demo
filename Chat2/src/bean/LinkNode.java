package bean;

import java.util.Iterator;

public class LinkNode {
    public final int key;
    public LinkNode next;

    public LinkNode(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }

    public Iterator<LinkNode> generate() {
        return new NodeIterator(this);
    }

    private static class NodeIterator implements Iterator<LinkNode> {
        private LinkNode node;

        public NodeIterator(LinkNode node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public LinkNode next() {
            LinkNode result = node;
            node = node.next;
            return result;
        }
    }
}
