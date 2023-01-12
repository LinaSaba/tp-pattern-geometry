package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    public static final double EPSILON = 1.0e-15;

	@Test
    public void testDefaultConstructor() {
        Point p = new Point(new Coordinate(0.0, 0.0));
        Assert.assertEquals(0.0, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(0.0, p.getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testConstructorCoordiante() {
        Coordinate c = new Coordinate(13.0, 14.0);
        Assert.assertEquals(13.0, c.getX(), EPSILON);
        Assert.assertEquals(14.0, c.getY(), EPSILON);
    }
    
    @Test
    public void testGetType() {
        Point p = new Point();
        Assert.assertEquals("Point", p.getType());
    }

    @Test
    public void testisEmpty() {
        Point p1 = new Point(new Coordinate(10.0, 15.2));
        Assert.assertFalse(p1.isEmpty());
        Point p2 = new Point(new Coordinate(Double.NaN,Double.NaN));
        Assert.assertTrue(p2.isEmpty());
    }

    @Test
    public void testTranslate() {
        Point p = new Point(new Coordinate(1.2,2.3));
        p.translate(3.0,4.0);
        Assert.assertEquals(4.2, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(6.3, p.getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testClone() {
        Point point = new Point(new Coordinate(1.0,2.0));
        Point clonePoint = (Point) point.clone();
        Assert.assertEquals(point.getCoordinate(), clonePoint.getCoordinate());
        Assert.assertNotSame(point, clonePoint);
    }

    @Test
    public void testEnvelope() {
        Point p = new Point(new Coordinate(1.0,2.0));
        Envelope envelope = p.getEnvelope();
        Assert.assertNotNull(envelope);
        Assert.assertEquals(1.0, envelope.getXmin(), EPSILON);
        Assert.assertEquals(1.0, envelope.getXmax(), EPSILON);
        Assert.assertEquals(2.0, envelope.getYmin(), EPSILON);
        Assert.assertEquals(2.0, envelope.getYmax(), EPSILON);
    }
}