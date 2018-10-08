import java.util.Arrays;
import java.util.Objects;

public class MaxSuba {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxSuba maxSuba = (MaxSuba) o;
        return Arrays.equals(orgi, maxSuba.orgi);
    }

    public class wrap {

        public int start;
        public int end;
        public int middle;
        public int[] sol;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            wrap wrap = (wrap) o;
            return start == wrap.start &&
                    end == wrap.end &&
                    middle == wrap.middle &&
                    Arrays.equals(sol, wrap.sol);
        }



        /** creat a constructor which wrap all the information we need here */
        public wrap (int i, int j, int k, int[] Aaa){
            start = i;
            middle = j;
            end = k;
            sol = Aaa;

        }
    }

    private int[] orgi;


    public MaxSuba(int[] alist) {
        orgi = alist;
    }

    /** find the cutpoint */
    public static int Devide (int[] orgi) {
        int x = orgi.length;
        if(x%2 == 0){
            return x/2-1;
        }
        int ans = x/2;
        return ans;
    }
    /** construct a method which can find the cross boundary max suba */
    public int[] crossMax (int[] orgi) {
        int cutPoint = Devide(orgi);
        int leffIndex = cutPoint;
        int lLargest = orgi[cutPoint];
        int curr = 0;
        /** left part */
        if (orgi.length == 1) {
            int[] sol =  {0,0,orgi[0]};
            return sol;
        }
        for (int i=cutPoint; i>=0; i--) {
            curr += orgi[i];
            if (curr > lLargest) {
                lLargest = curr;
                if (lLargest>0) {
                    leffIndex = i;
                }
            }
        }
        /** right part */
        curr = 0;
        int rLargest = orgi[cutPoint+1];
        int rightIndex = cutPoint+1;
        for (int i=cutPoint+1; i<=orgi.length-1; i++) {
            curr += orgi[i];
            if (curr > rLargest) {
                rLargest = curr;
                if (rLargest>0) {
                    rightIndex = i;
                }
            }
        }
        int[] sol = {leffIndex, rightIndex, lLargest+rLargest};
        return sol;
    }

    public static wrap compare (wrap... values) {
        if (values[0].sol[2] >= values[1].sol[2]){
            if (values[0].sol[2] >= values[2].sol[2]) {
                return values[0];
            }
            else{return values[2];
            }
        }
        if (values[1].sol[2]<=values[2].sol[2]) {
            return values[2];
        }
        return values[1];
    }
    public wrap findMax() {
        int cut = Devide(orgi);
        int[] left =  Arrays.copyOfRange(orgi, 0, cut+1);
        int[] right = Arrays.copyOfRange(orgi,cut+1, orgi.length);
        wrap cross = new wrap(0,cut,orgi.length-1,crossMax(orgi));

        if (orgi.length == 1) {
            return cross;
        }
        MaxSuba Left = new MaxSuba(left);
        MaxSuba Right = new MaxSuba(right);
        wrap sol = compare(Left.findMax(), cross,Right.findMax());
        return sol;
    }
}


/** where can I improve :
 *inprove the output process when the input length is 1,which takes a large part of the whole recursion and should not take too many stps
 * set up a new avriable/ modify the sol, that takes the changes of the indices of an array as a whole, eg: when i devide an array into two ,
 * the geginning index of the right array is cutpoint but not 0
 */