/**
 * A generic box storing an item.
 * CS2030S Exercise 4
 * AY23/24 Semester 2
 *
 * @author Put Your Name (Lab Group)
 */

class Box<T> {

    private final T content;

    private static final Box<?> EMPTY_BOX = new Box<Object>(null);

    private Box(T content) {
        this.content = content;
    }

    public static <T> Box<T> of(T content) {
        if (content == null) {
            return null;
        }
        return new Box<T>(content);
    }

    public static <T> Box<T> empty() {
        @SuppressWarnings("unchecked")
        Box<T> temp = (Box<T>) EMPTY_BOX;
        return temp;
    }

    public boolean isPresent() {
        return this.content != null;
    }

    public static <T> Box<T> ofNullable(T content) {
        if (content != null) return of(content);
        else return empty();
    }

    public Box<T> filter(BooleanCondition<? super T> bc) {
        if (isPresent() && bc.test(this.content)) return this;
        else return empty();
    }

    public <U> Box<U> map(Transformer<? super T, U> transformer) {
        if (!isPresent()) return empty();
        return new Box<U>(transformer.transform(this.content));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Box<?>) {
            Box<?> anotherBox = (Box<?>) obj;
            if (!isPresent() || !anotherBox.isPresent()) {
                return this.content == anotherBox.content;
            }
            return this.content.equals(anotherBox.content);
        }
        return false;
    }

    @Override
    public String toString() {
        if (!isPresent()) return "[]";
        return "[" + content.toString() + "]";
    }
}