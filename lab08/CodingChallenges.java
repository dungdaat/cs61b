public class CodingChallenges {

    /**
     * Return the missing number from an array of length N - 1 containing all
     * the values from 0 to N except for one missing number.         Here it should be 1 to n, its a silly mistake.
     */
    public static int missingNumber(int[] values) {
        class Helper {
            int[] value;
            int low;
            int high;
            public Helper (int[] value, int low, int high) {
                value = value;
                low = low;
                high = high;
            }
            public int finder() {
                if (value.length == 2) {
                    if (value[0] == low && value[2] == high) {
                        return low + 1;    /**check here */
                    }
                    if (value[0] > low) {
                        return low;
                    } else {
                        return high;
                    }
                }
                if (value.length == 1) {
                    if (value[0] > low) {
                        return low;
                    } else {
                        return high;
                    }
                }
                int leftPart = value.length / 2;
                int middle = (low + high) / 2;
                int[] left = new int[leftPart];
                int[] right = new int[value.length - leftPart];
                int i = 0;
                int j = 0;
                for (int mark = 0; mark < value.length; mark++) {
                    if (value[mark] < middle) {
                        left[i] = value[mark];
                        i++;
                    } else {
                        right[j] = value[mark];
                        j++;
                    }
                }
                if ((middle - low + 1) == left.length) {
                    Helper Right = new Helper(right, middle, high);
                    return Right.finder();
                } else {
                    Helper Left = new Helper(right,low,middle);
                    return Left.finder();
                }
            }
        }
        Helper Whole = new Helper(values,1,values.length+1);
        return Whole.finder();
    }

    /** Returns true if and only if two integers in the array sum up to n. */
    public static boolean sumTo(int[] values, int n) {
        // TODO
        // /** construnc a hashset and when we iterate through the array, we find if curr is in the set and insert n-curr into the set
        return false;
    }

    /**
     * Returns true if and only if s1 is a permutation of s2. s1 is a
     * permutation of s2 if it has the same number of each character as s2.
     */
    public static boolean isPermutation(String s1, String s2) {
        // TODO
        /** using set, and add a compare method in the set interface */
        return false;
    }
}
