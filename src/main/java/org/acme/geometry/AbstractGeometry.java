package org.acme.geometry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {

    public String asText() {
        WktVisitor wktVisitor = new WktVisitor();
        this.accept(wktVisitor);
        return wktVisitor.getResult();
    }
    public abstract Geometry clone();

}