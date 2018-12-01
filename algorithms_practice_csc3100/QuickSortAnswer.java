public class QuickSortAnswer {

    public static void sort(int[] arr) {
        qSort(arr, 0, arr.length -1);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void qSort(int[] arr, int left, int right) {
        if (left > right)
            return;

        int pivot = arr[right];

        int i = left;
        int j = right - 1;

        while (i<j) {
            while (arr[i] < pivot && i<j)
                i++;
            while (arr[j] > pivot && j>i)
                j--;
            if (i<j) {
                swap(arr, i, j);
            }
        }

        swap(arr, i, right);

        qSort(arr, left, i - 1);
        qSort(arr, i + 1, right);
    }

    public static void main(String[] args) {
        int[] num = { 5, 3, 2, 8, 7, 4, 1, 9 };

        QuickSortAnswer.sort(num);

        for (int i = 0; i < num.length; i++)
            System.out.print(num[i] + " ");
    }
}