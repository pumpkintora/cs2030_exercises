/**
 * This class encapsulates an event in the bank
 * simulation.  Your task is to replace this
 * class with new classes, following proper OOP principles.
 *
 * @author Wei Tsang
 * @version CS2030S AY23/24 Semester 2
 */
class BankEvent extends Event {
  private Customer customer;
  private Counter counter;
  private Bank bank;

  public BankEvent(double time) {
    // Call the constructor Event(double)
    super(time);
  }

  /**
   * Returns the string representation of the event,
   * depending on the type of event.
   *
   * @return A string representing the event.
   */
  @Override
  public String toString() {
    return super.toString();
  }

  /**
   * The logic that the simulation should follow when simulating
   * this event.
   *
   * @return An array of new events to be simulated.
   */
  @Override
  public Event[] simulate() {
    return new Event[] {};
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public void setCounter(Counter counter) {
    this.counter = counter;
  }

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Counter getCounter() {
    return counter;
  }

  public Bank getBank() {
    return bank;
  }
}
