class Counter {
    private boolean available;
    private int counterId;

    public Counter(int counterId) {
        this.available = true;
        this.counterId = counterId;
    }
    
    public int getCounterId() {
        return this.counterId;
    }

    public void setCounterId(int counterId) {
        this.counterId = counterId;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
