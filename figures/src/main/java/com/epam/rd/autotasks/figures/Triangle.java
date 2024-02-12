package com.epam.rd.autotasks.figures;

import static java.lang.Math.*;

class Triangle extends Figure{

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double length(Point A, Point B) {
        double length= sqrt(pow(B.getX()-A.getX(),2)+pow(B.getY()-A.getY(),2));
        return length;
    }

    @Override
    public double area(){
        double abLength = length(a, b);
        double bcLength = length(b, c);
        double caLength = length(c, a);

        //using the heron formula
        double p = (abLength+bcLength+caLength)*0.5;
        double area = sqrt(p*(p-abLength)*(p-bcLength)*(p-caLength));
        return area;

    }

    @Override
    public String pointsToString(){
        return "("+a.getX()+","+a.getY()+")"+"("+b.getX()+","+b.getY()+")"+"("+c.getX()+","+c.getY()+")";
    }

    @Override
    public String toString(){
        return "Triangle[("+a.getX()+","+a.getY()+")"+"("+b.getX()+","+b.getY()+")"+"("+c.getX()+","+c.getY()+")]";
    }

    @Override
    public  Point leftmostPoint(){
        double minX = a.getX();
        double minY = a.getY();
        if(b.getX() < minX) minX = b.getX(); minY = b.getY();
        if(c.getX() < minX) minX = c.getX(); minY = c.getY();

        return new Point(minX, minY);
    }
}