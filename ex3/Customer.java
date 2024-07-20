class Customer {
    private int customerId;

    private double serviceTime;

    private Task task;

    private int amount;

    public static final int DEPOSIT = 0;
    public static final int WITHDRAWAL = 1;

    public Customer(int customerId, double serviceTime, Task task, int amount) {
        // Initialize the fields
        this.customerId = customerId;
        this.task = task;
        this.serviceTime = serviceTime;
        this.amount = amount;
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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "C" + this.getCustomerId();
    }

}
