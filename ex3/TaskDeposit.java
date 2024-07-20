class TaskDeposit extends Task {
    public TaskDeposit(int amount) {
        super(amount);
    }

    @Override
    public void performTask(Counter counter) {
        if (counter.deposit(this.getAmount())) {
            this.setSuccess(true);
        }
    }

    @Override
    public String toString() {
        return String.format("deposit $%d", this.getAmount());
    }
}
