class Counter implements Comparable<Counter> {
    private boolean available;
    private int counterId;
    private Queue<Customer> queue;
    private int amount;

    private static final int INITIAL_AMOUNT = 100;

    public Counter(int counterId, int queueSize) {
        this.queue = new Queue<Customer>(queueSize);
        this.available = true;
        this.counterId = counterId;
        this.amount = INITIAL_AMOUNT;
    }

    @Override
    public int compareTo(Counter c) {
        if (queue.length() < c.getQueue().length()) {
            return -1;
        } else if (queue.length() == c.getQueue().length()) {
          return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "S" + this.getCounterId() + " $" + this.getAmount() + " " + this.getQueue().toString();
    }

    public boolean deposit(int customerAmount) {
        this.amount = amount + customerAmount;
        return true;
    }

    public boolean withdraw(int customerAmount) {
        if (this.amount > customerAmount) {
            this.amount = amount - customerAmount;
            return true;
        }
        return false;
    }

    public int getCounterId() {
        return this.counterId;
    }

    public void setCounterId(int counterId) {
        this.counterId = counterId;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Queue<Customer> getQueue() {
        return this.queue;
    }

    public void queueCustomer(Customer customer) {
        queue.enq(customer);
    }

    public Customer dequeueCustomer() {
        return (Customer) queue.deq();
    }

    public Customer nextCustomer() {
        if (!queue.isEmpty()) return (Customer) queue.deq();
        return null;
    }

    public boolean queueIsFull() { return this.queue.isFull(); }

    public boolean queueIsEmpty() { return this.queue.isEmpty(); }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
