package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    Point start;
    Point end;

    public Segment(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException();
        } else {
            this.start = start;
            this.end = end;
        }
    }

    double length() {
        return sqrt(pow((end.getX() - start.getX()), 2) + pow((end.getY() - start.getY()), 2));
    }

    Point middle() {
        Point p = new Point((end.getX() + start.getX())/2, (end.getY() + start.getY())/2);
        return p;
    }

    Point intersection(Segment another) {
        double k1 = (this.start.getY() - this.end.getY()) / (this.start.getX()-this.end.getX());
        double k2 = (another.start.getY() - another.end.getY()) / (another.start.getX()-another.end.getX());

        if (k1 == k2) {
            return null;
        }

        double b1 = this.start.getY() - k1 * this.start.getX();
        double b2 = another.start.getY() - k2 * another.start.getX();

        double x = (b2 - b1) / (k1 - k2);
        double y = k1 * x + b1;

        if (x <= Math.max(this.start.getX(), this.end.getX())
            && x >= Math.min(this.start.getX(), this.end.getX())
            && x <= Math.max(another.start.getX(), another.end.getX())
            && x >= Math.min(another.start.getX(), another.end.getX())
            && y <= Math.max(this.start.getY(), this.end.getY())
            && y >= Math.min(this.start.getY(), this.end.getY())
            && y <= Math.max(another.start.getY(), another.end.getY())
            && y >= Math.min(another.start.getY(), another.end.getY())) {
            return new Point(x, y);
        }

        return null;
    }

}
