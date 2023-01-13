package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

    private StringBuilder buffer;

    public WktVisitor() {
        buffer = new StringBuilder();
    }

    public String getResult() {
        return buffer.toString();
    }

    @Override
    public void visit(Point point) {
        buffer.append("POINT(");
        buffer.append(point.getCoordinate().getX());
        buffer.append(" ");
        buffer.append(point.getCoordinate().getY());
        buffer.append(")");
    }

    @Override
    public void visit(LineString lineString) {
        buffer.append("LINESTRING(");
        for (int pointIndex = 0; pointIndex < lineString.getNumPoints(); pointIndex++) {
            if (pointIndex != 0) {
                buffer.append(",");
            }
            Point point = lineString.getPointN(pointIndex);
            buffer.append(point.getCoordinate().getX());
            buffer.append(" ");
            buffer.append(point.getCoordinate().getY());
        }
        buffer.append(")");
    }

    @Override
    public void visit(GeometryCollection geometryCollection) {
        if (geometryCollection.isEmpty()){
            this.buffer.append("GEOMETRYCOLLECTION EMPTY");
        } else {
            String r = "GEOMETRYCOLLECTION(";
            for (int i = 0 ; i < geometryCollection.getNumGeometries() ; i++) {
                WktVisitor visitor = new WktVisitor();
                geometryCollection.getGeometryN(i).accept(visitor);
                r += visitor.getResult();
                if (i != geometryCollection.getNumGeometries()-1){
                    r += ",";
                }
            }
            this.buffer.append(r);
        }
    }


}