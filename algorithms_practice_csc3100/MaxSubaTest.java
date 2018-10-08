import org.junit.Test;
import static org.junit.Assert.*;

public class MaxSubaTest {
    @Test
    public void TestOne(){
        int[] array1 = {1,-4,5,7,10,24,-78,196,43,-69};
        int[] array2 = {0,0,239};
        MaxSuba Array1 = new MaxSuba(array1);
        int[] Sol = Array1.findMax().sol;
        assertEquals(array2[2], Sol[2]);
    }

    @Test
    public void TestGreedyM (){
        int[] array3 = {1,-4,5,7,10,24,-78,196,43,-69};
        GreedyM Array3 = new GreedyM(array3);
        int[] sol = Array3.GMax();
    }
}





