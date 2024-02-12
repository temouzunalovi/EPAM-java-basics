package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int hours = seconds / 3600 % 24;
        seconds %= 3600;
        int minutes = seconds / 60;
        seconds %= 60;
        Date d = new Date();
        d.setHours(hours);
        d.setMinutes(minutes);
        d.setSeconds(seconds);
        SimpleDateFormat sdf = new SimpleDateFormat("H:mm:ss");
        System.out.println(sdf.format(d));

    }
}
