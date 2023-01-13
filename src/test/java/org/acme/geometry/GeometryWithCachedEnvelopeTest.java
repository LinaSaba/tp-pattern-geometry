package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {
    public static final double EPSILON = 1.0e-15;
    @Test
    public void testCachedEnvelope() {
        Point point = new Point(new Coordinate(1.0,2.0));
        Geometry cachedGeometry = new GeometryWithCachedEnvelope(point);
        Envelope a = cachedGeometry.getEnvelope();
        Envelope b = cachedGeometry.getEnvelope();
        Assert.assertSame(a,b);
    }

    @Test
    public void testListener(){
        List<Point> points = new ArrayList<Point>();
        Point point1 = new Point(new Coordinate(1.0,2.0));
        Point point2 = new Point(new Coordinate(3.0,4.0));
        points.add(point1);
        points.add(point2);
        LineString lineString = new LineString(points);
        GeometryWithCachedEnvelope cachedLineString = new GeometryWithCachedEnvelope(lineString);

        Envelope envelope1 = cachedLineString.getEnvelope();
        Assert.assertEquals(1.0, envelope1.getXmin(), EPSILON);

        lineString.translate(10.0, 10.0);
        Envelope envelope2 = cachedLineString.getEnvelope();
        Assert.assertEquals(1.0, envelope2.getXmin(), EPSILON);
    }
}