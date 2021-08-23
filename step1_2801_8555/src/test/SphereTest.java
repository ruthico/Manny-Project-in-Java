package test;
//Neomi Mayer 328772801 Ruty Cohen 98508555
import Elements.Camera;
import Geometries.Sphere;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class SphereTest {
//gives us like the normal - almost the same answer but not
      @Test
        public void testGetNormal()
        {
            Sphere s=new Sphere();
            Point3D p=new Point3D(2,0,0);
            Vector normal=s.getNormal(p);
            Vector normaltest= new Vector(1,0,0);
            assertEquals(normal,normaltest);
        }
    @Test
    public void testintersections0() {
          //no points
            Sphere sphere=new Sphere(); //radius is 1
            sphere.set_center(new Point3D(2,2,-2));
        Ray ray = new Ray();
        ray.set_direction(new Vector(Math.sqrt(2),0,0));// (sqrt(2),0,0)
        LinkedList<Point3D> list=new LinkedList<Point3D>();
        list=sphere.findIntersections(ray);
        assertTrue(list.isEmpty());



    }
    @Test
    public void testintersections1() {
        //one point
        Sphere sphere=new Sphere(); //radius is 1
        sphere.set_center(new Point3D(2,2,-2));
        Ray ray = new Ray();
        double x=Math.sqrt(11.0)/2.0;
        ray.set_direction(new Vector(x,0,0));// (sqrt(11)/2,0,0)
        LinkedList<Point3D> list=new LinkedList<Point3D>();
        list=sphere.findIntersections(ray);
        assertFalse(list.isEmpty());
        Point3D p=new Point3D(11/2.0,0,0);
        assertEquals(p,list.get(0));

    }
    @Test
    public void testintersections2() {
        //two points

        Sphere sphere=new Sphere(); //radius is 1
        sphere.set_center(new Point3D(2,2,-2));
        Ray ray = new Ray();
        double x2=Math.sqrt(11.75)/2.0;
        ray.set_direction(new Vector(x2,0,0));// (sqrt(11.75)/2,0,0)
        LinkedList<Point3D> list=new LinkedList<Point3D>();
        list=sphere.findIntersections(ray);
        assertFalse(list.isEmpty());
        double px1=(47-Math.sqrt(141))/8.0;
        double px2=(47+Math.sqrt(141))/8.0;
        Point3D p1=new Point3D(px1,0,0);
        Point3D p2=new Point3D(px2,0,0);
        assertEquals(p1,list.get(0));
        assertEquals(p1,list.get(1));

    }


    }