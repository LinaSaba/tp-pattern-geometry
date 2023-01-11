package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    public static final double EPSILON = 1.0e-15;

	@Test
    public void testDefaultConstructor() {
        Point p = new Point();
        Assert.assertEquals(0.0, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(0.0, p.getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testConstructorCoordiante() {
        Coordinate c = new Coordinate(13.0, 14.0);
        Assert.assertEquals(13.0, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(14.0, p.getCoordinate().getY(), EPSILON);    
    }
    
    @Test
    public void testGetType() {
        Point p = new Point();
        Assert.assertEquals("Point", p.getType());
    }
}
