class Customer {
    private int customerId;

    private double serviceTime;

    private int task;

    
    public static final int DEPOSIT = 0;
    public static final int WITHDRAWAL = 1;
    
    public Customer(int customerId, double serviceTime) {
        // Initialize the fields
        this.customerId = customerId;
        this.serviceTime = serviceTime;
    }
    
    public Customer(int customerId, double serviceTime, int task) {
        // Initialize the fields
        this.customerId = customerId;
        this.task = task;
        this.serviceTime = serviceTime;
    }
    
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(double serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getTask() {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "C" + this.getCustomerId();
    }
    
}
