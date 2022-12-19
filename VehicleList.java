import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import javax.swing.*;
import java.io.*;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.*; 


class VehicleList {

  private static ArrayList<String[]> list = new ArrayList<String[]>(); 
  private static String[][] array;
  private static ArrayList<Vehicle> vehicleList;
  private static ArrayList<Vehicle> sedans = new ArrayList<>();
  private static ArrayList<Vehicle> SUVs = new ArrayList<>();
  private static ArrayList<Vehicle> trucks = new ArrayList<>();
  private static ArrayList<Vehicle> coupes = new ArrayList<>();

  private static final VehicleList INSTANCE = new VehicleList();

  private VehicleList(){

    this.vehicleList = new ArrayList<>();

    setList();
    makeInd();
    
  }

  public static VehicleList getInstance(){
    return INSTANCE;
  }

  public void remove(Vehicle car){
    vehicleList.remove(car);
    
    if (car.getCategory() == Vehicle.Categories.SEDAN){
      sedans.remove(car);
    }
    else if (car.getCategory() == Vehicle.Categories.SUV){
      SUVs.remove(car);
    }
    else if (car.getCategory() == Vehicle.Categories.TRUCK){
      trucks.remove(car);
    }
    else if (car.getCategory() == Vehicle.Categories.COUPE){
      coupes.remove(car);
    }
    else {
      System.out.println("Problem");
    }
  }

  public void setList(){
    String[][] readArray = read();

    for (int i = 1; i < readArray.length; i++){
      vehicleList.add(transform(i, readArray));
    }
  }

  public ArrayList<Vehicle> getSedans(){
    return sedans;
  }
  public ArrayList<Vehicle> getSUVs(){
    return SUVs;
  }
  public ArrayList<Vehicle> getTrucks(){
    return trucks;
  }
  public ArrayList<Vehicle> getCoupes(){
    return coupes;
  }

  public void makeInd(){
    for (Vehicle car: vehicleList){
      if (car.getCategory() == Vehicle.Categories.SEDAN){
        sedans.add(car);
      }
      else if (car.getCategory() == Vehicle.Categories.SUV){
        SUVs.add(car);
      }
      else if (car.getCategory() == Vehicle.Categories.TRUCK){
        trucks.add(car);
      }
      else if (car.getCategory() == Vehicle.Categories.COUPE){
        coupes.add(car);
      }
      else {
        System.out.println("Problem");
      }
    }
  }
  
  public static String[][] read(){
    String path = "CarData.csv";
    String line = "";
       
    try
    {
      BufferedReader br = new BufferedReader(new FileReader(path));

      while((line = br.readLine()) != null) {
        list.add(line.split(",")); //ARRAY IS HERE
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    array = new String[list.size()][0];
    list.toArray(array);  

    return array;
    
  }

  public Vehicle transform(int index, String[][] array){

    int year = Integer.valueOf(array[index][0]);
    String name = array[index][1];
    Vehicle.Colours color;


    switch(array[index][2]){
      case "Silver": color = Vehicle.Colours.SILVER; break;
      case "White": color = Vehicle.Colours.WHITE; break;
      case "Blue": color = Vehicle.Colours.BLUE; break;
      case "Black": color = Vehicle.Colours.BLACK; break;
      case "Gray": color = Vehicle.Colours.GRAY; break;
      case "Orange": color = Vehicle.Colours.ORANGE; break;
      case "Red": color = Vehicle.Colours.RED; break;
      case "Brown": color = Vehicle.Colours.BROWN; break;
      case "Green": color = Vehicle.Colours.GREEN; break;
      case "Pink": color = Vehicle.Colours.PINK; break;
      default: System.out.println("Invalid"); color = Vehicle.Colours.PINK;
    }

    String engineName = array[index][3];

    int cylindersnum = Integer.valueOf(array[index][4]);

    Vehicle.Categories cat;

    switch(array[index][5]){
      case "Sedan": cat = Vehicle.Categories.SEDAN; break;
      case "SUV": cat = Vehicle.Categories.SUV; break;
      case "Coupe": cat = Vehicle.Categories.COUPE; break;
      case "Hatchback": cat = Vehicle.Categories.HATCHBACK; break;
      case "Truck": cat = Vehicle.Categories.TRUCK; break;

      default: System.out.println("Invalid"); cat = Vehicle.Categories.TRUCK;
    }

    int price = Integer.valueOf(array[index][6]);
    int age =  Integer.valueOf(array[index][9]);

    Vehicle.Types type;

    switch(array[index][7]){
      case "New": type = Vehicle.Types.NEW; break;
      case "Used": type = Vehicle.Types.USED; break;
      default: System.out.println("Invalid"); type = Vehicle.Types.USED;
    }

    Vehicle.Statuses stat;

    switch(array[index][8]){
      case "Demo": stat = Vehicle.Statuses.DEMO; break;
      case "Stock": stat = Vehicle.Statuses.STOCK; break;

      default: System.out.println("Invalid"); stat = Vehicle.Statuses.STOCK;
    }

    return new Vehicle(year, name, color, engineName, cylindersnum, cat, price, type, stat, age);

  }

}