package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {
    private PrintStream out;

    public LogGeometryVisitor(){
        this(System.out);
    }

    public LogGeometryVisitor(PrintStream out){
        this.out = out;
    }
    public void visit(Point point){
        this.out.println("C'est un point avec x=" + point.getCoordinate().getX() + " et y=" + point.getCoordinate().getY());
    }

    public void visit(LineString linestring){
        this.out.println("Je suis une polyligne de " + linestring.getNumPoints() + " points.");
    }

    @Override
    public void visit(GeometryCollection geometryCollection) {
        if (geometryCollection.isEmpty()){
            this.out.println("Je suis une collection de geometries vide");
        } else {
            this.out.println("Je suis une collection de géométries avec " + geometryCollection.getNumGeometries() + " geométries");
        }
    }
}