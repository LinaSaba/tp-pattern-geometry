package org.acme.geometry;

public class WktWriter {

    private String geomString;

    public WktWriter() {
        this.geomString = "";
    }

    public String write(Geometry geometry) throws RuntimeException {
        String type = geometry.getType().toUpperCase();
        if ( geometry instanceof Point ){
            Point point = (Point)geometry;
            if (point.isEmpty()){
                return type + "EMPTY";
            } else {
                return type + "(" + point.getCoordinate().getX() + " " + point.getCoordinate().getY() + ")";
            }
        } else if ( geometry instanceof LineString ) {
            LineString lineString = (LineString) geometry;
            if (lineString.isEmpty()) {
                return type + "EMPTY";
            } else {
                type += "(";
                for (int i = 0; i < lineString.getNumPoints(); i++) {
                    type += lineString.getPointN(i).getCoordinate().getX() + " " + lineString.getPointN(i).getCoordinate().getY() + ",";
                }
                return type.substring(0, type.length() - 1) + ")";

            }
        }else{
            throw new RuntimeException("geometry type not supported");
        }
    }
}
