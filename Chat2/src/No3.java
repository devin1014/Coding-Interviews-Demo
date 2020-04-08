import util.LogUtil;

/**
 * 题目：数组中重复的数字
 * 描述：在一个长度为n的数组里的所有数字都在 0 ~ n-1 的范围内。数组中的某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组『2，3，1，0，2，5，3』，那么对应的输出是重复的数字 2 或者 3。
 */
public class No3 {
    public static void main(String[] args) {
        // 解法一：排序 「0，1，2，2，3，3，5」，检查相邻数字是否相同
        // 解法二：新建一个长度为n的数组『0，0，...,0』，利用数字都在0~n-1范围内（数组下标的范围也是0~n-1）,遍历数组取下标设非0值。
        // 解法三：如果数组有序且无重复数字，数组下标和值相同如例3。
        int[] inputSample1 = new int[]{2, 3, 1, 0, 2, 5, 3};
        int[] inputSample2 = new int[]{0, 0, 0, 0, 0, 0, 0};
        int[] inputSample3 = new int[]{0, 1, 2, 3, 4, 5, 6};

        result2(inputSample1);
        result2(inputSample2);
        result2(inputSample3);

        result3(inputSample1);
        result3(inputSample2);
        result3(inputSample3);
    }

    private static void result1(int[] array) {
        // ...
    }

    // 不考虑非法输入
    private static void result2(int[] array) {
        LogUtil.logIntArray(array);
        boolean find = false;
        int[] targetArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            targetArray[i] = -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (targetArray[array[i]] != -1) {
                find = true;
                System.out.println(array[i]);
                break;
            } else {
                targetArray[array[i]] = 1;
            }
        }
        if (!find) {
            System.out.println("没有重复数字");
        }
    }

    private static void result3(int[] array) {
        LogUtil.logIntArray(array);
        int index = 0;
        boolean find = false;
        while (index < array.length && !find) {
            while (array[index] != index) {
                if (array[index] != array[array[index]]) {
                    int temp = array[array[index]];
                    array[array[index]] = array[index];
                    array[index] = temp;
                } else {
                    find = true;
                    System.out.println(array[index]);
                    break;
                }
            }
            index++;
        }
        if (!find) {
            System.out.println("没有找到重复的数字");
        }
    }

}
