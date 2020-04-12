import bean.TreeNode;

/**
 * 题目：重建二叉树
 * 描述：输入某二叉树的前序遍历和中序遍历的结果，请重建二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，输入前序遍历序「1，2，4，7，3，5，6，8」和中序遍历结果『4，7，2，1，5，3，8，6』，则重建二叉树并输出头节点。
 * 应该输出：    1
 *          2       3
 *       4       5     6
 *          7        8
 */
public class No7 {
    public static void main(String[] args) {
        //解法：利用前序遍历结果中的首节点就是根节点，在中序遍历中，根节点的左边都是左节点，右边都是右节点 重建二叉树
        int[] previous = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] middle = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode node = buildNode(previous, 0, previous.length - 1, middle, 0, middle.length - 1);

        System.out.println(node);
    }

    private static TreeNode buildNode(int[] previous, int previousStart, int previousEnd,
                                      int[] middle, int middleStart, int middleEnd) {
        int rootValue = previous[previousStart];
        TreeNode root = new TreeNode(rootValue);
        if (previousStart == previousEnd || middleStart == middleEnd) {
            return root;
        }
        final int index = findIndex(middle, rootValue);
        final int leftCount = index - middleStart;
        final int rightCount = middleEnd - index;
        if (leftCount > 0) {
            root.left = buildNode(
                    previous, previousStart + 1, previousStart + leftCount,
                    middle, middleStart, index - 1);
        }
        if (rightCount > 0) {
            root.right = buildNode(
                    previous, previousEnd - rightCount + 1, previousEnd,
                    middle, index + 1, index + rightCount);
        }

        return root;
    }

    private static int findIndex(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        throw new IllegalArgumentException("can not find value " + value + " in array.");
    }
}
