import util.IOUtil;

/**
 * 题目：剪绳子
 * 描述：给你一根长度为n的绳子，请把绳子剪成m段（m，n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...k[m]。
 * 请问k[0]*k[1]*...k[m]可能的最大乘积是多少？例如，绳子长度为8时，分别剪成2，3，3三段，乘积最大18。
 */
public class No14 {
    public static void main(String[] args) {
        String line = IOUtil.readLine();
        while (line != null && line.length() > 0) {
            System.out.println(result(Integer.valueOf(line)));
            line = IOUtil.readLine();
        }
    }

    private static int result(int n) {
        if (n < 2) return 0;
        else if (n == 2) return 1;
        else if (n == 3) return 2;
        int[] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int result = 0;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int r = products[j] * products[i - j];
                if (r > max) {
                    max = r;
                }
            }
            products[i] = max;
            System.out.println(i + " -> " + max);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}