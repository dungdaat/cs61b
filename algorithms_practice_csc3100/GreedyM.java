public class GreedyM {
    /** constructor */
    int[] input;
    int max;
    public GreedyM(int[] intl) {
        input = intl;
        max = 0;
    }
    public int[] GMax() {
        int sum = 0;
        int start = 0;
        int end = 0;
        int curr = 0;
        int intermsum = 0;
        for (int i=0; i<input.length;i++) {
            intermsum += input[i];
            if (intermsum > sum) {
                sum = intermsum;
                end = i;
                start = curr;
            }
            if (intermsum<0){
                curr = i+1;
                intermsum = 0;
            }
        }
        int[] sol = {start, end, sum};
        return sol;
    }
}
