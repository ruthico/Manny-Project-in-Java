package test;
import java.awt.*;
import java.util.LinkedList;
//Neomi Mayer 328772801 Ruty Cohen 98508555
import Geometries.Plane;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void testGetNormal() {
Triangle triangle=new Triangle(new Point3D(0,0,0),
        new Point3D(1,0,0),
        new Point3D(0,1,0),
        new Color(0,0,0));
Vector normal= triangle.getNormal(new Point3D());
Vector testnormal=new Vector(0,0,1);
        assertEquals(normal,testnormal);
    }


    @Test
    public void testintersections_notInTriangle() {
        Point3D p=new Point3D(50,-50,100);
        Triangle triangle=new Triangle();
        triangle.set_p1(new Point3D(100,-100,200));
        triangle.set_p2(new Point3D(-100,-100,-200));
        triangle.set_p3(new Point3D(0,-100,-200));
        Ray ray=new Ray();
        ray.set_direction(new Vector(50,50,-100));
        LinkedList<Point3D> list=new LinkedList<Point3D>();
        list=triangle.findIntersections(ray);
        assertTrue(list.isEmpty());
    }
    @Test
    public void testintersections_InTriangle() {
        Point3D p=new Point3D(50,-50,100);
        Triangle triangle=new Triangle();
        triangle.set_p1(new Point3D(100,-100,200));
        triangle.set_p2(new Point3D(-100,-100,-200));
        triangle.set_p3(new Point3D(0,-100,-200));
        Ray ray=new Ray();
        ray.set_direction(new Vector(50,-50,-100));
        LinkedList<Point3D> list=new LinkedList<Point3D>();
        list=triangle.findIntersections(ray);
        assertFalse(list.isEmpty());
    }
}