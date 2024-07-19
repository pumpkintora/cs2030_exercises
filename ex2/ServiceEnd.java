class ServiceEnd extends BankEvent {
    public ServiceEnd(double time, Customer customer, Counter counter, Bank bank) {
        // Call the constructor BankEvent(int, double, int)
        super(time);
        this.setCustomer(customer);
        this.setCounter(counter);
        this.setBank(bank);
    }

    /**
     * Returns the string representation of the event,
     * depending on the type of event.
     *
     * @return A string representing the event.
     */
    @Override
    public String toString() {
        String str = "";
        String serviceType = this.getCustomer().getTask() == 1 ? "withdrawal" : "deposit";
        str = String.format(": C%d " + serviceType + " done (by S%d)",
                this.getCustomer().getCustomerId(), this.getCounter().getCounterId());
        return super.toString() + str;
    }

    /**
     * The logic that the simulation should follow when simulating
     * this event.
     *
     * @return An array of new events to be simulated.
     */
    @Override
    public Event[] simulate() {
        // The current event is a service-end event.
        // Mark the counter is available, then schedule
        // a departure event at the current time.
        this.getCounter().setAvailable(true);
        return new Event[] {
                new Departure(this.getTime(), this.getCustomer(), this.getBank()),
        };
    }
}
