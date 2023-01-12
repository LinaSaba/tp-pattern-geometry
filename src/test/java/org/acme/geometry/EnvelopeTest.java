package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor() {
        Coordinate bottomLeft = new Coordinate();
        Coordinate topLeft = new Coordinate();
        Assert.assertNotNull(bottomLeft);
        Assert.assertNotNull(topLeft);
    }
    @Test
    public void testGets() {
        Envelope env = new Envelope();
        Assert.assertTrue(Double.isNaN(env.getXmax()));
        Assert.assertTrue(Double.isNaN(env.getXmin()));
        Assert.assertTrue(Double.isNaN(env.getYmax()));
        Assert.assertTrue(Double.isNaN(env.getYmin()));
    }
    @Test
    public void testConstructor() {
        Envelope env = new Envelope(new Coordinate(1.0,3.0),new Coordinate(2.0,8.0));
        Assert.assertEquals(1.0, env.getXmin(), EPSILON);
        Assert.assertEquals(2.0, env.getXmax(), EPSILON);
        Assert.assertEquals(3.0, env.getYmin(), EPSILON);
        Assert.assertEquals(8.0, env.getYmax(), EPSILON);
    }
}
