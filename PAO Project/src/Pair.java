public class Pair<L, R> {
    private L key;
    private R value;

    public Pair(L key, R value) {
        this.key = key;
        this.value = value;
    }

    public L getKey() {
        return this.key;
    }

    public R getValue() {
        return this.value;
    }

    public void setValue(R value) {
        this.value = value;
    }

    public void setKey(L key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
