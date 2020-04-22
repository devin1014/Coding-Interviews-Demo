import util.IOUtil;
import util.LogUtil;

/**
 * 题目：矩阵中的路径
 * 描述：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意位置开始，
 * 每一步可以向左上右下移动一格。如果一条路径经过了矩阵的某一格，那么改路径不能再次进入该格子。
 */
public class No12 {

    private static int pathLength = 0;

    public static void main(String[] args) {
        char[][] array = new char[][]{
                new char[]{'a', 'b', 't', 'g'},
                new char[]{'c', 'f', 'c', 's'},
                new char[]{'j', 'd', 'e', 'h'}};
        LogUtil.logCharArray(array);
        String line = IOUtil.readLine();
        while (line != null && !line.isEmpty()) {
            pathLength = 0;
            boolean[][] visited = new boolean[3][4];
            if (result(array, line, visited)) {
                LogUtil.logBooleanArray(visited);
            }
            line = IOUtil.readLine();
        }
    }

    private static boolean result(char[][] array, String text, boolean[][] visited) {
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                if (hasPath(array, array.length, array[0].length, row, column, pathLength, text, visited)) {
                    System.out.println("find");
                    return true;
                }
            }
        }
        System.out.println("not find");
        return false;
    }

    private static boolean hasPath(char[][] array, int rows, int columns, int row, int column,
                                   int length, String text, boolean[][] visited) {
        if (length >= text.length()) {
            return true;
        }
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            LogUtil.println(String.format("[%s,%s]=%s, text[%s]=%s", row, column, array[row][column], length, text.charAt(length)));
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && column >= 0 && column < columns
                && text.charAt(length) == array[row][column]
                && !visited[row][column]) {
            ++pathLength;
            visited[row][column] = true;

            hasPath = hasPath(array, rows, columns, row, column - 1, length + 1, text, visited)
                    || hasPath(array, rows, columns, row - 1, column, length + 1, text, visited)
                    || hasPath(array, rows, columns, row, column + 1, length + 1, text, visited)
                    || hasPath(array, rows, columns, row + 1, column, length + 1, text, visited);

            if (!hasPath) {
                --pathLength;
                visited[row][column] = false;
            }
        }

        return hasPath;
    }
}
