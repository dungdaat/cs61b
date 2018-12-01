import java.util.Objects;

import static java.lang.Math.max;

/** heap mao */
public class Heap {
    private class Node {
        String label = "test";
        int priority;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return priority == node.priority &&
                    Objects.equals(label, node.label);
        }
        public Node(String item, int number) {
            label = item;
            priority = number;
        }

        public Node(int number) {
            priority = number;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "label='" + label + '\'' +
                    ", priority=" + priority +
                    '}';
        }
    }
    public Node[] content;
    public int size;
    public Heap (int[] a_list) {
        size = a_list.length;
        content = new Node[size];
        for (int i = 0; i<size; i++){
            Node curr = new Node(a_list[i]);
            content[i] = curr;
        }

    }
    public void maxHeapify (int i) {
        Node curr = content[i];
        Node left;
        Node right;
        if (2*i+1 <= size-1){         /** we should be careful about the index here */
            left = content[2*i+1];
        }
        else {
            left = null;
        }
        if (2*i+2 <= size-1) {
            right = content[2*i+2];
        }
        else {
            right = null;
        }

        /** i'm writing a max heap, larger number have higher priority */
        if (left != null &&  right !=null) {
            int max = max(left.priority, right.priority);
            if (curr.priority < max) {
                if(left.priority>right.priority){
                    Node bridge = curr;
                    content[i] = content[2*i+1];
                    content[2*i+1] = curr;
                    maxHeapify(2*i+1);
                }
                else{
                    Node bridge = curr;
                    content[i] = content[2*i+2];
                    content[2*i+2] = curr;
                    maxHeapify(2*i+2);
                }
            }
        }
        if (left != null && right == null) {
            if(curr.priority < left.priority){
                Node bridge = curr;
                content[i] = content[2*i+1];
                content[2*i+1] = curr;
                maxHeapify(2*i+1);
            }
        }
    }

    public void buildMaxHeap () {
        for(int i = size/2; i>=0; i--) {
            maxHeapify(i);
        }
    }

    public Node deleteNode () {
        Node trans = content[0];
        content[0] = content[size-1];
        content[size-1] = trans;
        size -= 1;
        maxHeapify(0);
        return trans;
    }
    public void heapSort () {
        for (int i = size-1; i >= 1; i--) {
            deleteNode();
        }
    }

}