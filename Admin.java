public class Admin extends Person {

  private static final Admin INSTANCE = new Admin(); // new admin created
  
  private Admin(){

  }

  private Admin(String user){ 
    this.username = user; // admin enters username
  }

  public void Buy(int balance, int price,
   Vehicle.Statuses stat){
    if (price > balance){ // if price is less then admins balance
      System.out.println("This car cannot be bought");
    }
    else {
      System.out.println("E"); // admin can buy vehicle
    }
  }

  public static Admin getInstance(){
    return INSTANCE;
  }

}