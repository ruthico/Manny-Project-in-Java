package Geometries;

import Primitives.*;
//Neomi Mayer 328772801 Ruty Cohen 98508555
import java.awt.*;
import java.util.LinkedList;
import java.util.Objects;


public class Plane extends Geometry{
    Point3D _p;
    Vector _normal;

    public Plane() {
        super();
       // emmision=new Color(0,0,0);
        this._p = new Point3D();
        this._normal = new Vector();
    }

    public Plane(Point3D _p, Vector _normal,Color emmision) {
        //emmision=new Color(color.getRGB());
        super(emmision);
        this._p = new Point3D(_p);
        this._normal = new Vector(_normal);
    }
    public Plane(Plane plane) {
        super(plane.emmision);
        //emmision=new Color(plane.emmision.getRGB());
        this._p = new Point3D(plane._p);
        this._normal = new Vector(plane._normal);
    }

    public Point3D get_p() {
        return new Point3D(_p);
    }

    public void set_p(Point3D _p) {
        this._p = new Point3D(_p);
    }

    public Vector get_normal() {
        return new Vector(_normal);
    }

    public void set_normal(Vector _normal) {
        this._normal =new Vector(_normal);
    }

    @Override
    public boolean equals(Object o) {
        Plane plane = (Plane) o;
        return _p.equals(plane._p) &&
                _normal.equals(plane._normal) && emmision.equals(plane.emmision);
        //need to check if equals on color is by vlaue or reference
    }

    @Override
    public String toString() {
        return "Plane{" +
                "Point" + _p.toString() +
                ", Normal" + _normal.toString() +
                ", Emmision=" + emmision +
                '}';
        //check emission tostring
    }

    public Vector getNormal(Point3D point3D)
    {
        return new Vector(_normal);
    }
    //we need to check if p0 is 000 or it is from the ray we get
    public LinkedList<Point3D> findIntersections(Ray ray)
    {
        LinkedList<Point3D> intersections=new LinkedList<Point3D>();
        double t;
        Vector N=new Vector(_normal); //normal of the plane
        Point3D p0= new Point3D(); //(0,0,0)- the center of the camera
        Point3D Q=new Point3D(_p); // Q is the point of the plane
        Vector V=new Vector(ray.get_direction()); //direction of the camera ray from (0,0,0)
        Vector p0q= new Vector(); //for now (0,0,0)
        p0q.subtract(new Vector(Q)); //p0q= p0-Q =(0,0,0)-Q (Q is the point on the plane)
        double nv=N.dotProduct(V); //N . V between normalof plane and vector direction of camera ray
        N.scale(-1); //N= -N
        t=N.dotProduct(p0q)/nv; //t= -N . (p0-Q)/(N.V)
        //if t<0 then there is no intersection
        V.scale(t); //tV
        p0.add(V); //(0,0,0)+tV
        if(t>=0)
            intersections.add(p0);
       /*
        V.scale(t);
        p0.add(V);
        p0q.add(V);
        if(N.dotProduct(p0q)==0)
            intersections.add(p0);
            */
        return intersections;
    }
}
