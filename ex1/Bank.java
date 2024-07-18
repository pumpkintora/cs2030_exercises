class Bank {
    private Counter[] counters;

    public Bank(int numOfCounters) {
        counters = new Counter[numOfCounters];
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

    public Counter[] getCounters() {
        return this.counters;
    }
}
