package org.acme.geometry;

public class Point extends AbstractGeometry {

    private Coordinate coordinate;

    public Point(){
        this.coordinate = new Coordinate();
    }
    
    public Point(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    @Override
    public String getType() {
        return "Point";
    }

    @Override
    public boolean isEmpty() {
        return this.coordinate.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        Coordinate coordinate = new Coordinate(this.coordinate.getX() + dx,this.coordinate.getY() + dy);
        this.coordinate = coordinate;
    }

    @Override
    public Point clone() {
        return new Point(this.getCoordinate());
    }

    @Override
    public Envelope getEnvelope() {
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
        envelopeBuilder.insert(this.coordinate);
        return envelopeBuilder.build();
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }


    public Coordinate getCoordinate(){
        return this.coordinate;
    }

}