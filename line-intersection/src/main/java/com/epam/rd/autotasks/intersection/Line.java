package com.epam.rd.autotasks.intersection;

public class Line {

    int k;
    int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        if (this.k == other.k) {
            return null;
        } else {
            int x, y;

            x = (int) ((other.b - this.b) / (this.k - other.k));
            y = this.k * x + this.b;

            Point p = new Point(x, y);
            return p;
        }
    }

}
