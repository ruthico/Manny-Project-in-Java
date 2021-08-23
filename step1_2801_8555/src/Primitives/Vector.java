package Primitives;
//Neomi Mayer 328772801 Ruty Cohen 98508555
public class Vector {
Point3D _head;

    public Vector() {
        this._head = new Point3D();
    }
    public Vector(double _x, double _y, double _z)
    {
        this._head = new Point3D(_x,_y,_z);
    }
    public Vector(Point3D head)
    {
        this._head = new Point3D(head);
    }
    public Vector(Vector vector) {
        this._head = new Point3D(vector._head);
    }

    public Point3D get_head() {
        return new Point3D(this._head);
    }

    public void set_head(Point3D _head) {
        this._head = new Point3D(_head);
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Vector obj1=(Vector) obj;
        return this._head.equals(obj1._head);
    }

    @Override
    public String toString() {
        return ""+_head.toString()+" -Vector";
    }

    public void add (Vector vector )
    {
        this._head.add(vector);
    }
    public void subtract (Vector vector )
    {
        this._head.Subtract(vector);
    }
    public void scale(double scalingFacor)
    {
        this._head._x._coordinate = this._head._x._coordinate*scalingFacor;
        this._head._y._coordinate = this._head._y._coordinate*scalingFacor;
        this._head._z._coordinate = this._head._z._coordinate*scalingFacor;

    }
    public double length()
    {
        return Math.sqrt(Math.pow(this._head._x._coordinate,2)
                +Math.pow(this._head._y._coordinate,2)
                +Math.pow(this._head._z._coordinate,2));
    }
    public void normalize()
    {
        this.scale((1/this.length()));
    }
    public Vector crossProduct (Vector vector)
    {
        Vector v=new Vector();
        v._head._x._coordinate= (this._head._y._coordinate*vector._head._z._coordinate)
                -(this._head._z._coordinate*vector._head._y._coordinate);
        v._head._y._coordinate= (this._head._z._coordinate*vector._head._x._coordinate)
                -(this._head._x._coordinate*vector._head._z._coordinate);
        v._head._z._coordinate= (this._head._x._coordinate*vector._head._y._coordinate)
                -(this._head._y._coordinate*vector._head._x._coordinate);
        return v;
    }
    public double dotProduct(Vector vector)
    {
return (this._head._x._coordinate*vector._head._x._coordinate)+
        (this._head._y._coordinate*vector._head._y._coordinate)+
        (this._head._z._coordinate*vector._head._z._coordinate);
    }

}
