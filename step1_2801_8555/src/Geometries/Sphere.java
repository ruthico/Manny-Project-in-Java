package Geometries;
import Primitives.*;
//Neomi Mayer 328772801 Ruty Cohen 98508555
import java.awt.*;
import java.util.LinkedList;


public class Sphere extends Geometry {
double _radius;
Point3D _center;

    public Sphere() {
        super();
        this._radius = 1;
        this._center = new Point3D();
    }
    public Sphere(double _radius, Point3D _center,Color emmision) {
        super(emmision);
        this._radius = _radius;
        this._center = new Point3D(_center);
    }
    public Sphere(Sphere sphere) {
        super(sphere.emmision);
        this._radius =sphere._radius;
        this._center =new Point3D(sphere._center);

    }

    public double get_radius() {
        return _radius;
    }

    public void set_radius(double _radius) {
        this._radius = _radius;
    }

    public Point3D get_center() {
        return new Point3D( _center);
    }

    public void set_center(Point3D _center) {
        this._center = new Point3D( _center);
    }
    @Override
    public boolean equals(Object o) {
        Sphere sphere = (Sphere) o;
        return _radius==sphere._radius&&_center.equals(sphere._center)
                && emmision.getRGB()==sphere.emmision.getRGB();

    }

    @Override
    public String toString() {
        return "Sphere{" +
                "Radius=" + _radius +
                ", Center=" + _center.toString() +
                ", Emmision=" + emmision +
                '}';
    }
    public Vector getNormal(Point3D point3D)
    {
        Vector v=new Vector(_center);
        Point3D sub=new Point3D(point3D);
        sub.Subtract(v);
        Vector normal=new Vector(sub);
        normal.normalize();
        return normal;
    }
    public LinkedList<Point3D> findIntersections(Ray ray)
    {
        LinkedList<Point3D> intersections=new LinkedList<Point3D>();
        Point3D p0=new Point3D(); //(0,0,0) center of the camera
        Point3D O=new Point3D(_center); //the center of the circle
        O.Subtract(new Vector(p0)); //O-p0
        Vector L=new Vector(O); //L=O-p0
        Vector V=new Vector(ray.get_direction()); //v=the direction of the ray
        double tm=L.dotProduct(V); //tm=L.V
        double d=Math.sqrt(Math.pow(L.length(),2)-Math.pow(tm,2)); //d=(|L|^2-tm^2)^0.5
        double r=_radius; //the radious of the sphere
        if(d>r) //if the length of d is bigger then r
        return intersections; //return an empty list- no intersections
        else if(d==r) //if there is only one intersetion
            {
                V.scale(tm); //tm*V -the vector that cuts the sphere in one place
                p0.add(V); //(0,0,0)+tmV - the point that hits the sphere
                intersections.add(p0);
            }
        else
            {
                double th=Math.sqrt(r*r-d*d);//th=(r^2-d^2)^0.5 - distance from the intersections to O+d
                double t1=tm-th; //the distance frpm p0 to the first intersection
                double t2=tm+th; //the distance frpm p0 to the second intersection
                Vector v1=new Vector(V);
                Vector v2=new Vector(V);
                if(t1>0)
                {
                    v1.scale(t1);// t1V
                    Point3D p1=new Point3D();//(0,0,0) -center of the camera
                    p1.add(v1);
                    intersections.add(p1);
                }
                if(t2>0)
                {
                    v2.scale(t2);// t2V
                    Point3D p2=new Point3D();//(0,0,0) -center of the camera
                    p2.add(v2);
                    intersections.add(p2);
                }

            }
        return intersections;
    }
}
