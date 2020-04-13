import bean.ParentTreeNode;

/**
 * 题目：二叉树的下一个节点
 * 描述：给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？树种的节点除了有两个分别指向左右子节点的指针，
 * 还有一个指向父节点的指针。
 * 中序遍历「d，b，h，e，i，a，f，c，g」
 */
//           a
//       b       c
//    d    e   f   g
//        h   i
public class No8 {
    public static void main(String[] args) {
        //解法：分类判断
        //如果它是左页子节点，下一位是它的父节点
        //如果它不是一个页子节点，并且它有右子节点，那么下一位是它右子节点的最后一位左子节点
        //如果它不是一个页子节点，并且它也没有右子节点，那么下一位是它的父节点
        //如果它是一个右页子节点，找到它的父节点（父节点不能是右节点）的父节点
        ParentTreeNode root = new ParentTreeNode("a", null);
        ParentTreeNode bNode = new ParentTreeNode("b", root);
        ParentTreeNode cNode = new ParentTreeNode("c", root);
        root.left = bNode;
        root.right = cNode;
        ParentTreeNode dNode = new ParentTreeNode("d", bNode);
        ParentTreeNode eNode = new ParentTreeNode("e", bNode);
        bNode.left = dNode;
        bNode.right = eNode;
        ParentTreeNode fNode = new ParentTreeNode("f", cNode);
        ParentTreeNode gNode = new ParentTreeNode("g", cNode);
        cNode.left = fNode;
        cNode.right = gNode;
        ParentTreeNode hNode = new ParentTreeNode("h", eNode);
        ParentTreeNode iNode = new ParentTreeNode("i", eNode);
        eNode.left = hNode;
        eNode.right = iNode;

        result(dNode);
        result(bNode);
        result(hNode);
        result(eNode);
        result(iNode);
        result(root);
        result(fNode);
        result(cNode);
        result(gNode);
    }

    private static <T> ParentTreeNode<T> result(ParentTreeNode<T> node) {
        if (node.isLeaf() && node.isLeftNode()) {
            System.out.println(node.parent);
            return node.parent;
        } else if (node.isLeaf() && node.isRightNode()) {
            ParentTreeNode<T> parent = node.parent;
            while (parent != null && parent.isRightNode()) {
                parent = parent.parent;
            }
            System.out.println(parent != null ? parent.parent : "null");
            return parent;
        } else if (!node.isLeaf()) {
            if (node.right != null) {
                System.out.println(findFirstLeftLeaf(node.right));
                return findFirstLeftLeaf(node.right);
            } else {
                System.out.println(node.parent);
                return node.parent;
            }
        } else {
            System.out.println(node);
            return node;
        }
    }

    private static <T> ParentTreeNode<T> findFirstLeftLeaf(ParentTreeNode<T> node) {
        if (node.left == null) {
            return node;
        }
        ParentTreeNode<T> _leftNode = node.left;
        while (_leftNode != null && _leftNode.left != null) {
            _leftNode = _leftNode.left;
        }
        return _leftNode;
    }
}
