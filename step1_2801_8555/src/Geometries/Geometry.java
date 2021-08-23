//Neomi Mayer 328772801 Ruty Cohen 98508555
package Geometries;
import Primitives.*;
import Primitives.Vector;

import java.awt.*;
import java.awt.Color.*;
import java.util.LinkedList;

public abstract class Geometry {
    public Color emmision;
    public Geometry() {
        this.emmision = new Color(0,0,0);
    }
    public Geometry(Color emmision) {
        this.emmision = emmision;
    }
    public Geometry(Geometry geometry) {
        this.emmision = new Color(geometry.emmision.getRGB());
    }

    public Color getEmmision() {
        return new Color(emmision.getRGB());
    }

    public void setEmmision(Color emmision) {
        this.emmision = new Color(emmision.getRGB());
    }
    public abstract Vector getNormal(Point3D point3D);
    public abstract LinkedList<Point3D> findIntersections(Ray ray);
}
