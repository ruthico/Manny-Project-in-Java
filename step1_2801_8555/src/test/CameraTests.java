package test;

import org.junit.Test;

import static org.junit.Assert.*;

//Neomi Mayer 328772801 Ruty Cohen 98508555
import Geometries.Plane;
import Primitives.*;
import Elements.Camera;
import org.junit.Test;
import java.awt.*;


public class CameraTests {
    @Test
    public void testRayConstruction () {

        Camera camera=new Camera();
        int Nx=3,Ny=3;
        double x=3,y=3,screenDist=100,screenWidth=150,screenHeight=150;
        double ans=1/(Math.sqrt(3));
        //Ray fromPixel=new Ray(new Point3D(),new Vector(ans,-ans,-ans));
        Ray fromPixel=new Ray(new Point3D(),new Vector(50,-50,-100));
        Ray TestRay=camera.constructRayTroughPixel(Nx,Ny,x,y,screenDist,screenWidth,screenHeight);
        assertEquals(fromPixel,TestRay);


    }

}