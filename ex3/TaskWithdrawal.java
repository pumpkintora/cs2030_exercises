class TaskWithdrawal extends Task {
    public TaskWithdrawal(int amount) {
        super(amount);
    }

    @Override
    public void performTask(Counter counter) {
        if (counter.withdraw(this.getAmount())) {
            this.setSuccess(true);
        }
    }

    @Override
    public String toString() {
        return String.format("withdrawal $%d", this.getAmount());
    }
}

