class Customer {
    public int customerId;

    public int task;

    public static final int DEPOSIT = 0;
    public static final int WITHDRAWAL = 1;

    /**
     * Constructor for a bank event.
     * @param customerId  The customer associated with this
     *                    event.
     * @param task        The task customer wants 
     *                    to perform.
     */ 
    public Customer(int customerId, int task) {
        // Initialize the fields
        this.customerId = customerId;
        this.task = task;
    }

    /**
     * Constructor for a bank event.
     * @param customerId  The customer associated with this
     *                    event.
     */ 
    public Customer(int customerId) {
        // Initialize the fields
        this.customerId = customerId;
    }
}
