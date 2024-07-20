class Bank {
    private Seq<Counter> counters;
    private Queue queue;
    private int numOfCounters;

    public Bank(int numOfCounters, int queueSize, int maxCounterSize) {
        counters = new Seq<Counter>(numOfCounters);
        queue = new Queue(queueSize);
        for (int i = 0; i < numOfCounters; i++) {
            this.counters.set(i, new Counter(i, maxCounterSize));
        }
        this.numOfCounters = numOfCounters;
    }

    public Counter getAvailableCounter() {
        for (int i = 0; i < numOfCounters; i++) {
            if (counters.get(i).isAvailable()) {
                return counters.get(i);
            }
        }
        return null;
    }

    public Counter getMinCounter() {
        Counter c = counters.min();
        if (c != null && !c.getQueue().isFull()) {
            return c;
        }
        return null;
    }

    public String getQueue() {
        return this.queue.toString();
    }

    public void queueCustomer(Customer customer) {
        queue.enq(customer);
    }

    public Customer dequeueCustomer() {
        return (Customer) queue.deq();
    }

    public boolean queueIsFull() {
        return queue.isFull();
    }

    public boolean queueIsEmpty() {
        return queue.isEmpty();
    }

    public Customer nextCustomer() {
        if (!queueIsEmpty()) return (Customer) queue.deq();
        return null;
    }

    public Seq<Counter> getCounters() {
        return this.counters;
    }
}
