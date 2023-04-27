import java.util.UUID;

public class Transaction {
  public enum Category {
    CREDIT, DEBIT
  };

  private UUID identifier;
  private User recipient;
  private User sender;
  private Category category;
  private Integer amount;

  public Transaction(User recipient, User sender, Category category,
      Integer amount) {
    this.identifier = UUID.randomUUID();
    this.recipient = recipient;
    this.sender = sender;
    this.category = category;
    if (amount < 0 && category == Category.CREDIT) {
      throw new IllegalArgumentException("Credit transactions cannot have negative amounts.");
    } else if (amount > 0 && category == Category.DEBIT) {
      throw new IllegalArgumentException("Debit transactions cannot have positive amounts.");
    }
    this.amount = amount;
    if (category == Category.CREDIT) {
      recipient.addTransaction(amount);
      sender.addTransaction(amount * -1);
    } else {
      recipient.addTransaction(amount);
      sender.addTransaction(amount * -1);
    }
  }

  public UUID getIdentifier() {
    return this.identifier;
  }

  public User getRecipient() {
    return this.recipient;

  }

  public User getSender() {
    return this.sender;
  }

  public Category getCategory() {
    return this.category;
  }

  public Integer getAmount() {
    return this.amount;
  }
}
