import java.util.Arrays;
import java.util.Currency;
import java.util.Objects;

import static java.lang.Integer.min;


/** main idea of this algorithm is that, construct a data type that have
 * length of k
 * have method insert, which insert the next element read from the original input in it
 * and should be sorted
 * use binary method to compare and insert
 * when this array is filled and the next element is smaller than the smallest number, is will be ignored
 * i still don't know the input typw
 */
public class kLargest {
    /** find the cutpoint */
    public static int Devide (int[] orgi) {
        int x = orgi.length;
        if(x%2 == 0){
            return x/2-1;
        }
        int ans = x/2;
        return ans;
    }
    int[] Input;
    int K;

    public kLargest(int[] input, int k){
        Input = input;
        K = k;
    }
    public int[] kMerge () {
        if (Input.length == 1) {
            return Input;
        }
         if (Input.length == 2) {
            if (Input[1] < Input[0]){
                return Input;
            }
            int[] sol = {Input[1],Input[0]};
            return sol;
         }
        int CutPoint = Devide(Input);
        int[] left = Arrays.copyOfRange(Input, 0, CutPoint+1);
        int[] right = Arrays.copyOfRange(Input, CutPoint+1, Input.length);
        kLargest Left = new kLargest(left, K);
        kLargest Right = new kLargest(right, K);
        int[] MLeft = Left.kMerge();
        int[] MRight = Right.kMerge();
        int i = 0;
        int j = 0;
        int Size = min(K,Input.length);
        int[] sol = new int[Size];
        while (i <=left.length-1 && j <= right.length-1 && i+j<Size) {
            if (MLeft[i] < MRight[j]){
                sol[i+j] = MRight[j];   /** what if there are some numbers are equal? */
                j++;
            }
            else{
                sol[i+j]= MLeft[i];
                i++;
            }
        }
        if (i == left.length && i+j<=Size){
            for (int jj = j;jj+i<Size;jj++){
                sol[i+j] = MRight[j];
                j++;
            }
        }
        if(j == right.length && i+j<=Size) {
            for (int ii = i; ii+j<Size; ii++) {
                sol[i+j] = MLeft[i];
                i++;
            }
        }
        return sol;
    }
}


