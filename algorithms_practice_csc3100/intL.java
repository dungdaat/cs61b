public class intL {
    int[] box;
    int Size;

   public intL(int k) {
        int [] Box = new int[k];
        box = Box;
        Size = 0;
    }

   public intL insert(int i, int l, int r,intL Box){
        if (Size == 0) {
            box[0] = i;
            Size += 1;
            return Box;
        }
        if (Size == 1 && box[0] < i) {
            box[1] = i;
            Size += 1;
            return Box;
        }
        if (Size == 1 && box[0] >= i){
            box[1] = box[0];
            box[0] = i;
            Size += 1;
            return Box;
        }
        if (i >= box[box.length-1] && Size == box.length) {    // what if there are negative number
            return Box;
        }
        if (l == r) {
            for (int j = box.length-1; j > l ; j--) {
                box[j] = box[j-1];
            }
            box[l] = i;
            if(Size < box.length){Size += 1;}
            return Box;
        }
        if (i > box[(l+r)/2]) {
            return insert(i, (l+r)/2+1,r,Box);
        }
        return insert(i,l,(l+r)/2,Box);
    }

    public static int helper(int[] data, int l, int r, int k) {
        intL inSort = new intL(k);
        for (int i = l; i <=r; i++) {
            inSort.insert(data[i], 0, inSort.Size - 1, inSort);
        }
        return inSort.box[k-1];
    }
    public static int find(int k, int[]data) {
        return helper(data, 0, data.length - 1, k);
    }

    public static void main(String[] args){
        String data_path = "/Users/lidongda/3100_test/test2.txt";
        In readData = new In(data_path);
        int Size = 10;
        int[] data = new int[Size];
        /** this part read the data from an external path and construct a list with
         * size 20,000,000 to hold this data.
         */
        for(int i = 0; i<Size; i++){
            int num = readData.readInt();
            data[i] = num;
        }
        long start = System.nanoTime();
        int kth_s = find(5,data);
        long end = System.nanoTime();
        //System.out.println(start);
        //System.out.println(end);
        System.out.println(end-start);
        System.out.println(kth_s);
    }
}
