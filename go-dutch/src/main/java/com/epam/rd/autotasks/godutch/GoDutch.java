package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int k = sc.nextInt();
        if (a < 0) {
            System.out.println("Bill total amount cannot be negative");
        } else if (k <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            System.out.println( (int) (a * 1.1 / k));
        }
    }
}
