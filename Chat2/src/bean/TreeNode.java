package bean;

public class TreeNode {
    public final int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", \nleft=" + left +
                ", \nright=" + right +
                '}';
    }
}
