/**
 * The Seq<T> class for CS2030S 
 *
 * @author XXX
 * @version CS2030S AY23/24 Semester 2
 */
class Seq<T extends Comparable<T>> { // TODO: Change to bounded type parameter
  private T[] seq;

  @SuppressWarnings("unchecked")
  Seq(int size) {
    // TODO
    this.seq = (T[]) new Comparable[size];
  }

  public void set(int index, T item) {
    // TODO
    seq[index] = item;
  }

  public T get(int index) {
    // TODO
    return seq[index];
  }

  public T min() {
    // TODO
    if (seq.length == 0) return null;
    T min = seq[0];
    if (seq.length == 1) return min;
    for (int i = 1; i < seq.length; i++) {
      if (seq[i].compareTo(min) < 0)
        min = seq[i];
    }
    return min;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("[ ");
    for (int i = 0; i < this.seq.length; i++) {
      s.append(i + ":" + this.seq[i]);
      if (i != this.seq.length - 1) {
        s.append(", ");
      }
    }
    return s.append(" ]").toString();
  }
}
