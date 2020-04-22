package util;

import java.util.Arrays;
import java.util.Iterator;

public class LogUtil {
    public static void logIntArray(int[] array) {
        System.out.println("out: " + Arrays.toString(array));
    }

    public static void logIntArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            logIntArray(array[i]);
        }
    }

    public static void logCharArray(char[] array) {
        System.out.println("out: " + Arrays.toString(array));
    }

    public static void logCharArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            logCharArray(array[i]);
        }
    }

    public static void logBooleanArray(boolean[] array) {
        System.out.println("out: " + Arrays.toString(array));
    }

    public static void logBooleanArray(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            logBooleanArray(array[i]);
        }
    }

    public static <T> void logNode(Iterator<T> it) {
        StringBuilder builder = new StringBuilder("[");
        while (it.hasNext()) {
            builder.append(it.next()).append(",");
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

    public static void println(String msg) {
        System.out.println(msg);
    }
}
