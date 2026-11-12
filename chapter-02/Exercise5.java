//Exercise 5. Add methods translate and scale to Point record. The translate method moves the point by a given amount in x- and y- direction. The scale method scales both coordinates by a given factor. Implement these methods so tha they return new points with the results.

import java.util.Date;

public class Exercise5 {
    public static void main(String[] args) {
        var p = new Point(3, 4);
        System.out.println("Coordinates of p: " + p.x() + " " + p.y());
        
        Point q = p.Translate(-2, 2);
        System.out.println("Coordinates of q: " + q.x() + " " + q.y());

        Point t = p.Scale(10, -5);
        System.out.println("Coordinates of t: " + t.x() + "" + t.y());
    }
}


record Point(double x, double y) {
	// A custom constructor
	public Point() {
		this(0, 0);
	}

    public Point Translate(double x, double y){
		return new Point(this.x+x, this.y+y);
	}

    public Point Scale(double x, double y){
		return new Point(this.x*x, this.y*y);
	}
}




