import util.LogUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目：二维数组中的查找
 * 描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下的递增顺序排序。请完成一个函数，
 * 输入这样的一个二位数组和一个整数，判断数组中是否含有该整数
 */
public class No4 {
    public static void main(String[] args) throws IOException {
        // 解法：从右上角开始取数字对比，如果当前数字就是需要的值，输出结果。否则，当前值比需要的值小，指针向坐移动（整列数字都大于需要的数字）。
        // 如果当前值比需要的值大，指针向下移动（整下的整行都比需要的数字小）
        int[][] arrays = new int[][]{
                new int[]{1, 2, 8, 9},
                new int[]{2, 4, 9, 12},
                new int[]{4, 7, 10, 13},
                new int[]{6, 8, 11, 15}
        };

        for (int i = 0; i < arrays.length; i++) {
            LogUtil.logIntArray(arrays[i]);
        }

        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.print("read:");
        int expertNum = Integer.parseInt(bufferedReader.readLine());
        while (expertNum != -1) {
            result1(arrays, expertNum);
            System.out.print("read:");
            expertNum = Integer.parseInt(bufferedReader.readLine());
        }
    }

    private static void result1(int[][] arrays, int expert) {
        System.out.print(String.format("try to find [%s]: ", expert));
        boolean find = false;
        int row = 0, column = arrays[0].length - 1;
        while (row < arrays.length && column >= 0) {
            System.out.print(arrays[row][column] + "->");
            if (arrays[row][column] == expert) {
                find = true;
                System.out.println("找到了");
                break;
            } else if (arrays[row][column] > expert) {
                column--;
            } else {
                row++;
            }
        }
        if (!find) {
            System.out.println("「没有找到！」");
        }
    }
}
