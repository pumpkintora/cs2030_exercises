/**
 * CS2030S Lab 5
 * AY23/24 Semester 2
 *
 * @author Put Your Name (Lab Group)
 */
abstract class Maybe<T> {

    private static final Maybe<?> NONE = new None();

    private static class None extends Maybe<Object> {
        public boolean equals(None another) {
            return this == another;
        }

        @Override
        public String toString() {
            return "[]";
        }

        @Override
        protected Object get() {
            throw new java.util.NoSuchElementException();
        }

        @Override
        public Maybe<Object> filter(BooleanCondition<? super Object> bc) {
            return Maybe.none();
        }


    }

    private static final class Some<T> extends Maybe<T> {
        private final T item;

        public Some(T item) {
            this.item = item;
        }

        @Override
        public boolean equals(Object another) {
            if (another instanceof Some<?>) {
                Some<?> castedAnother = (Some<?>) another;
                return this.item == castedAnother.item;
            }
            return false;
        }

        @Override
        public String toString() {
            return "[" + item.toString() + "]";
        }

        @Override
        protected T get() {
            return item;
        }

        @Override
        public Maybe<T> filter(BooleanCondition<? super T> bc) {
            return bc.test(this.get()) ? this : Maybe.none();
        }
    }

    public static <T> Maybe<T> none() {
        @SuppressWarnings("unchecked")
        Maybe<T> temp = (Maybe<T>) NONE;
        return temp;
    }

    public static <T> Maybe<T> some(T t) {
        return new Some<T>(t);
    }

    public static <T> Maybe<T> of(T input) {
        if (input != null) return some(input);
        else return none();
    }

    protected abstract T get();

    abstract Maybe<T> filter(BooleanCondition<? super T> bc);

    abstract Maybe<T> map(Transformer<? extends T, T> transformer);

}