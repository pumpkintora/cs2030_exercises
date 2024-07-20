class JoinCounterQueue extends BankEvent {
    public JoinCounterQueue(double time, Customer customer, Counter counter, Bank bank) {
        // Call the constructor Event(double)
        super(time);

        // Initialize the fields
        this.setCustomer(customer);
        this.setCounter(counter);
        this.setBank(bank);
    }

    @Override
    public String toString() {
        String str = "";
        String queue = this.getCounter().getQueue().toString();
        str = String.format(": C%d joined counter queue (at S%d $%d " + queue + ")", this.getCustomer().getCustomerId(), this.getCounter().getCounterId(), this.getCounter().getAmount());
        this.getCounter().queueCustomer(this.getCustomer());
        return super.toString() + str;
    }

    @Override
    public Event[] simulate() {
        return new Event[]{};
    }

}
