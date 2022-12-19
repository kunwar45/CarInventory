import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class DisplayWindow extends JFrame implements ActionListener{ // display window created

  private JPanel panel;
  private JLabel lblTitle;
  private JButton btnBuy;
  private JButton btnBack;

  static Vehicle chosenVehicle = ChooseWindow.chosenVehicle;
  static Person client = InitialWindow.client;
  static VehicleList carList = VehicleList.getInstance();

  JTextArea txtDisplay;


  public DisplayWindow(){ // display panel added

    super("Display Window"); // display window shown on screen

    panel = new JPanel(); // create new Jpanel
    panel.setLayout(null);
    panel.setBackground(new Color(176,216,230)); 
    add(panel); // panel added

    txtDisplay = new JTextArea(chosenVehicle.carToString()); // new Jtextarea created
    txtDisplay.setBounds(215, 85, 200, 225); // set frame size
    panel.add(txtDisplay); //

    btnBuy = new JButton("BUY"); // button user created
    btnBuy.setBounds(260, 350, 90, 50); // set frame size
    btnBuy.setActionCommand("Buy");
    btnBuy.addActionListener(this);
    panel.add(btnBuy); // button added to screen

    btnBack = new JButton("Back"); // button user created
    btnBack.setBounds(0, 350, 90, 50); // set frame size
    btnBack.setActionCommand("Back");
    btnBack.addActionListener(this);
    panel.add(btnBack); // button added to screen
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    switch (e.getActionCommand()){
      case "Buy":
        if (client.getCanBuy()){
          carList.remove(chosenVehicle);
        }
        else {
          System.out.println("You do not have authority to buy");
        }
        break;
      case "Back":
        ChooseWindow myFrame = new ChooseWindow(); // create LabelFrame
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(600, 500); // set frame size
        myFrame.setVisible(true); // display frame
        this.dispose();
        
    }

    
  }
}