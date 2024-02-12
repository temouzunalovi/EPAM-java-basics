package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = 1;
        int sum = 0, c = -1;

        while (a != 0) {
            a = scanner.nextInt();
            sum += a;
            c++;
        }

        System.out.println((int) (sum/c));

    }

}