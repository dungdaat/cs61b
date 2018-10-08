import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class kLargestTest {
    @Test
    public void KLargestTest(){
        int[] test1 = {1,2,5,10,80,100,-76,57,3,11,-2,85,43,9,4};
        kLargest Test1 = new kLargest(test1, 6);
        int[] anw = Test1.kMerge();
        System.out.print(anw);
    }
}
