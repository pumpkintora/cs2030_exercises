class Departure extends BankEvent {
    /**
     * Constructor for a bank event.
     *
     * @param time     The time this event occurs.
     * @param customer The customer associated with this
     *                 event.
     */
    public Departure(double time, Customer customer, Bank bank) {
        // Call the constructor Event(double)
        super(time);

        // Initialize the fields
        this.setCustomer(customer);
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
        str = String.format(": C%d departed", this.getCustomer().getCustomerId());
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
        if (this.getBank().checkQueueHasCustomer() && this.getBank().getAvailableCounter() != null) {
            Counter availableCounter = this.getBank().getAvailableCounter();
            Customer c = this.getBank().dequeueCustomer();
            return new Event[]{
                    new ServiceBegin(this.getTime(), c, availableCounter, this.getBank())
            };
        } else {
            return new Event[]{};
        }
    }
}
