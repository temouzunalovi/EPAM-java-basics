package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){

        int l = array.length;
        int k = 0;

        int[] temp = new int[l];
        System.arraycopy(array, 0, temp, 0, l);

        if(array[0] > array[1]) {
            temp[0] = Integer.MIN_VALUE;
            k++;
        }

        if(array[l-1] > array[l-2]) {
            temp[l-1] = Integer.MIN_VALUE;
            k++;
        }

        for(int i = 1; i < l - 1; i++) {
            if(array[i] > array[i-1] && array[i] > array[i+1]) {
                temp[i] = Integer.MIN_VALUE;
                k++;
            }
        }

        int j = 0;
        int[] res = new int[l-k];

        for (int i = 0; i < l-k; i++) {
            for (; j < l; j++) {
                if(temp[j]!=Integer.MIN_VALUE) {
                    res[i] = temp[j];
                    temp[j]=Integer.MIN_VALUE;
                    break;
                }
            }
        }

        return res;
    }
}
