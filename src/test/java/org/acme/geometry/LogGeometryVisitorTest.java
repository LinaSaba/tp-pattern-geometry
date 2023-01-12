package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class LogGeometryVisitorTest {
    @Test
    public void testVisitPoint() {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        Geometry geometry = new Point(new Coordinate(3.0, 4.0));
        geometry.accept(visitor);

        String result = os.toString();

        Assert.assertEquals("C'est un point avec x=3.0 et y=4.0", result.trim());
        // result.trim permet de supprimer les \n et espaces vides
    }

    @Test
    public void testVisitLineString() {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        List<Point> points = new ArrayList<Point>();

        Point point1 = new Point(new Coordinate(1.0,5.0));
        Point point2 = new Point(new Coordinate(8.0,2.0));
        points.add(point1);
        points.add(point2);

        LineString lineString = new LineString(points);
        lineString.accept(visitor);

        String result = os.toString();

        Assert.assertEquals("Je suis une polyligne de 2 points.", result.trim());
        // result.trim permet de supprimer les \n et espaces vides
    }
}