package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if( a < 0 ) {
            System.out.println("Seriously? Why so negative?");
        } else if ( a == 0 ) {
            System.out.println("Oh, it looks like there is no one here");
        } else {
            String name = sc.nextLine();
            while ( a-- > 0 ) {
                name = sc.nextLine();
                System.out.println("Hello, " + name);
            }
        }
    }
}
