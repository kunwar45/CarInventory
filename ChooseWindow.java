import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.*; 



// This is where the user or admin will be able to choose what vehicle they want to either buy or view


public class ChooseWindow extends JFrame implements ActionListener{
  
  JPanel panel;
  JButton btnSedan;
  JButton btnTruck;
  JButton btnSUV;
  JButton btnCoupe;
  JButton btnHatchback;
  JPanel pnlFirst;
  JPanel pnlSedan;
  JPanel pnlSUV;
  JPanel pnlTruck;
  JPanel pnlCoupe;

  JTextArea txtDisplay;
  
  JTextField choice1;
  JTextField choice2;
  JTextField choice3;
  JTextField choice4;

  public static ArrayList<Vehicle> typeList;

  public static Vehicle chosenVehicle;
  private int num;
  private Container base;
  private CardLayout layout = new CardLayout(); // create new cardlayout
  private JButton btnSubmit1; // button for submit 
  private JButton btnSubmit2;
  private JButton btnSubmit3;
  private JButton btnSubmit4;


  static VehicleList carList = VehicleList.getInstance(); // car list created


  public ChooseWindow(){

    super("Choose Window"); // Set frame 

    base = getContentPane();
    base.setLayout(layout);

    pnlFirst = First();
    pnlSedan = Sedan();
    pnlSUV = SUV();
    pnlTruck = Truck();
    pnlCoupe = Coupe();

    base.add(pnlFirst, "first"); 
    base.add(pnlSedan, "sedan"); // sedan panel added
    base.add(pnlSUV, "SUV"); // suv panel added
    base.add(pnlTruck, "truck"); // truck panel added
    base.add(pnlCoupe, "coupe"); // coupe panel added

    layout.show(base, "first");
    
  }

    public JPanel First(){ // vehicle category panel
    JPanel panel = new JPanel(); // create new Jpanel
    panel.setLayout(null);
    panel.setBackground(new Color(176,216,230)); // set frame size
    add(panel); // panel added

    btnSedan = new JButton(new ImageIcon("Images/category_sedan.png")); // button sedan created 
    btnSedan.setBounds(33, 25, 250, 200); // set frame size
    btnSedan.setActionCommand("Sedan");
    btnSedan.addActionListener(this);
    panel.add(btnSedan); // button added to screen

    btnTruck = new JButton(new ImageIcon("Images/category_truck.png")); // button truck created
    btnTruck.setBounds(33, 250, 250, 200); // set frame size
    btnTruck.setActionCommand("Truck");
    btnTruck.addActionListener(this);
    panel.add(btnTruck); // button added to screen

    btnSUV = new JButton(new ImageIcon("Images/category_suv.png")); // button suv created
    btnSUV.setBounds(313, 25, 250, 200); // set frame size
    btnSUV.setActionCommand("SUV");
    btnSUV.addActionListener(this);
    panel.add(btnSUV); // button added to screen

    btnCoupe = new JButton(new ImageIcon("Images/category_coupe.png")); // button coupe created
    btnCoupe.setBounds(313, 250, 250, 200); // set frame size
    btnCoupe.setActionCommand("Coupe");
    btnCoupe.addActionListener(this);
    panel.add(btnCoupe); // button added to screen

    return panel;
  }

  public JPanel Sedan(){ // sedan panel created 
  
    JPanel panel = new JPanel(); // create new Jpanel
    panel.setLayout(null);
    panel.setBackground(new Color(176,216,230)); // set frame size
    add(panel); // panel added
// 
    txtDisplay = new JTextArea(displayList(carList.getSedans())); // new Jtextarea created
    txtDisplay.setBounds(215, 85, 175, 225); // set frame size
    panel.add(txtDisplay); // sedan display list added on screen

    choice1 = new JTextField(20); //user input here
    choice1.setBounds(230, 320, 150, 25); // set frame size
    panel.add(choice1); // text panel added to screen

    btnSubmit1 = new JButton("Submit"); // button user created
    btnSubmit1.setBounds(260, 350, 90, 50); // set frame size
    btnSubmit1.setActionCommand("Submit1");
    btnSubmit1.addActionListener(this);
    panel.add(btnSubmit1); // button added to screen

    return panel;

  }

  public JPanel SUV(){ // suv panel created
    JPanel panel = new JPanel(); // create new Jpanel
    panel.setLayout(null);
    panel.setBackground(new Color(176,216,230)); 
    add(panel);

    txtDisplay = new JTextArea(displayList(carList.getSUVs())); // new Jtextarea created
    txtDisplay.setBounds(215, 85, 175, 225); // set frame size
    panel.add(txtDisplay); // suv display list added on screen

    choice2 = new JTextField(20); //user input here
    choice2.setBounds(230, 320, 150, 25); // set frame size
    panel.add(choice2); // text panel added to screen

    btnSubmit2 = new JButton("Submit"); // button user created
    btnSubmit2.setBounds(260, 350, 90, 50); // set frame size
    btnSubmit2.setActionCommand("Submit2");
    btnSubmit2.addActionListener(this);
    panel.add(btnSubmit2); // button added to screen

    return panel;

  }

