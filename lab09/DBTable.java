import java.util.*;
import java.util.function.Function;

import static java.util.Collections.*;

public class DBTable<T> {
    protected List<T> entries;

    public DBTable() {
        this.entries = new ArrayList<>();
    }

    public DBTable(Collection<T> lst) {
        entries = new ArrayList<>(lst);
    }

    public void add(T t) {
        entries.add(t);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DBTable<?> other = (DBTable<?>) o;
        return Objects.equals(entries, other.entries);
    }

    /** Add all items from a collection to the table. */
    public void add(Collection<T> col) {
        col.forEach(this::add);
    }

    /** Returns a copy of the entries in this table. */
    List<T> getEntries() {
        return new ArrayList<>(entries);
    }

    /**
     * getOrderedBy should create a new list ordered on the results of the
     * getter, without modifying the entries.
     */
    public  <R extends Comparable<R>> List<T> getOrderedBy(Function<T, R> getter) {
        List<T> Ordered = getEntries();
        Collections.sort(Ordered, Comparator.comparing(getter)); /** very interesting question, i should practice more about the usage of comparator
         the lambda expression can be simplified by using Comparator.comparing(the function) */
        return Ordered;
    }

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(2, "Christine", ""),
                new User(4, "Kevin", ""),
                new User(5, "Alex", ""),
                new User(1, "Lauren", ""),
                new User(1, "Catherine", "")
                );
        DBTable<User> t = new DBTable<>(users);
        List<User> l = t.getOrderedBy(User::getEmail);
        l.forEach(System.out::println);
    }
}

