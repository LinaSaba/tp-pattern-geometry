package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder implements GeometryVisitor{
    List<Double> xVals;
    List<Double> yVals;

    public EnvelopeBuilder(){
        this.xVals = new ArrayList<Double>();
        this.yVals = new ArrayList<Double>();
    }
    public void insert(Coordinate coordinate) {
        this.xVals.add(coordinate.getX());
        this.yVals.add(coordinate.getY());
    }
    public Envelope build(){
        Coordinate bottomLeft = new Coordinate(Collections.min(xVals), Collections.min(yVals));
        Coordinate topLeft = new Coordinate(Collections.max(xVals), Collections.max(yVals));
        return new Envelope(bottomLeft, topLeft);
    }
    public void visit(Point point) {
        insert(point.getCoordinate());
    }

    public void visit(LineString lineString) {
        for(int i = 0 ; i < lineString.getNumPoints() ; i++){
            insert(lineString.getPointN(i).getCoordinate());
        }
    }

    @Override
    public void visit(GeometryCollection geometryCollection) {
        for (int i = 0 ; i < geometryCollection.getNumGeometries() ; i++){
            Coordinate coordinate1 = new Coordinate( geometryCollection.getEnvelope().getXmin() , geometryCollection.getEnvelope().getYmin());
            Coordinate coordinate2 = new Coordinate( geometryCollection.getEnvelope().getXmax() , geometryCollection.getEnvelope().getYmax());
            insert(coordinate1);
            insert(coordinate2);
        }
    }
}