  public JPanel Truck(){ // truck panel created
    JPanel panel = new JPanel(); // create new Jpanel
    panel.setLayout(null);
    panel.setBackground(new Color(176,216,230)); 
    add(panel);

    txtDisplay = new JTextArea(displayList(carList.getTrucks())); // new Jtextarea created
    txtDisplay.setBounds(215, 85, 175, 225); // set frame size
    panel.add(txtDisplay); // truck display list added on screen

    choice3 = new JTextField(20); //user input here
    choice3.setBounds(230, 320, 150, 25); // set frame size
    panel.add(choice3); // text panel added to screen

    btnSubmit3 = new JButton("Submit"); // button user created
    btnSubmit3.setBounds(260, 350, 90, 50); // set frame size
    btnSubmit3.setActionCommand("Submit3");
    btnSubmit3.addActionListener(this);
    panel.add(btnSubmit3); // button added to screen

    return panel;

  }

  public JPanel Coupe(){ // coupe panel created
    JPanel panel = new JPanel(); // create new Jpanel
    panel.setLayout(null);
    panel.setBackground(new Color(176,216,230)); // set frame size
    add(panel); 

    txtDisplay = new JTextArea(displayList(carList.getCoupes())); // new Jtextarea created
    txtDisplay.setBounds(215, 85, 175, 225); // set frame size
    panel.add(txtDisplay); 
    // coupe display list added on screen

    choice4 = new JTextField(20); //user input here
    choice4.setBounds(230, 320, 150, 25); // set frame size
    panel.add(choice4); // text panel added to screen

    btnSubmit4 = new JButton("Submit"); // button user created
    btnSubmit4.setBounds(260, 350, 90, 50); // set frame size
    btnSubmit4.setActionCommand("Submit4");
    btnSubmit4.addActionListener(this);
    panel.add(btnSubmit4); // button added to screen

    return panel;

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()){
      case "Sedan":
        typeList = carList.getSedans();
        
        layout.show(base, "sedan");
        break;
      case "Truck":
        typeList = carList.getTrucks();
        layout.show(base, "truck");
        break;
      case "SUV":
        typeList = carList.getSUVs();
        layout.show(base, "SUV");
        break;
      case "Coupe":
        typeList = carList.getCoupes();
        layout.show(base, "coupe");
        break;
      case "Submit1":
        try {

          num = Integer.parseInt(choice1.getText()); 
          if (num > typeList.size()){
            System.out.println("Too Big");
          }
          else {
            chosenVehicle = typeList.get(num-1);
            System.out.println(chosenVehicle.getName());

            DisplayWindow myFrame = new DisplayWindow(); // create LabelFrame
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.setSize(600, 500); // set frame size
            myFrame.setVisible(true); // display frame
            this.dispose();
          }

        } catch (NumberFormatException ex) {
          System.out.println("Wrong num");
        }
        break;
      case "Submit2":
        try {

          num = Integer.parseInt(choice2.getText()); 
          if (num > typeList.size()){
            System.out.println("Too Big");
          }
          else {
            chosenVehicle = typeList.get(num-1);
            System.out.println(chosenVehicle.getName());

            DisplayWindow m = new DisplayWindow(); // create LabelFrame
            m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            m.setSize(600, 500); // set frame size
            m.setVisible(true); // display frame
            this.dispose();
          }

        } catch (NumberFormatException ex) {
          System.out.println("Wrong num");
        }
        break;
      case "Submit3":
        try {

          num =Integer.parseInt(choice3.getText()); 
          if (num > typeList.size()){
            System.out.println("Too Big");
          }
          else {
            chosenVehicle = typeList.get(num-1);
            System.out.println(chosenVehicle.getName());

            DisplayWindow f = new DisplayWindow(); // create LabelFrame
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(600, 500); // set frame size
            f.setVisible(true); // display frame
            this.dispose();
          }

        } catch (NumberFormatException ex) {
          System.out.println("Wrong num");
        }
        break;
      case "Submit4":
        try {

          num = Integer.parseInt(choice4.getText()); 
          if (num > typeList.size()){
            System.out.println("Too Big");
          }
          else {
            chosenVehicle = typeList.get(num-1);
            System.out.println(chosenVehicle.getName());

            DisplayWindow r = new DisplayWindow(); // create LabelFrame
            r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            r.setSize(600, 500); // set frame size
            r.setVisible(true); // display frame
            this.dispose();
          }

        } catch (NumberFormatException ex) {
          System.out.println("Wrong num");
        }
        break;
    }

  }

  public static String displayList (ArrayList<Vehicle> list){ // displays lists of vehicle type chosen

    String displayString = "";
    int i = 1; 

    for (Vehicle car: list){ // displays types of car 
      displayString += i + ". " + car.getName() + "\n";
      i++;
    }

    return displayString;
  }

}