package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        Scanner sc = new Scanner(System.in);

        int m = Integer.MIN_VALUE;
        int a = 1;

        while (a != 0) {
            a = sc.nextInt();
            if ( a > m && a != 0 ) {
                m = a;
            }
        }

        return m;
    }

    public static void main(String[] args) {



        System.out.println(max());
    }
}
