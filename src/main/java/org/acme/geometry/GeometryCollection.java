package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class GeometryCollection extends AbstractGeometry{
    private List<Geometry> geometries;

    public GeometryCollection(){
        this.geometries = new ArrayList<>();
    }

    public GeometryCollection(List<Geometry> geometries){
        this.geometries = geometries;
    }

    public void add(Geometry geometry){
        this.geometries.add(geometry);
    }

    public void remove(int n){
        this.geometries.remove(n);
    }

    public void remove(Geometry geometry){
        this.geometries.remove(geometry);
    }

    public int getNumGeometries(){
        return this.geometries.size();
    }

    public Geometry getGeometryN(int n){
        return this.geometries.get(n);
    }


    @Override
    public String getType() {
        return "GeometryCollection";
    }

    @Override
    public boolean isEmpty() {
        return (getNumGeometries() == 0);
    }

    @Override
    public void translate(double dx, double dy) {
        for (Geometry geometry : geometries) {
            geometry.translate(dx, dy);
        }
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }

    public Geometry clone() {
        GeometryCollection geometryCollection = new GeometryCollection();
        for (Geometry geometry : this.geometries) {
            Geometry copyGeometry = geometry.clone();
            geometryCollection.add(copyGeometry);
        }
        return geometryCollection;
    }




}