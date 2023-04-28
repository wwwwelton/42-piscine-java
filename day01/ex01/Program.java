public class Program {
  public static void main(String args[]) {
    User john = new User("John", 100);
    User doe = new User("Doe", 100);
    User paul = new User("Paul", 100);
    System.out.println(john.getName() + " ID is " + john.getIdentifier());
    System.out.println(doe.getName() + "  ID is " + doe.getIdentifier());
    System.out.println(paul.getName() + " ID is " + paul.getIdentifier());

    System.exit(0);
  }
}
