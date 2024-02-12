package com.epam.rd.autotasks;

import java.util.Arrays;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] res = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            Arrays.fill(res[i], 0);
        }
        int x = 0, y = 0;
        int direct = 1;
        for (int t = 1; t <= rows * columns; t++) {
            res[y][x]=t;
            switch (direct) {
                case 1:
                    if(x == columns - 1 || res[y][x+1] != 0) {
                        direct = 2;
                        y++;
                    } else {
                        x++;
                    }
                    break;
                case 2:
                    if(y == rows - 1 || res[y+1][x] != 0) {
                        direct = 3;
                        x--;
                    } else {
                        y++;
                    }
                    break;
                case 3:
                    if(x == 0 || res[y][x-1] != 0) {
                        direct = 4;
                        y--;
                    } else {
                        x--;
                    }
                    break;
                case 4:
                    if(y == 0 || res[y-1][x] != 0) {
                        direct = 1;
                        x++;
                    } else {
                        y--;
                    }
                    break;
            }
        }
        return res;
    }
}
