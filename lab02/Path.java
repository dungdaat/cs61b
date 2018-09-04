/* A class that represents a path via pursuit curves. 
public class Path {
    // TODO
    public Point curr;
    public Point next;

    public Path (double x, double y) {
    	this.curr = new Point(23, 4);
    	this.next = new Point(x, y);
    }
    void iterate(double dx, double dy) {
    	// this.curr = Point(this.next);
    	this.next = Point(this.next.x+dx, this.next.y+dy);
    }
}*/


public class Path {

    
	public Point curr;
    public Point next;

	public Path(double x, double y){
        curr = new Point(20,30);
        next = new Point(x, y);
	}
    public void iterate(double dx, double dy){
        this.curr = new Point(this.next);

        this.next = new Point(this.next.x+dx, this.next.y+dy);
	}
}
