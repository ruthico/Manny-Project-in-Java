package Geometries;
import Primitives.*;
//Neomi Mayer 328772801 Ruty Cohen 98508555
import java.awt.*;
import java.util.LinkedList;

public class Triangle extends Geometry {
    Point3D _p1;
    Point3D _p2;
    Point3D _p3;

    public Triangle() {
        super();
        this._p1 = new Point3D();
        this._p2 = new Point3D();
        this._p3 = new Point3D();
    }

    public Triangle(Point3D _p1, Point3D _p2, Point3D _p3,Color emmision) {
        super(emmision);
        this._p1 = new Point3D(_p1);
        this._p2 = new Point3D(_p2);
        this._p3 = new Point3D(_p3);
    }
    public Triangle(Triangle triangle) {
        super(triangle.emmision);
        this._p1 = new Point3D(triangle._p1);
        this._p2 = new Point3D(triangle._p2);
        this._p3 = new Point3D(triangle._p3);
    }

    public Point3D get_p1() {
        return new Point3D(_p1);
    }

    public void set_p1(Point3D _p1) {
        this._p1 = new Point3D(_p1);
    }

    public Point3D get_p2() {
        return new Point3D(_p2);
    }

    public void set_p2(Point3D _p2) {
        this._p2 =new Point3D(_p2);
    }

    public Point3D get_p3() {
        return new Point3D(_p3);
    }

    public void set_p3(Point3D _p3) {
        this._p3 =new Point3D(_p3);
    }
    @Override
    public boolean equals(Object o) {
        Triangle triangle = (Triangle) o;
        return _p1.equals(triangle._p1) &&_p2.equals(triangle._p2) &&_p3.equals(triangle._p3)
                && emmision.getRGB()==triangle.emmision.getRGB();

    }

    @Override
    public String toString() {
        return "Triangle{" +
                "P1=" + _p1.toString() +
                ", P2=" + _p2.toString() +
                ", P3=" + _p3.toString() +
                ", Emmision=" + emmision +
                '}';
    }

    public Vector getNormal(Point3D point3D)
    {
        Vector v1=new Vector(_p2);
        Vector v2=new Vector(_p3);
        v1.subtract(new Vector(_p1));
        v2.subtract(new Vector(_p1));
        Vector normal=new Vector(v1.crossProduct(v2));
        normal.normalize();
        return normal;
    }
    public LinkedList<Point3D> findIntersections(Ray ray)
    {
        LinkedList<Point3D> intersections=new LinkedList<Point3D>();
        Vector Nt=this.getNormal(_p1);//normal of the triangle
        Plane tplane=new Plane(_p1,Nt,new Color(0,0,0)); //the plane that the tirangle is on
        LinkedList<Point3D> list=tplane.findIntersections(ray);
        if(list.isEmpty()) //if there is no intersection with the plane
            return intersections;
        Point3D intersetion=list.get(0); // the intersection with the plane

        //making N1 p1,p2
        Vector V1=new Vector(_p1);//distance between p1 and p0
        Vector V2=new Vector(_p2);//distance between p2 and p0
        V2.crossProduct(V1); //v2= v2 cross v1
        double lengthv2cv1=V2.length(); // |v2 x v1|
        lengthv2cv1=1/lengthv2cv1; // 1/|v2 x v1|
        V2.scale(lengthv2cv1); // N1=(v2 x v1)/|v2 x v1|
        Vector N1=new Vector(V2);

        //making N2 p1 p3
         V1=new Vector(_p1);//distance between p1 and p0
         Vector V3=new Vector(_p3);//distance between p3 and p0
        V3.crossProduct(V1); //v3= v3 cross v1
        double lengthv3cv1=V3.length(); // |v3 x v1|
        lengthv3cv1=1/lengthv3cv1; // 1/|v3 x v1|
        V3.scale(lengthv3cv1); // N2=(v3 x v1)/|v3 x v1|
        Vector N2=new Vector(V3);

        //making N3 p2 p3
        V2=new Vector(_p2);//distance between p2 and p0
        V3=new Vector(_p3);//distance between p3 and p0
        V3.crossProduct(V2); //v3= v3 cross v2
        double lengthv3cv2=V3.length(); // |v3 x v2|
        lengthv3cv2=1/lengthv3cv2; // 1/|v3 x v2|
        V3.scale(lengthv3cv2); // N3=(v3 x v2)/|v3 x v2|
        Vector N3=new Vector(V3);

        Vector p0p1=new Vector(intersetion); // p-p0
        Vector p0p2=new Vector(intersetion); //p-p0
        Vector p0p3=new Vector(intersetion);//p-p0
        double sign1= p0p1.dotProduct(N1);// (p-p0) . N1
        double sign2= p0p2.dotProduct(N2);// (p-p0) . N2
        double sign3= p0p3.dotProduct(N3);// (p-p0) . N3
        if(sign1>0 &&sign2>0 &&sign3>0)
            intersections.add(intersetion);
        if(sign1<0 &&sign2<0 &&sign3<0)
            intersections.add(intersetion);
        //what happens if sign==0?
        if(sign1==0 &&sign2==0 &&sign3==0)
            intersections.add(intersetion);
        return intersections;

    }
}
