package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array != null && array.length != 0) {
            int[] temp = new int[array.length];
            System.arraycopy(array, 0, temp, 1, array.length-1);
            temp[0] = array[array.length-1];
            System.arraycopy(temp, 0, array, 0, temp.length);
        }
    }

    static void cycleSwap(int[] array, int shift) {
        if (array != null && array.length != 0) {
            int[] temp = new int[array.length];
            System.arraycopy(array, 0, temp, shift, array.length-shift);
            System.arraycopy(array, array.length-shift, temp, 0, shift);
            System.arraycopy(temp, 0, array, 0, temp.length);
        }
    }
}
