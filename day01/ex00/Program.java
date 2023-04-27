public class Program {
  public static void main(String args[]) {
    User john = new User(1, "John", 100);
    User doe = new User(2, "Doe", 100);
    System.out.println(john.getName() + "'s " + "balance " + john.getBalance());
    System.out.println(doe.getName() + "'s " + "balance " + doe.getBalance());

    Transaction t1 = new Transaction(john, doe, Transaction.Category.CREDIT, 100);
    Transaction t2 = new Transaction(john, doe, Transaction.Category.DEBIT, -100);
    System.out.println("Transaction 1 amount: " + t1.getAmount());
    System.out.println("Transaction 2 amount: " + t2.getAmount());

    System.out.println(john.getName() + "'s " + "balance " + john.getBalance());
    System.out.println(doe.getName() + "'s " + "balance " + doe.getBalance());

    System.exit(0);
  }
}
