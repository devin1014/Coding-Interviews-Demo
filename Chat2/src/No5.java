import util.IOUtil;
import util.LogUtil;

/**
 * 题目：替换空格
 * 描述：请实现一个函数，把字符串中的每个空格替换成“%20”。
 * 例如，输入“We are happy.”，则输出“We%20are%20happy.”。
 */
public class No5 {
    public static void main(String[] args) {
        //解法：遍历一次string，找出一个有几个空格，每出现一个空格输出的字符就会多2个（' '->'%20'），
        //所以可以新创建一个数组长度为length+2*blankCount
        //必须从后往前倒序遍历数组，这样才能移动最少的字符。
        String line = IOUtil.readLine();
        while (!"".equalsIgnoreCase(line)) {
            result(line);
            line = IOUtil.readLine();
        }
    }

    private static void result(String text) {
        int blankCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                blankCount++;
            }
        }
        if (blankCount == 0) { //如果没有空格就不需要遍历了，直接输出。
            System.out.println(text);
            return;
        }
        char[] chars = new char[text.length() + 2 * blankCount];
        int outIndex = chars.length - 1;
        for (int i = text.length() - 1; i >= 0; i--) {
            if (text.charAt(i) != ' ') {
                chars[outIndex--] = text.charAt(i);
            } else {
                chars[outIndex--] = '0';
                chars[outIndex--] = '2';
                chars[outIndex--] = '%';
            }
            if (outIndex == i) {
                //再往前的字符没有空格了，可以直接输出，不用再比了。
            }
        }
        LogUtil.logCharArray(chars);
    }
}
