class Bank {
    private Counter[] counters;
    private Queue queue;

    public Bank(int numOfCounters, int queueSize) {
        counters = new Counter[numOfCounters];
        queue = new Queue(queueSize);
        for (int i = 0; i < numOfCounters; i++) {
            this.counters[i] = new Counter(i);
        }
    }

    public Counter getAvailableCounter() {
        for (Counter counter : this.counters) {
            if (counter.isAvailable()) {
                return counter;
            }
        }
        return null;
    }

    public void queueCustomer(Customer customer) {
        queue.enq(customer);
    }

    public Customer dequeueCustomer() {
        return (Customer) queue.deq();
    }

    public boolean checkQueueFull() {
        return queue.isFull();
    }

    public Counter[] getCounters() {
        return this.counters;
    }
}
