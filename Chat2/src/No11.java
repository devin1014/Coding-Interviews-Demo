/**
 * 题目：旋转数组中的最小数字
 * 描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序数组的一个旋转，输出旋转数组的最小元素。
 * 例如：数组「3，4，5，1，2」为「1，2，3，4，5」的一个旋转，该数组的最小值为1.
 */
public class No11 {
    public static void main(String[] args) {
        //利用二分法，由于数组分为两部分，分别有序。
        int[] array = new int[]{1, 2, 3, 4, 5};
        int[] array2 = new int[]{5, 4, 3, 2, 1};
        int[] array3 = new int[]{4, 5, 6, 7, 8, 9, 3};
        int[] array4 = new int[]{1};
        int[] array5 = new int[]{1, 2};
        int[] array6 = new int[]{2, 1};
        System.out.println(result(array));
        System.out.println(result(array2));
        System.out.println(result(array3));
        System.out.println(result(array4));
        System.out.println(result(array5));
        System.out.println(result(array6));
    }

    private static int result(int[] array) {
        int p1 = 0;
        int p2 = array.length - 1;
        if (array[p1] <= array[p2]) {
            return array[p1];
        }
        while (Math.abs(p1 - p2) > 1) {
            int mid = (p1 + p2) / 2;
            if (array[mid] < array[p1]) {
                p2 = mid;
            } else if (array[mid] >= array[p1]) {
                p1 = mid;
            }
        }
        return array[p2];
    }
}
