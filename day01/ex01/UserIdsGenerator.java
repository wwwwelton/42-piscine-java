public class UserIdsGenerator {
  private static UserIdsGenerator instance = null;
  private Integer identifier = 0;

  private UserIdsGenerator() {}

  public static synchronized UserIdsGenerator getInstance() {
    if (instance == null) {
      instance = new UserIdsGenerator();
    }
    return instance;
  }

  public Integer generateId() {
    return identifier++;
  }
}
