package util;

import java.util.Arrays;
import java.util.Iterator;

public class LogUtil {
    public static void logIntArray(int[] array) {
        System.out.println("out: " + Arrays.toString(array));
    }

    public static void logIntArray(char[] array) {
        System.out.println("out: " + Arrays.toString(array));
    }

    public static <T> void logNode(Iterator<T> it) {
        StringBuilder builder = new StringBuilder("[");
        while (it.hasNext()) {
            builder.append(it.next()).append(",");
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}
