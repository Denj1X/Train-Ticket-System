import java.util.Comparator;

public class PairComparator<L extends Comparable<L>, R> implements Comparator<Pair<L, R>> {

    @Override
    public int compare(Pair<L, R> pair1, Pair<L, R> pair2) {
        return pair1.getKey().compareTo(pair2.getKey());
    }
}