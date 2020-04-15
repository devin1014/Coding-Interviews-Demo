/**
 * 题目：斐波那契数列
 * 描述：求斐波那契数列的第n项
 */
public class No10 {
    public static void main(String[] args) {
        int num = 20;
        System.out.println(String.format("fun(%s)=%s", num, fun(num)));
        System.out.println(String.format("fun(%s)=%s", num, fun2(num)));
    }

    private static int fun(int num) {
        if (num <= 0) return 0;
        else if (num == 1) return num;
        return fun(num - 1) + fun(num - 2);
    }

    private static int fun2(int num) {
        if (num <= 0) return 0;
        else if (num == 1) return 1;
        int left = 1;
        int right = 0;
        int result = 0;
        for (int i = 2; i <= num; i++) {
            result = left + right;
            right = left;
            left = result;
        }
        return result;
    }
}
