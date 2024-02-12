package com.epam.rd.autotasks.arrays;

import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;

public class SumOfEvenNumbers {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 8, 15, 199};

        System.out.println(sum(array));
    }

    public static int sum(int[] array){

        int s = 0;

        if(array != null) {
            for(int i = 0; i < array.length; i++) {
                if (array[i]%2==0) {
                    s+=array[i];
                }
            }
        }

        return s;
    }
}
