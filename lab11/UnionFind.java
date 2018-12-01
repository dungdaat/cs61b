public class UnionFind {

    int[] content;
    int size;

    /* Creates a UnionFind data structure holding N vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int N) {
        size = N;
        content = new int[N];
        for (int i = 0; i < N-1; i++) {
            content[i] = -1;
        }
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        if (parent(v) > 0) {
            return sizeOf(parent(v));
        }
        return -parent(v);
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        return content[v];
    }

    /* Returns true if nodes V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        while (parent(v1) > 0) {
            v1 = parent(v1);
        }
        while (parent(v2) > 0) {
            v2 = parent(v2);
        }
        return v1 == v2;
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid vertices are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        // what is a invalid vertex??
        // TODO: YOUR CODE HERE
        // some other way to throw exception?
        try {
            while (parent(v) > 0) {
                v = parent(v);
            }
            return v;
        }catch(IndexOutOfBoundsException e){
            System.out.println("Index out of bound");
        }
        return -1;
    }

    /* Connects two elements V1 and V2 together. V1 and V2 can be any element,
       and a union-by-size heuristic is used. If the sizes of the sets are
       equal, tie break by connecting V1's root to V2's root. Union-ing a vertex
       with itself or vertices that are already connected should not change the
       structure. */
    public void union(int v1, int v2) {
        // TODO: YOUR CODE HERE
        // I don't quite get it, what does it mean?? what should i do if they are of same size??
    }
}
