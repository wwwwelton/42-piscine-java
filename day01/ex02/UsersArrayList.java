public class UsersArrayList implements UsersList {
  private User[] users;
  private Integer size;
  private Integer index;

  public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
      super(message);
    }
  }

  public UsersArrayList() {
    this.users = new User[10];
    this.size = 10;
    this.index = 0;
  }

  public void addUser(User user) {
    if (index == size) {
      size += size / 2;
      User[] tmp = new User[size];
      System.arraycopy(users, 0, tmp, 0, index);
      users = tmp;
    }
    this.users[index] = user;
    index++;
  }

  public User getUserById(Integer ID) {
    for (int i = 0; i < size; i++) {
      if (users[i] == null) {
        continue;
      }
      if (users[i].getIdentifier() == ID) {
        return users[i];
      }
    }
    throw new UserNotFoundException("User not found.");
  }

  public User getUserByIndex(Integer index) {
    if (index > (size - 1) || index < 0 || this.users[index] == null) {
      throw new UserNotFoundException("User not found.");
    }
    return this.users[index];
  }

  public Integer getUsersAmount() {
    return this.index + 1;
  }
}
