package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class EnvelopeBuilderTest {
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor() {
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
        Assert.assertNotNull(envelopeBuilder.xVals);
        Assert.assertNotNull(envelopeBuilder.yVals);
    }

    @Test
    public void testinsert(){
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
        Coordinate c = new Coordinate(2.0,3.0);
        envelopeBuilder.insert(c);
        Assert.assertEquals(2.0, envelopeBuilder.xVals.get(0), EPSILON);
        Assert.assertEquals(3.0, envelopeBuilder.yVals.get(0), EPSILON);
    }
    @Test
    public void testBuild(){
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
        envelopeBuilder.insert(new Coordinate(1.0,8.0));
        envelopeBuilder.insert(new Coordinate(6.0,2.0));
        Envelope envelope = envelopeBuilder.build();
        Assert.assertNotNull(envelope);
        Assert.assertEquals(1.0, envelope.getXmin(), EPSILON);
        Assert.assertEquals(6.0, envelope.getXmax(), EPSILON);
        Assert.assertEquals(2.0, envelope.getYmin(), EPSILON);
        Assert.assertEquals(8.0, envelope.getYmax(), EPSILON);
    }
}
