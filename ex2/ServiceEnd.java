class ServiceEnd extends BankEvent {
    public ServiceEnd(double time, Customer customer, Counter counter) {
        // Call the constructor BankEvent(int, double, int)
        super(time);
        this.setCustomer(customer);
        this.setCounter(counter);
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
        str = String.format(": Customer %d service done (by Counter %d)",
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
                new Departure(this.getTime(), this.getCustomer()),
        };
    }
}
