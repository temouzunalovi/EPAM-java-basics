package com.epam.rd.autotasks.triangle;

import static java.lang.Math.*;

class Triangle {

    Point a;
    Point b;
    Point c;

    double z;
    double x;
    double y;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;

        z = sqrt(pow(a.getX()-b.getX(), 2) + pow(a.getY()-b.getY(),2));
        x = sqrt(pow(a.getX()-c.getX(), 2) + pow(a.getY()-c.getY(),2));
        y = sqrt(pow(c.getX()-b.getX(), 2) + pow(c.getY()-b.getY(),2));

        if (z + x <= y || z + y <= x || x + y <= z) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        double p = (z + x + y) / 2 ;
        return sqrt(p*(p-z)*(p-x)*(p-y));
    }

    public Point centroid(){
        return new Point((a.getX()+b.getX()+c.getX())/3,(a.getY()+b.getY()+c.getY())/3);
    }

}
