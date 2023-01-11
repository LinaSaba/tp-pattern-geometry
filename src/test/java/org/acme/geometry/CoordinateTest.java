package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		Coordinate c = new Coordinate();
		Assert.assertEquals(0.0, c.getX(), EPSILON);
		Assert.assertEquals(0.0, c.getY(), EPSILON);
	}
	@Test
	public void testConstructorXY(){
		Coordinate c = new Coordinate(10.0, 15.2);
		Assert.assertEquals(10.0, c.getX(), EPSILON);
		Assert.assertEquals(15.2, c.getY(), EPSILON);
	}
	@Test
	public void testGetX() {
		Coordinate c = new Coordinate(2.5, 3.5);
		Assert.assertEquals(2.5, c.getX(), EPSILON);
	}
	@Test
	public void testGetY() {
		Coordinate c = new Coordinate(0.0, 80.0);
		Assert.assertEquals(2.5, c.getY(), EPSILON);
	}

}
