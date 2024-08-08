package cs2030s.fp;

public class Lazy<T> {
  private Producer<? extends T> producer;
  private Maybe<T> value;

  private Lazy(T v) {
    this.value = Maybe.some(v);
    this.producer = () -> v;
  }

  private Lazy(Producer<? extends T> p) {
    this.producer = p;
    this.value = Maybe.none();
  }

  public static <T> Lazy<T> of (T v) {
    return new Lazy<T>(v);
  }

  public static <T> Lazy<T> of(Producer<? extends T> p) {
    return new Lazy<T>(p);
  }

  public T get() {
    T produced = this.producer.produce();
    this.value = Maybe.of(produced);
    this.producer = () -> produced;
    return this.value.orElse(produced);
  }

  @Override
  public String toString() {
    Maybe<String> val = value.flatMap(a -> Maybe.of(String.valueOf(a)));
    return val.orElse("?");
  }

  public <U> Lazy<U> map(Transformer<? super T, ? extends U> transformer) {
    return Lazy.of(() -> transformer.transform(this.get()));
  }

  public <U> Lazy<U> flatMap(Transformer<? super T, ? extends Lazy<? extends U>> transformer) {
    return Lazy.of(() -> transformer.transform(this.get()).get());
  }
}
