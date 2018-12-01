import java.util.Objects;

/**
  * A DLList is a list of integers. Like SLList, it also hides the terrible
  * truth of the nakedness within, but with a few additional optimizations.
  */
public class DLList<BleepBlorp> {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DLList<?> dlList = (DLList<?>) o;
        return size == dlList.size &&
                Objects.equals(sentinel, dlList.sentinel);
    }


    @Override
    public String toString() {
        return "DLList{" +
                "sentinel=" + sentinel +
                ", size=" + size +
                '}';
    }

    private class Node {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(prev, node.prev) &&
                    Objects.equals(item, node.item) &&
                    Objects.equals(next, node.next);
        }


        @Override
        public String toString() {
            return "Node{" +
                    "prev=" + prev +
                    ", item=" + item +
                    ", next=" + next +
                    '}';
        }

        public Node prev;
        public BleepBlorp item;
        public Node next;

        public Node(BleepBlorp i, Node p, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private Node sentinel;
    private int size;

    /** Creates an empty DLList. */
    public DLList() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /** Returns a DLList consisting of the given values. */
    public static <BleepBlorp> DLList of(BleepBlorp... values) {
        DLList<BleepBlorp> list = new DLList<>();
        for (BleepBlorp value : values) {
            list.addLast(value);
        }
        return list;
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Adds item to the front of the list. */
    public void addFirst(BleepBlorp item) {
        Node n = new Node(item, sentinel, sentinel.next);
        n.next.prev = n;
        n.prev.next = n;
        size += 1;
    }

    /** Adds item to the back of the list. */
    public void addLast(BleepBlorp item) {
        Node n = new Node(item, sentinel.prev, sentinel);
        n.next.prev = n;
        n.prev.next = n;
        size += 1;
    }

    /** Adds item to the list at the specified index. */
    public void add(int index, BleepBlorp item) {
        Node p = sentinel;
        while (index > 0) {
            p = p.next;
            index --;
        }
        Node n = new Node(item,p,p.next);
        n.next.prev = n;
        n.prev.next = n;
        size += 1;
    }

    /** Remove the first instance of item from this list. */
    public void remove(BleepBlorp item) {
        Node p = sentinel;
        while(!p.next.equals(item)) {
            p = p.next;
        }
        p.next = p.next.next;
        p.next.prev = p;
        size -= 1;
    }

}
