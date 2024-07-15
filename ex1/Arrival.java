/**
 * Arrival
 */
class Arrival extends Event {
    /**
     * The id of a customer associated with this event.
     * First customer has id 0. Next is 1, 2, etc.
     */
    public int customerId;

    /**
     * A tag to indicate what type of event this is.
     * Possible types are ARRIVAL, SERVICE_BEGIN,
     * SERVICE_END and DEPARTURE.
     */
    /** ARRIVAL = 0 **/
    public static final int eventType = 0;

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

    /**
     * Constructor for a bank event.
     *
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
    public Arrival(double time, int customerId,
            double serviceTime, int counterId, boolean[] available) {
        // Call the constructor Arrival(int, double, int)
        this(time, customerId);

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
    public Arrival(double time, int customerId,
            double serviceTime, boolean[] available) {
        // Call the constructor Arrival(int, double, int)
        this(time, customerId);

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
    public Arrival(double time, int customerId) {
        // Call the constructor Event(double)
        super(time);

        // Initialize the fields
        this.customerId = customerId;
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
        str = String.format(": Customer %d arrives", this.customerId);
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
        int counter = -1;
        for (int i = 0; i < this.available.length; i += 1) {
            if (this.available[i]) {
                counter = i;
                break;
            }
        }
        if (counter == -1) {
            // If no such counter can be found, the customer
            // should depart.
            return new Event[] {
                    new Departure(this.getTime(), this.customerId)
            };
        } else {
            // Else, the customer should go the the first
            // available counter and get served.
            return new Event[] {
                    new ServiceBegin(this.getTime(), this.customerId,
                            this.serviceTime, counter, this.available)
            };
        }

    }
}