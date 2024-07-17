class ServiceEnd extends Event {
    /**
     * The id of a customer associated with this event.
     * First customer has id 0. Next is 1, 2, etc.
     */
    public Customer customer;

    /**
     * A tag to indicate what type of event this is.
     * Possible types are ARRIVAL, SERVICE_BEGIN,
     * SERVICE_END and DEPARTURE.
     */
    public static final int eventType = 2;

    /**
     * The service time of the customer associated
     * this event. This field matters only if the
     * event type is ARRIVAL or SERVICE_BEGIN.
     */
    public double serviceTime;

    /**
     * An array to indicate if a service counter is
     * available. available[i] is true if and only
     * if service counter i is available to serve.
     */
    public boolean[] available;

    /**
     * The id of the counter associated with this event.
     * This field only matters if the event type if
     * SERVICE_BEGIN or SERVICE_END.
     */
    public int counterId;

    /*
     * Different types of events. This should be
     * implemented as enum, but we have not cover
     * that yet.
     */
    public static final int ARRIVAL = 0;
    public static final int SERVICE_BEGIN = 1;
    public static final int SERVICE_END = 2;
    public static final int DEPARTURE = 3;

    /**
     * Constructor for a bank event.
     *
     * @param eventType   The indicator for which type of
     *                    event this is.
     * @param time        The time this event occurs.
     * @param customerId  The customer associated with this
     *                    event.
     * @param serviceTime The time this customer takes
     *                    for service.
     * @param counterId   The id of the counter associated with
     *                    this event.
     * @param available   The indicator of which counter is
     *                    available.
     */
    public ServiceEnd(double time, Customer customer,
            double serviceTime, int counterId, boolean[] available) {
        // Call the constructor BankEvent(int, double, int)
        this(time, customer);

        // Initialize the fields
        this.serviceTime = serviceTime;
        this.available = available;
        this.counterId = counterId;
    }

    /**
     * Constructor for a bank event.
     *
     * @param eventType   The indicator for which type of
     *                    event this is.
     * @param time        The time this event occurs.
     * @param customerId  The customer associated with this
     *                    event.
     * @param serviceTime The time this customer takes
     *                    for service.
     * @param available   The indicator of which counter is
     *                    available.
     */
    public ServiceEnd(double time, Customer customer,
            double serviceTime, boolean[] available) {
        // Call the constructor BankEvent(int, double, int)
        this(time, customer);

        // Initialize the fields
        this.serviceTime = serviceTime;
        this.available = available;
    }

    /**
     * Constructor for a bank event.
     *
     * @param eventType  The indicator for which type of
     *                   event this is.
     * @param time       The time this event occurs.
     * @param customerId The customer associated with this
     *                   event.
     */
    public ServiceEnd(double time, Customer customer) {
        // Call the constructor Event(double)
        super(time);

        // Initialize the fields
        this.customer = customer;
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
                this.customer.customerId, this.counterId);
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
        this.available[this.counterId] = true;
        return new Event[] {
                new Departure(this.getTime(), this.customer),
        };

    }
}
