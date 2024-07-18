/**
 * A boolean condition with an integer parameter y that can be 
 * apply to another integer x.  Returns true if x is divisible 
 * by y, false otherwise.
 * CS2030S Exercise 4
 * AY23/24 Semester 2
 *
 * @author Put Your Name (Lab Group)
 */
class DivisibleBy implements BooleanCondition<Integer> {
    private int denominator;

    public DivisibleBy(Integer denominator) {
        this.denominator = denominator;
    }

    public boolean test(Integer intNumber) {
        return intNumber % denominator == 0;
    }
}

