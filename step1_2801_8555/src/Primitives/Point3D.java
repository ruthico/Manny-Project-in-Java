package Primitives;
//Neomi Mayer 328772801 Ruty Cohen 98508555
public class Point3D extends Point2D {
    Coordinate _z;

    public Point3D() {
        super();
        this._z = new Coordinate();
    }

    public Point3D(double _x, double _y, double _z) {
        super(_x, _y);
        this._z =new Coordinate(_z);
    }

    public Point3D(Point3D point3D) {
        super(point3D.get_x(),point3D.get_y());
        this._z = new Coordinate(point3D.get_z());
    }

    public double get_z() {
        return _z._coordinate;
    }

    public void set_z(double _z) {
        this._z = new Coordinate(_z);
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Point3D obj1=(Point3D) obj;
        return this.get_x()==obj1.get_x()&&this.get_y()==obj1.get_y()&&this.get_z()==obj1.get_z();
    }

    @Override
    public String toString() {
        //check if it prints the numbers
        return "("+ _x._coordinate +","+_y._coordinate+","+_z._coordinate+ ")";
    }
    public void add (Vector vector)
    {
        this._x.add(vector._head.get_x());
        this._y.add(vector._head.get_y());
        this._z.add(vector._head.get_z());
    }
    public void Subtract (Vector vector)
    {
        this._x.Subtract(vector._head.get_x());
        this._y.Subtract(vector._head.get_y());
        this._z.Subtract(vector._head.get_z());
    }
    public double distance(Point3D point3D)
    {
        return Math.sqrt(Math.pow(this._x._coordinate-point3D._x._coordinate,2)
                +Math.pow(this._y._coordinate-point3D._y._coordinate,2)
                +Math.pow(this._z._coordinate-point3D._z._coordinate,2));
    }
}
