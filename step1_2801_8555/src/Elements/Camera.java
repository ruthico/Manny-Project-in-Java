package Elements;
import Primitives.*;
//our normalize doesnt work properly.

public class Camera
{
    Point3D _P0;
    Vector _VUp,_VTo,_VRight;

    public Camera() {
        this._P0 = new Point3D();
        this._VUp = new Vector(0,1,0);
        this._VTo = new Vector(0,0,-1);
        this._VRight = new Vector(1,0,0);
    }
    public Camera(Point3D _P0, Vector _VUp, Vector _VTo, Vector _VRight) {
        this._P0 = new Point3D(_P0) ;
        this._VUp = new Vector(_VUp);
        this._VTo =new Vector(_VTo);
        this._VRight = new Vector(_VRight);
    }
    public Camera(Camera camera) {
        this._P0 = new Point3D(camera._P0) ;
        this._VUp = new Vector(camera._VUp);
        this._VTo =new Vector(camera._VTo);
        this._VRight = new Vector(camera._VRight);
    }

    public Point3D get_P0() {
        return new Point3D(_P0);
    }

    public void set_P0(Point3D _P0) {
        this._P0 = new Point3D(_P0);
    }

    public Vector get_VUp() {
        return new Vector(_VUp);
    }

    public void set_VUp(Vector _VUp) {
        this._VUp = new Vector(_VUp);
    }

    public Vector get_VTo() {
        return new Vector(_VTo);
    }

    public void set_VTo(Vector _VTo) {
        this._VTo = new Vector(_VTo);
    }

    public Vector get_VRight() {
        return new Vector(_VRight);
    }

    public void set_VRight(Vector _VRight) {
        this._VRight = new Vector(_VRight);
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Camera obj1=(Camera) obj;
        return this._P0.equals(obj1._P0) &&
                this._VUp.equals(obj1._VUp)&&
                this._VTo.equals(obj1._VTo)&&
                this._VRight.equals(obj1._VRight)
                ;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "P0:" + _P0.toString() +
                ", VUp:" + _VUp.toString() +
                ", VTo:" + _VTo.toString() +
                ", VRight:" + _VRight.toString() +
                '}';
    }

    public Ray constructRayTroughPixel(int Nx, int Ny, double x, double y, double screenDist, double screenWidth, double screenHeight){
        Point3D p0=new Point3D(_P0);
        Vector vto=new Vector(_VTo);
        vto.scale(screenDist);
        p0.add(vto);
        Point3D Pc=new Point3D(p0);
        double Rx=screenWidth/Nx, Ry=screenHeight/Ny;
        Vector vright=new Vector(_VRight);
        Vector vup=new Vector(_VUp);
        double scaleVright=(x-Nx/2.0)*Rx-Rx/2;
        double scaleVup=(y-Ny/2.0)*Ry-Ry/2;
        vright.scale(scaleVright);
        vup.scale(scaleVup);
        vright.subtract(vup);
        Pc.add(vright);
        Pc.Subtract(new Vector( _P0));
        Vector vray=new Vector(Pc);
       // vray.normalize();
        return new Ray(new Point3D(),vray);
    }
}
