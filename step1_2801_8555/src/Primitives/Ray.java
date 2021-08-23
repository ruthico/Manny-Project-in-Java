package Primitives;
//Neomi Mayer 328772801 Ruty Cohen 98508555
public class Ray {
    Point3D _POO;
    Vector _direction;
    public Ray() {
        this._POO = new Point3D();
        this._direction = new Vector();
    }
    public Ray(Point3D _POO, Vector _direction) {
        this._POO = new Point3D(_POO);
        this._direction = new Vector(_direction);
    }

    public Ray(Ray ray) {
        this._POO = new Point3D(ray._POO);
        this._direction = new Vector(ray._direction);
    }

    public Point3D get_POO() {
        return new Point3D(_POO);
    }

    public void set_POO(Point3D _POO) {
        this._POO = new Point3D(_POO);
    }

    public Vector get_direction() {
        return new Vector(_direction);
    }

    public void set_direction(Vector _direction) {
        this._direction =new Vector(_direction);
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Ray obj1=(Ray) obj;
        return this._POO.equals(obj1._POO) && this._direction.equals(obj1._direction);
    }

    @Override
    public String toString() {
        return "(p"+this._POO.toString()+",d"+this._direction.toString()+")";
    }

}
