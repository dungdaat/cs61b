public class QuickSort {

    public static void qSort(int[] arr, int left, int right) {

    }
    public static int median3(int[]arr, int left, int right) {
        int frt = arr[left];
        int lst = arr[right];
        int middle = (left + right)/2;
        int mid = arr[middle];
        if (Math.max(frt,mid)<lst) {
            if(frt < mid) {
                swap(arr, middle, right-1);
                return mid;
            }
            else{
                swap(arr, left, right-1);
                return frt;
            }
        }
        return 0;
    }

    public static void swap(int[]arr, int i, int j) {
        int carr = arr[i];
        arr[i] = arr[j];
        arr[j] = carr;
    }



}
