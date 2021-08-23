package Primitives;
//Neomi Mayer 328772801 Ruty Cohen 98508555
public class Coordinate {
    double _coordinate;

    public Coordinate() {
        this._coordinate =0;
    }
    public Coordinate(double _coordinate) {
        this._coordinate = _coordinate;
    }
    public Coordinate(Coordinate _coordinate) {
        this._coordinate = _coordinate._coordinate;
    }

    public double get_coordinate() {
        return _coordinate;
    }

    public void set_coordinate(double _coordinate) {
        this._coordinate = _coordinate;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Coordinate obj1=(Coordinate) obj;
        return _coordinate==obj1._coordinate;
    }

    @Override
    public String toString() {
        return ""+_coordinate;
    }

    public void add (double coordinate)
    {
        this._coordinate=this._coordinate+coordinate;
    }
    public void Subtract (double coordinate)
    {
        this._coordinate=this._coordinate-coordinate;
    }
}
