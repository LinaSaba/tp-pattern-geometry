package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {

	public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor() {
        LineString ls = new LineString();
        Assert.assertEquals(0.0, ls.getNumPoints(), EPSILON);
    }

    @Test
    public void testConstructorPoints() {
        Point p1 = new Point(new Coordinate(0.0, 1.02));
        Point p2 = new Point(new Coordinate(3.0, 5.02));
        List<Point> p = new ArrayList<>();
        p.add(p1);
        p.add(p2);
        LineString ls = new LineString(p);
        Assert.assertEquals(2, ls.getNumPoints());
    }

	@Test
    public void testGetType() {
        LineString lineString = new LineString();
        Assert.assertEquals("LineString", lineString.getType());
    }


    @Test
    public void testGetNumPoints() {
        List<Point> points = new ArrayList<Point>();
		Coordinate c1 = new Coordinate(10.0, 15.2);
		Coordinate c2 = new Coordinate(2.0, 19.2);
        points.add(new Point(c1));
        points.add(new Point(c2));
        LineString lineString = new LineString(points);
        Assert.assertEquals(2, lineString.getNumPoints());
    }

    @Test
    public void testGetPointN() {
        List<Point> points = new ArrayList<Point>();
        Point p1 = new Point(new Coordinate(10.0, 15.2));
        Point p2 = new Point(new Coordinate(2.0, 19.2));
        points.add(p1);
        points.add(p2);
        LineString lineString = new LineString(points);
        Assert.assertSame(p1, lineString.getPointN(0));
        Assert.assertSame(p2, lineString.getPointN(1));
    }

    @Test
    public void testTranslate(){
        List<Point> points = new ArrayList<Point>();
        Point point1 = new Point(new Coordinate(1.0,2.0));
        Point point2 = new Point(new Coordinate(3.0,4.0));
        points.add(point1);
        points.add(point2);
        LineString ls = new LineString(points);
        ls.translate(2.0,3.0);
        // controle premier point
        {
            Coordinate c1 = ls.getPointN(0).getCoordinate();
            Assert.assertEquals(3.0,c1.getX(), EPSILON);
            Assert.assertEquals(5.0,c1.getY(), EPSILON);
        }
        // controle deuxieme point
        {
            Coordinate c2 = ls.getPointN(1).getCoordinate();
            Assert.assertEquals(5.0,c2.getX(), EPSILON);
            Assert.assertEquals(7.0,c2.getY(), EPSILON);
        }
    }
    @Test
    public void testClone() {
        List<Point> points = new ArrayList<Point>();
        Point point1 = new Point(new Coordinate(1.0,2.0));
        Point point2 = new Point(new Coordinate(3.0,4.0));
        points.add(point1);
        points.add(point2);
        LineString ls = new LineString(points);
        LineString clone_ls = (LineString) ls.clone();
        Assert.assertEquals(ls.getPointN(0), clone_ls.getPointN(0));
        Assert.assertEquals(ls.getPointN(1), clone_ls.getPointN(1));
        Assert.assertNotSame(ls, clone_ls);
    }

}
