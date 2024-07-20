abstract class Task {
    private int amount;
    private boolean success;

    public Task(int amount) {
        this.amount = amount;
    }

    public abstract String toString();

    void performTask(Counter counter) {};

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean getSuccess() {
        return success;
    };

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
