package test;
import Primitives.Vector;
import org.junit.Test;
//Neomi Mayer 328772801 Ruty Cohen 98508555
import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void testAdd() {
        Vector v1=new Vector(10,20,30);
        Vector v2=new Vector(10,20,30);
        Vector v3=new Vector(20,40,60);
        v1.add(v2);
        assertEquals(v1,v3);
    }

    @Test
    public void testSubtract() {
        Vector v1=new Vector(10,20,30);
        Vector v2=new Vector(10,20,30);
        Vector v3=new Vector(0,0,0);
        v1.subtract(v2);
        assertEquals(v1,v3);
    }

    @Test
    public void testScale() {
        Vector v1=new Vector(10,20,30);
        Vector v2=new Vector(20,40,60);
        v1.scale(2);
        assertEquals(v1,v2);
    }

    @Test
    public void testLength() {
        Vector v1=new Vector(2,0,0);
        double vLength=v1.length();
        double vtest=2;
        assertEquals(vLength,vtest,0);
    }

    @Test
    public void testNormalize() {
        Vector v1=new Vector(2,0,0);
        Vector v2=new Vector(1,0,0);
        v1.normalize();
        assertEquals(v1,v2);

    }


    @Test
    public void testCrossProduct() {
        Vector v1=new Vector(1,0,0);
        Vector v2=new Vector(0,1,0);
        Vector v3 =new Vector(v1.crossProduct(v2));
        Vector v4=new Vector(0,0,1);
        assertEquals(v3,v4);

    }

    @Test
    public void testdotProduct() {
        Vector v1=new Vector(1,0,0);
        Vector v2=new Vector(0,1,0);
        double vdot=v1.dotProduct(v2);
        double vtest=0;
        assertEquals(vdot,vtest,0);

    }
}