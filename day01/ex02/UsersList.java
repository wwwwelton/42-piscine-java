public interface UsersList {
  public void addUser(User user);

  public User getUserById(Integer ID);

  public User getUserByIndex(Integer index);

  public Integer getUsersAmount();
}
