import org.junit.Test;


public class TestHeap {
    @Test
    public void testconstructor (){
        int[] numList = {1,2,3,4,5,6,7,8,9,10};
        Heap newHeap = new Heap(numList);
        newHeap.maxHeapify(1);
        newHeap.buildMaxHeap();
        newHeap.heapSort();
        System.out.print(newHeap);
    }




}
