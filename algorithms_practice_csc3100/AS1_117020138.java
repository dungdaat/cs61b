import java.lang.System;
import java.util.Arrays;


public class AS1_117020138 {
    private static class intL {
        int inf = Integer.MAX_VALUE;
        int[] box;
        int Size;

        private intL(int k) {
            int[] Box = new int[k];
            Arrays.fill(Box, inf);
            box = Box;
        }

        public intL insert(int i, intL Box) {
            for (int j = 0; j < box.length; j++) {
                if (box[j] <= i) {
                    continue;
                }
                else {
                    for(int k=j; k<box.length; k++){
                        int temp = box[k];
                        box[k] = i;
                        i = temp;
                    }
                    break;
                }
            }
            return Box;
        }
    }

/** this part is the mothod modified from Quick Sort*/
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    /** Return a partition index*/
    public static int KParti(int[] data, int p, int r){
        int pivot = data[r];
        int left = p;
        int right = r;
        while (left < right-1) {
            while(data[left]<=pivot && left<right-1 ) {
                left++;
            }
            while(data[right]>=pivot && left<right-1) {
                right--;
            }
            if(left < right-1) {
                swap(data, left, right);
            }
            else{
                if(data[left]>pivot && data[right]<=pivot){
                    swap(data,left,right);
                }
                if(data[left]>pivot && data[right] > pivot){
                    left -= 1;
                    right -=1;
                }
            }
        }
        swap(data,right,r);
        return left;
    }
/** I included this helper method to make the find function looks neat :)  all cases are handled here*/
    public static int helper(int[] data, int l, int r, int k){
        if(k == 1){
            int currS = data[l];
            for(int i = l; i<=r; i++){
                if (data[i] < currS){
                    currS = data[i];
                }
            }
            return currS;
        }
        if (k == l-r+1) {
            int currL = data[l];
            for(int i = l; i<=r; i++) {
                if (data[i] > currL) {
                    currL = data[i];
                }
            }
            return currL;
        }
        if (false) {     /** this part is intended to be modified */
            intL inSort = new intL(k);
            for (int i = l; i <=r; i++) {
                inSort.insert(data[i], inSort);
            }
            return inSort.box[k-1];
        }
        int partiPoint = KParti(data,l,r);
        if (partiPoint-l+1 == k-1) {
            return data[partiPoint+1];
        }
        if (partiPoint-l > k-2) {
            return helper(data,l,partiPoint,k);
        }
        return helper(data,partiPoint+1,r,k-partiPoint+l-1);
    }

    public static int find(int k, int[]data) {
        return helper(data,0,data.length-1,k);
    }

    public static void main(String[] args){
        String data_path = "/Users/lidongda/3100_test/test2.txt";
        In readData = new In(data_path);
        int Size = 20000000;
        int[] data = new int[Size];
        /** this part read the data from an external path and construct a list with
         * size 20,000,000 to hold this data.
         */
        for(int i = 0; i<Size; i++){
            int num = readData.readInt();
            data[i] = num;
        }
        long start = System.nanoTime();
        int kth_s = find(19999990,data);
        long end = System.nanoTime();
        //System.out.println(start);
        //System.out.println(end);
        System.out.println(end-start);
        System.out.println(kth_s);
    }
}



