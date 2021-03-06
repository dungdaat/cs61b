import java.lang.System;

public class quickFindKlrg {
    private static class intL {
        int[] box;
        int Size;

        private intL(int k) {
            int[] Box = new int[k];
            box = Box;
            Size = 0;
        }

        public intL insert(int i, int l, int r, intL Box) {
            if (Size == 0) {
                box[0] = i;
                Size += 1;
                return Box;
            }
            if (i >= box[box.length - 1] && Size == box.length) {    // what if there are negative number
                return Box;
            }
            if (l == r) {
                for (int j = box.length - 1; j > l + 1; j--) {
                    box[j] = box[j - 1];
                }
                box[l + 1] = i;
                if (Size < box.length) {
                    Size += 1;
                }
                return Box;
            }
            if (i > box[(l + r) / 2]) {
                return insert(i, (l + r) / 2 + 1, r, Box);
            }
            return insert(i, l, (l + r) / 2, Box);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
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
        if (false) {
            intL inSort = new intL(k);
            for (int i = l; i <=r; i++) {
                inSort.insert(data[i], 0, inSort.Size - 1, inSort);
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
        int kth_s = find(9678945,data);
        long end = System.nanoTime();
        //System.out.println(start);
        //System.out.println(end);
        System.out.println(end-start);
        System.out.println(kth_s);
    }
}




