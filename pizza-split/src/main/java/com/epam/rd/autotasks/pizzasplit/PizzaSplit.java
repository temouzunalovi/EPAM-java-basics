package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = a;
        int nsd;

        do {
            nsd = a % b;
            a = b;
            b = nsd;
        } while (nsd != 0);

        System.out.println((int) (k/a));

    }
}
