package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private Point center;
    private double radius;

    public Circle(Point center, double radius){
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area(){
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public String pointsToString(){
        return "("+ center.getX()+","+center.getY()+")";
    }

    @Override
    public String toString(){
        return "Circle[("+ center.getX()+","+center.getY()+")"+radius+"]";
    }

    @Override
    public  Point leftmostPoint(){
        double minY = center.getY();
        double minX = center.getX() - radius;
        return new Point(minX, minY);
    }
}