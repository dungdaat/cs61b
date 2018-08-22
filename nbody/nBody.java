public class NBody {
	public static double readRadius(String filename) {
		In readR = new In(filename);
		int First = readR.readInt();
		double Radius = readR.readDouble();
		return Radius;
	}
	public static Planet[] readPlanets(String filename) {
		Planet[] planetList = new Planet[5];
		In readP = new In(filename);
		int First = readP.readInt();
		double Radius = readP.readDouble();
		int count = 0;
		while (count !=5) {
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
}