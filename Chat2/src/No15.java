import util.IOUtil;
import util.LogUtil;

/**
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中的1的个数。
 * 例如：把9表示成1001，有2位是1。因此，如果输入9，则该函数输出2。
 */
public class No15 {
    //思路：整数-1后和原来做与运算，相当于把整数中最右边的1变0.
    public static void main(String[] args) {
        String line = IOUtil.readLine();
        while (line != null && line.length() > 0) {
            try {
                int value = result(Integer.valueOf(line));
                System.out.println(value);
                line = IOUtil.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private static int result(int number) {
        int n = 0;
        while (number != 0) {
            n++;
            number = number & (number - 1);
        }
        return n;
    }
}
