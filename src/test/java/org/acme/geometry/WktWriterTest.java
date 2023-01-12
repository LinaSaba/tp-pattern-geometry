package org.acme.geometry;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class WktWriterTest {
    public void testWrite(){
        WktWriter writer = new WktWriter();
        List<Point> points = new ArrayList<Point>();
        Point p1 = new Point(new Coordinate(1.0, 2.0));
        Point p2 = new Point(new Coordinate(2.0, 9.0));
        Point p3 = new Point();
        points.add(p1);
        points.add(p2);
        LineString ls1 = new LineString(points);
        LineString ls2 = new LineString();
        Assert.assertEquals("POINT(1.0 2.0)", writer.write(p1));
        Assert.assertEquals("POINT(2.0 9.0)", writer.write(p2));
        Assert.assertEquals("LINESTRING(1.0 2.0,2.0 9.0)", writer.write(ls1));
        Assert.assertEquals("POINT EMPTY", writer.write(p3));
        Assert.assertEquals("LINESTRING EMPTY", writer.write(ls2));
    }
}
