public class User extends Person{
  private static final User INSTANCE = new User();

  private User(){

  }
  
  public static User getInstance(){
    return INSTANCE;
  }

}