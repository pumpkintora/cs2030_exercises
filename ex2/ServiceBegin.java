class ServiceBegin extends BankEvent {
    /**
     * The id of a customer associated with this event.
     * First customer has id 0. Next is 1, 2, etc.
     */
    public ServiceBegin(double time, Customer customer, Counter counter) {
        // Call the constructor ServiceBegin(int, double, int)
        super(time);

        // Initialize the fields
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
        str = String.format(": Customer %d service begin (by Counter %d)",
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
        // The current event is a service-begin event.
        // Mark the counter is unavailable, then schedule
        // a service-end event at the current time + service time.
        this.getCounter().setAvailable(false);
        double endTime = this.getTime() + this.getCustomer().getServiceTime();
        return new Event[] {
                new ServiceEnd(endTime, this.getCustomer(), this.getCounter())
        };

    }
}
