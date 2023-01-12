package org.acme.geometry;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WktVisitorTest {

    @Test
    public void testVisitWithPoint() {
        WktVisitor visitor = new WktVisitor();
        Geometry geometry = new Point(new Coordinate(3.0, 4.0));
        geometry.accept(visitor);
        assertEquals("POINT(3.0 4.0)", visitor.getResult());
    }

    @Test
    public void testVisitWithLineString() {
        WktVisitor visitor = new WktVisitor();
        List<Point> points = new ArrayList<Point>();
        Point p1 = new Point(new Coordinate(1.0, 2.0));
        Point p2 = new Point(new Coordinate(2.0, 9.0));
        points.add(p1);
        points.add(p2);
        LineString ls = new LineString(points);
        ls.accept(visitor);
        assertEquals("LINESTRING(1.0 2.0,2.0 9.0)", visitor.getResult());
    }


}
