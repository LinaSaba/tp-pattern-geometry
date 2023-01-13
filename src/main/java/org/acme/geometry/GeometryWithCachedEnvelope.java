package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry, GeometryListener {

    Geometry original;
    Envelope cachedEnvelope;

    public GeometryWithCachedEnvelope(Geometry original){
        this.original = original;
        this.cachedEnvelope = original.getEnvelope();
        original.addListener(this);
    }

    public String getType() {
        return original.getType();
    }

    public boolean isEmpty() {
        return original.isEmpty();
    }

    public void translate(double dx, double dy) {
        original.translate(dx, dy);
    }

    public Geometry clone() {
        return new GeometryWithCachedEnvelope(this.original);
    }

    public Envelope getEnvelope() {
        return this.cachedEnvelope;
    }

    public void accept(GeometryVisitor visitor) {
        this.original.accept(visitor);
    }

    public void addListener(GeometryListener listener) {

    }

    public void onChange(Geometry geometry) {
        this.original = geometry;
        this.cachedEnvelope = geometry.getEnvelope();
    }
}