public class Planet {
	/* six basic instance variables */
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	/* the first contructor */
	public Planet(double xP, double yP, double xV, 
		double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}
	/* a constructor that takes in a object and makes a copy*/
	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
	public double calcDistance (Planet p1) {
		double xDisPow = Math.pow(this.xxPos - p1.xxPos, 2);
		double yDisPow = Math.pow(this.xxPos - p1.yyPos, 2);
		return Math.sqrt(xDisPow+yDisPow);
	}
	/* declare the class variable */
	public static final double constantG = 6.67e-11;

	public double calcForceExertedBy(Planet p2) {
		double distSquare = Math.pow(calcDistance(p2), 2);
		return constantG*this.mass*p2.mass/distSquare;
	}
	/*calculate the force on x axis */
	public double calcForceExertedByX(Planet p) {
		double xDist = p.xxPos-this.xxPos;
		return calcForceExertedBy(p)*xDist/calcDistance(p);
	}
	/*calculate the force on y axis */
	public double calcForceExertedByY(Planet p) {
		double yDist = p.yyPos-this.yyPos;
		return calcForceExertedBy(p)*yDist/calcDistance(p);
	}
	public double calcNetForceExertedByX(Planet[] allPlanet) {
		double netForceX = 0;
		for (Planet p : allPlanet) {
			netForceX += calcForceExertedByX(p);
		}
		return netForceX;
	}
	public double calcNetForceExertedByY(Planet[] allPlanet) {
		double netForceY = 0;
		for (Planet p : allPlanet) {
			netForceY += calcForceExertedByY(p);
		}
		return netForceY;
	}
	public void update(double tinyTime, double netForceX, double netForceY){
		double acceleX = netForceX/this.mass;
		double acceleY = netForceY/this.mass;
		this.xxVel += acceleX*tinyTime;
		this.yyVel += acceleY*tinyTime;
		this.xxPos += this.xxVel*tinyTime;
		this.yyPos += this.yyVel*tinyTime;
	}
}
















