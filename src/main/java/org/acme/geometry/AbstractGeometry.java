package org.acme.geometry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {

    private List<GeometryListener> geometryListeners;

    protected AbstractGeometry(){
        this.geometryListeners = new ArrayList<>();
    }

    public abstract Geometry clone();
    public String asText() {
        WktVisitor wktVisitor = new WktVisitor();
        this.accept(wktVisitor);
        return wktVisitor.getResult();
    }
    public Envelope getEnvelope(){
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
        this.accept(envelopeBuilder);
        return envelopeBuilder.build();
    }

    public void addListener(GeometryListener geometryListener){
        this.geometryListeners.add(geometryListener);
    }

    protected void triggerChange(){
        for (GeometryListener geometryListener : geometryListeners) {
            geometryListener.onChange(this);
        }
    }

}