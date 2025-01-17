package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry {
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

    @Override
    public LineString clone() {
        return new LineString(this.points);
    }

    @Override
    public Envelope getEnvelope() {
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
        for (Point p: points){
            envelopeBuilder.insert(p.getCoordinate());
        }
        return envelopeBuilder.build();
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }


    public int getNumPoints() {
        return points.size();
    }

    public Point getPointN(int n) {
        return points.get(n);
    }
}