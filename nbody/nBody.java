public class NBody {
	public static int readN(String filename) {
		In readR = new In(filename);
		int First = readR.readInt();
		return First;
	}
	public static double readRadius(String filename) {
		In readR = new In(filename);
		int First = readR.readInt();
		double Radius = readR.readDouble();
		return Radius;
	}
	public static Planet[] readPlanets(String filename) {
		In readP = new In(filename);
		int First = readP.readInt();
		double Radius = readP.readDouble();
		Planet[] planetList = new Planet[First];
		int count = 0;
		while (count != First) {
			double xxPos = readP.readDouble();
			double yyPos = readP.readDouble();
	 		double xxVel = readP.readDouble();
			double yyVel = readP.readDouble();
	 		double mass = readP.readDouble();
	 		String imgFileName = readP.readString();
	 		planetList[count] = new Planet(xxPos, yyPos, xxVel, 
		yyVel, mass, imgFileName);
	 		count += 1;
		}
		return planetList;
	}
	public static void main(String[] args) {
		Double T = Double.valueOf(args[0]);
		Double dt = Double.valueOf(args[1]);
		String filename = args[2];
		Planet[] planetList = readPlanets(filename);
		double radius = readRadius(filename);
		
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0,0,"images/starfield.jpg");
		for (Planet p : planetList){
			p.draw();
		}
		StdDraw.show();

		StdDraw.enableDoubleBuffering();
		int numPlanets = readN(filename);
		for (double t = 0; t < T; t += dt){
			double[] xForce = new double[numPlanets];
			double[] yForce = new double[numPlanets];
			for(int i=0; i<numPlanets; i+=1){
				xForce[i] = planetList[i].calcNetForceExertedByX(planetList);
				yForce[i] = planetList[i].calcNetForceExertedByY(planetList);
			}
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(int i=0; i<numPlanets;i+=1) {
				planetList[i].update(dt, xForce[i], yForce[i]);
				planetList[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10); 
		}
	}
}



		



/*
public class NBody{
	public static double readRadius(String x){
		In in=new In(x);
		int numPlanets = in.readInt();
		double radius = in.readDouble();
		return radius;
		
	}

	
	public static Planet [] readPlanets(String x){
		 In in=new In(x);
		 int numPlanets = in.readInt();
		 double radius = in.readDouble();
		 Planet [] planets =new Planet[numPlanets];
		 for (int i=0;i<numPlanets;i++){
		 	double xxPos=in.readDouble();
		 	double yyPos=in.readDouble();
		 	double xxVel=in.readDouble();
		 	double yyVel=in.readDouble();
		 	double m=in.readDouble();
		 	String img=in.readString();
		 	planets[i] = new Planet(xxPos, yyPos,xxVel,yyVel,m,img);
		 }
		 return planets;
	}
	public static void main (String[] args){
		double T= Double.parseDouble(args[0]);
		double dT= Double.parseDouble(args[1]);
		String filename=args[2];
		String background="./images/starfield.jpg";
		double radius=readRadius("./data/planets.txt");
		In in=new In("./data/planets.txt");
		int numPlanets=in.readInt();
		StdDraw.setScale(-radius,radius);
		StdDraw.picture(0,0,background);
		Planet [] x = readPlanets("./data/planets.txt");
		for (int i=0;i<numPlanets;i++){
			x[i].draw();
		}
		StdAudio.play("./audio/2001.mid");
		double time=0;
		Planet[] allplanets=x;
		while (time<T){
			double [] xForces=new double [numPlanets];
			double [] yForces=new double [numPlanets];;
			allplanets=x;
			for (int j=0;j<numPlanets;j++){
				xForces[j]=allplanets[j].calcNetForceExertedByX(allplanets);
				yForces[j]=allplanets[j].calcNetForceExertedByY(allplanets);

			}

			for (int j=0;j<numPlanets;j++){
				allplanets[j].update(dT,xForces[j],yForces[j]);
			}

			StdDraw.picture(0,0,background);
			for (int i=0;i<numPlanets;i++){
			x[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time+=dT;
		}
		StdOut.printf("%d\n", allplanets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < allplanets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
   			allplanets[i].xxPos, allplanets[i].yyPos, allplanets[i].xxVel, allplanets[i].yyVel, allplanets[i].mass, allplanets[i].imgFileName);	
			}		
	}

}
*/