package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {

        int m = Integer.MIN_VALUE;

        for (int elem : values) {
            if (elem > m) {
                m = elem;
            }
        }

        return m;
    }
}
