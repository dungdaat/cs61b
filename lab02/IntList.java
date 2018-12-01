public class IntList {
	public int f;
	public IntList r;
	/* constructor */
	public IntList (int f, IntList r) {
	first = f;
	rest = r;
	}

	/** using recursion */
	public int size(){
		if(!rest){
			return 1;
		}
		return 1+this.rest.size();
	}

	/*using iteration*/
	public int iterativeSize() {
		public p = this;
		public count = 0;
		while (p != null) {
			count += 1;
			p = p.rest;
		}
		return count;
	}
	
	/* get method*/
	public  
	public static void main(String[] args) {

	} 





}
public 