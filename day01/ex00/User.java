public class User {
  private Integer identifier;
  private String name;
  private Integer balance;

  public User(Integer identifier, String name, Integer balance) {
    this.identifier = identifier;
    this.name = name;
    setBalance(balance);
  }

  public Integer getIdentifier() {
    return this.identifier;
  }

  public String getName() {
    return this.name;
  }

  public Integer getBalance() {
    return this.balance;
  }

  public void setBalance(Integer balance) {
    if (balance < 0) {
      throw new IllegalArgumentException("Balance cannot be negative.");
    }
    this.balance = balance;
  }

  public void addTransaction(Integer amount) {
    if (amount < 0) {
      if (this.balance + amount < 0) {
        throw new IllegalArgumentException("Insufficient funds.");
      }
    }
    setBalance(this.balance + amount);
  }
}
