package bean;

public class ParentTreeNode<T> {
    public final T value;
    public ParentTreeNode parent;
    public ParentTreeNode left;
    public ParentTreeNode right;

    public ParentTreeNode(T value) {
        this.value = value;
    }

    public ParentTreeNode(T value, ParentTreeNode<T> parent) {
        this.value = value;
        this.parent = parent;
    }

    public boolean isLeftNode() {
        return parent != null && parent.left == this;
    }

    public boolean isRightNode() {
        return parent != null && parent.right == this;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean isRootNode() {
        return parent == null;
    }

    @Override
    public String toString() {
        return "ParentTreeNode{" +
                "value=" + value +
                '}';
    }
}
