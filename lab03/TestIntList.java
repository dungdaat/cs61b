public class TestIntList {
	public static void main(String[] args){
		IntList L = new IntList(5, new IntList(10, new IntList(15, null)));
	    /**L.first = 5;
	    L.rest = null;

	    L.rest = new IntList();
	    L.rest.first = 10;
	    // IntList p1 = L.rest;

	    L.rest.rest = new IntList();
	    L.rest.rest.first = 15;
	    // IntList p2 = p1.rest;
	    // p1.rest = null;
	    */
	    if (L.get(4) == 12345){
	    	System.out.print("successfully get the 1th element!");
	    }	
	}
}