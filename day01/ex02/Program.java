public class Program {
  public static void main(String args[]) {
    UsersArrayList users = new UsersArrayList();

    for (int i = 0; i < 20; i++) {
      users.addUser(new User("User" + Integer.toString(i + 1), 100 + i));
    }

    System.out.println("Search by index: ");
    for (int i = 0; i < 20; i++) {
      User user = users.getUserByIndex(i);
      System.out.println(user.getName() + " INDEX is " + i);
    }

    System.out.println();

    System.out.println("Search by ID: ");
    for (int i = 0; i < 20; i++) {
      User user = users.getUserById(i);
      System.out.println(user.getName() + " ID is " + user.getIdentifier());
    }

    System.out.println();

    try {
      User user = users.getUserById(20);
      System.out.println(user.getName() + " ID is " + user.getIdentifier());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    try {
      User user = users.getUserByIndex(-1);
      System.out.println(user.getName() + " ID is " + user.getIdentifier());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    System.exit(0);
  }
}
