/**
 * A transformer with a parameter k that takes in an object x 
 * and outputs the last k digits of the hash value of x.
 * CS2030S Exercise 4
 * AY23/24 Semester 2
 *
 * @author Put Your Name (Lab Group)
 */

class LastDigitsOfHashCode implements Transformer<Object, Integer> {
    private int k;
    public LastDigitsOfHashCode(Integer k) {
        this.k = k;
    }

    @Override
    public Integer transform(Object obj) {
        return Math.abs((int) (obj.hashCode() % Math.pow(10, k)));
    }
}