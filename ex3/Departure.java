import java.util.ArrayList;

class Departure extends BankEvent {
    /**
     * Constructor for a bank event.
     *
     * @param time     The time this event occurs.
     * @param customer The customer associated with this
     *                 event.
     */
    public Departure(double time, Customer customer, Counter counter, Bank bank) {
        // Call the constructor Event(double)
        super(time);

        // Initialize the fields
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
        ArrayList<BankEvent> events = new ArrayList<>();
        if (this.getCounter() != null && !this.getCounter().queueIsEmpty()) {
            events.add(new ServiceBegin(this.getTime(), this.getCounter().nextCustomer(), this.getCounter(), this.getBank()));
            if (!this.getBank().queueIsEmpty()) {
                events.add(new JoinCounterQueue(this.getTime() + 0.01, this.getBank().nextCustomer(), this.getCounter(), this.getBank()));
            }
        } else {
            if (!this.getBank().queueIsEmpty() && this.getBank().getAvailableCounter() != null) {
                events.add(new ServiceBegin(this.getTime(), this.getBank().nextCustomer(), this.getCounter(), this.getBank()));
            }
        }
        @SuppressWarnings("unchecked")
        Event[] temp = (Event[]) events.toArray(new Event[] {});
        return temp;
    }
}
