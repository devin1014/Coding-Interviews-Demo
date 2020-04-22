import util.IOUtil;
import util.LogUtil;

/**
 * 题目：机器人的运动范围
 * 描述：地上有一个m行n列的方格。一个机器人从坐标（0，0）的格子开始移动，它每次可以向左右上下移动一格，但不能进去行坐标和列坐标的数位之和大于K的格子。
 * 例如，当k=18时，机器人能够进去方格（35，37），因为3+5+3+7=18.请问机器人最多到达多少个格子？
 */
public class No13 {
    public static void main(String[] args) {
        String line = IOUtil.readLine();
        while (line != null && line.length() > 0) {
            boolean[][] visited = new boolean[15][10];
            LogUtil.println("result:" + result(visited, Integer.valueOf(line)));
            LogUtil.logBooleanArray(visited);
            line = IOUtil.readLine();
        }
    }

    private static int result(boolean[][] visited, int k) {
        return find(visited.length, visited[0].length, 0, 0, k, visited);
    }

    private static int find(int rows, int columns, int row, int column, int k, boolean[][] visited) {
        int count = 0;
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            int num = parseBit(row) + parseBit(column);
            if (num <= k && !visited[row][column]) {
                visited[row][column] = true;
                count = 1
                        + find(rows, columns, row - 1, column, k, visited)
                        + find(rows, columns, row, column - 1, k, visited)
                        + find(rows, columns, row + 1, column, k, visited)
                        + find(rows, columns, row, column + 1, k, visited);
            }
        }

        return count;
    }

    private static int parseBit(int number) {
        int result = 0;
        while (number % 10 > 0) {
            result += number % 10;
            number = number / 10;
        }
        return result;
    }
}
