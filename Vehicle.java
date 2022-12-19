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

// Main vehicle class
public class Vehicle{
// ARRAY LIST HERE
  
  
  public enum Categories{
    SEDAN, SUV, COUPE, HATCHBACK, TRUCK; // model of vehicles
  }

  public enum Colours{
    SILVER, WHITE, BLUE, BLACK, GRAY, ORANGE, RED, BROWN, GREEN, PINK; // Colour of vehicles
  }

  public enum Types{
    NEW, USED; // vehicle condition
  }

  public enum Statuses{
    DEMO, STOCK; // car status
  }

  private final Categories category;
  private final Colours colour;
  private final Types type;
  private final Statuses status;
  private final int year;
  private final String name;
  private final String engine;
  private final int cylinders;
  private final int price;
  private final int age;

  public Vehicle(int year, String name, Colours colour, String engine, int cylinders, Categories category, int price, Types type, Statuses status, int age){ // information of vehicles
    
    this.year = year; 
    this.name = name;
    this.colour = colour;
    this.engine = engine;
    this.cylinders = cylinders;
    this.category = category;
    this. price = price;
    this.type = type;
    this.status = status;
    this.age = age;

  }

  public int getYear(){ 
    return year;
  }
  public String getName(){
    return name;
  }
  public Colours getColour(){
    return colour;
  }
  public String getEngine(){
    return engine;
  }
  public int getCylinders(){
    return cylinders;
  }
  public Categories getCategory(){
    return category;
  }
  public int getPrice(){
    return price;
  }
  public Types getType(){
    return type;
  }
  public Statuses getStatus(){
    return status;
  }
  public int getAge(){
    return age;
  }

  public String carToString(){
    return year + name + colour + engine + cylinders + category + price + type + status + age;
    
  }

}
