abstract class Person{
  
  public String username;
  public boolean canBuy;


  public String getUsername(){ 
    return username;
  }

  public void setUsername(String user){ 
    this.username = user;
  }

  public void setCanBuy(boolean can){
    this.canBuy = can;
  }

  public boolean getCanBuy(){
    return canBuy;
  }
}