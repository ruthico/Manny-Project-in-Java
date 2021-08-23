package test;
//Neomi Mayer 328772801 Ruty Cohen 98508555
import Geometries.Plane;
import Primitives.Point3D;
import Primitives.*;
import org.junit.Test;
import java.awt.*;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class PlaneTest {
    @Test
    public void testGetNormal() {

        Plane p=new Plane(new Point3D(1,2,3), new Vector(2,3,4),new Color(0,0,0));
        Vector normal=p.getNormal(new Point3D());
        Vector normaltest=new Vector(2,3,4);
        assertEquals(normal,normaltest);
    }
    @Test
    public void testintersections() {
       //this plane is behind the camera - and so t<0 so no intersecitons
        double t=5;
        Ray ray=new Ray(new Point3D(),new Vector(0,20,-1));
        Plane plane =new Plane(new Point3D(0,0,5),new Vector(0,0,-1),new Color(0,0,0));
        LinkedList<Point3D> list=new LinkedList<Point3D>();
        list=plane.findIntersections(ray);
        assertTrue(list.isEmpty());
//        Point3D test=new Point3D(list.get(0));
  //      Point3D p=new Point3D(0,0,-5);
    //    assertNotNull(test);
      //  assertEquals(p,test);


        double t2=5;
        Ray ray2=new Ray(new Point3D(),new Vector(0,0,-1));
        Plane plane2 =new Plane(new Point3D(10,20,-5),new Vector(0,0,1),new Color(0,0,0));
        LinkedList<Point3D> list2=new LinkedList<Point3D>();
        list2=plane2.findIntersections(ray2);
        assertFalse(list2.isEmpty());
        Point3D test2=new Point3D(list2.get(0));
        Point3D p2=new Point3D(0,0,-5);
         assertNotNull(test2);
        assertEquals(p2,test2);
        //what happens if there is an infinite amount of intersections?
    }


}