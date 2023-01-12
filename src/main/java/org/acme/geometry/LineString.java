package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {
    private List<Point> points;

    public LineString() {
        this.points = new ArrayList<>();
    }

    public LineString(List<Point> points) {
        this.points = points;
    }

    @Override
    public String getType() {
        return "LineString";
    }
    @Override
    public boolean isEmpty() {
        return this.points.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        for (Point p : points){
            p.translate(dx,dy);
        }
    }

    public int getNumPoints() {
        return points.size();
    }

    public Point getPointN(int n) {
        return points.get(n);
    }
}