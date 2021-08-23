package Primitives;
//Neomi Mayer 328772801 Ruty Cohen 98508555
public class Point2D {
    Coordinate _x;
    Coordinate _y;

    public Point2D()
    {
        this._x = new Coordinate();
        this._y = new Coordinate();
    }
    public Point2D(double _x, double _y) {
      //  this._x = _x;
       // this._y = _y;
         this._x =new Coordinate(_x);
          this._y =new Coordinate(_y);
    }
    public Point2D(Point2D point2D)
    {
        //make it get
        this._x = new Coordinate(point2D.get_x());
        this._y = new Coordinate(point2D.get_y());
    }

    public double get_x() {
      //  return _x;
        return _x._coordinate;
    }

    public void set_x(double _x) {
      //this._x = _x;
        this._x = new Coordinate(_x);

    }

    public double get_y() {
//        return _y;
        return _y._coordinate;

    }

    public void set_y(double _y) {
//        this._y = _y;
        this._y = new Coordinate(_y);
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Point2D obj1=(Point2D) obj;
        return this._x.equals(obj1.get_x())&&this._y.equals(obj1.get_y());
    }

    @Override
    public String toString() {
        return "("+ _x.toString() +","+_y.toString()+ ")";
    }

}
