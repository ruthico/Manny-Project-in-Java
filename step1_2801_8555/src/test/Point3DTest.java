package test;
//Neomi Mayer 328772801 Ruty Cohen 98508555
import Primitives.Point3D;
import Primitives.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class Point3DTest {

    @Test
    public void testAdd() {
        Vector v1=new Vector(10,20,30);
        Point3D p1=new Point3D(10,20,30);
        Point3D p2=new Point3D(20,40,60);
        p1.add(v1);
        assertEquals(p1,p2);
    }

    @Test
    public void testSubtract() {
        Vector v1=new Vector(10,20,30);
        Point3D p1=new Point3D(10,20,30);
        Point3D p2=new Point3D(0,0,0);
        p1.Subtract(v1);
        assertEquals(p1,p2);

    }
}