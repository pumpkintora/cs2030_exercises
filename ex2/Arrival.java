/**
 * Arrival
 */
class Arrival extends BankEvent {
    public Arrival(double time, Customer customer, Bank bank) {
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
        String queue = this.getBank().getQueue();
        str = String.format(": C%d arrived " + queue, this.getCustomer().getCustomerId());
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
        // The current event is an arrival event.
        // Find the first available counter.
        if (this.getBank().getAvailableCounter() != null) {
            Counter availableCounter = this.getBank().getAvailableCounter();
            return new Event[] {
                    new ServiceBegin(this.getTime(), this.getCustomer(), availableCounter, this.getBank())
            };
        } else {
            if (!this.getBank().checkQueueFull()) {
                return new Event[] {
                        new JoinQueue(this.getTime(), this.getCustomer(), this.getBank())
                };
            }
            return new Event[] {
                    new Departure(this.getTime(), this.getCustomer(), this.getBank())
            };
        }
    }
}