/**
 * CS2030S Lab 5
 * AY23/24 Semester 2
 *
 * @author Put Your Name (Lab Group)
 */

package cs2030s.fp;

import java.util.NoSuchElementException;

public abstract class Maybe<T> {

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
        protected Object get() throws NoSuchElementException {
            throw new NoSuchElementException();
        }

        @Override
        public Maybe<Object> filter(BooleanCondition<? super Object> bc) {
            return Maybe.none();
        }

        @Override
        public <U> Maybe<U> map(Transformer<? super Object, ? extends U> transformer) throws NullPointerException {
            return Maybe.<U>none();
        }

        @Override
        public <U> Maybe<U> flatMap(Transformer<? super Object, ? extends Maybe<? extends U>> transformer) throws NullPointerException {
            return Maybe.<U>none();
        }

        @Override
        public Object orElse(Object t) {
            return t;
        }

        @Override
        public Object orElseGet(Producer<? extends Object> producer) {
            return producer.produce();
        }

        @Override
        public void ifPresent(Consumer<? super Object> consumer) {
            return;
        }
    }

    private static final class Some<T> extends Maybe<T> {
        private final T item;

        public Some(T item) {
            this.item = item;
        }

        @Override
        public boolean equals(Object another) {
            if (another instanceof Maybe.Some<?>) {
                Some<?> castedAnother = (Some<?>) another;
                return this.item == castedAnother.item;
            }
            return false;
        }

        @Override
        public String toString() {
            if (item != null)
                return "[" + item.toString() + "]";
            else
                return "[null]";
        }

        @Override
        protected T get() {
            return item;
        }

        @Override
        public Maybe<T> filter(BooleanCondition<? super T> bc) {
            return this.get() != null && !bc.test(this.get()) ? Maybe.none() : this;
        }

        @Override
        public <U> Maybe<U> map(Transformer<? super T, ? extends U> transformer) {
            U newItem = transformer.transform(this.item);
            return new Some<U>(newItem);
        }

        @Override
        public <U> Maybe<U> flatMap(Transformer<? super T, ? extends Maybe<? extends U>> transformer) {
            @SuppressWarnings("unchecked")
            Maybe<U> newItem = (Maybe<U>) transformer.transform(this.item);
            return newItem;
        }

        @Override
        public T orElse(T t) {
            return this.get();
        }

        @Override
        public T orElseGet(Producer<? extends T> producer) {
            return this.get();
        }

        @Override
        public void ifPresent(Consumer<? super T> consumer) {
            consumer.consume(this.get());
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

    public abstract Maybe<T> filter(BooleanCondition<? super T> bc);

    public abstract <U> Maybe<U> map(Transformer<? super T, ? extends U> transformer);

    public abstract <U> Maybe<U> flatMap(Transformer<? super T, ? extends Maybe<? extends U>> transformer);

    public abstract T orElse(T t);

    public abstract T orElseGet(Producer<? extends T> producer);

    public abstract void ifPresent(Consumer<? super T> consumer);

}