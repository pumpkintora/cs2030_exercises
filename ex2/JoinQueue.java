class JoinQueue extends BankEvent {

    public JoinQueue(double time, Customer customer, Bank bank) {
        // Call the constructor Event(double)
        super(time);

        // Initialize the fields
        this.setCustomer(customer);
        this.setBank(bank);
    }

    @Override
    public String toString() {
        String str = "";
        String queue = this.getBank().getQueue();
        str = String.format(": C%d joined queue " + queue, this.getCustomer().getCustomerId());
        this.getBank().queueCustomer(this.getCustomer());
        return super.toString() + str;
    }

    @Override
    public Event[] simulate() {
        return new Event[] {};
    }

}
