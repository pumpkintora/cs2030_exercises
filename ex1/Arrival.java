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
        str = String.format(": Customer %d arrives", this.getCustomer().getCustomerId());
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
                    new ServiceBegin(this.getTime(), this.getCustomer(), availableCounter)
            };
        } else {
            return new Event[] {
                    new Departure(this.getTime(), this.getCustomer())
            };
        }
    }
}