import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class InitialWindow extends JFrame implements ActionListener{

  private JPanel pnlInitial;
  private JPanel pnlAdmin;
  private JPanel pnlUser;
  private JLabel lblTitle;
  private JButton btnUser;
  private JButton btnAdmin;
  private JButton btnLogin;
  private JButton titleImage;
  private JLabel lblUsername;
  private JLabel lblUsernameError;
  private JLabel lblPassword;
  private JLabel lblPasswordError;
  private JTextField txtUserName;
  private JPasswordField txtPassword;


  private JLabel lblUsernameError2;

  private JTextField txtUserName2;
  

  private final String pass = "password";

  public static Person client; 

  private Container base;
  private CardLayout layout = new CardLayout(); // create new cardlayout

  public InitialWindow(){

    super("Initial Window");

    base = getContentPane();
    base.setLayout(layout);
    base.setBackground(new Color(176,216,230)); 
    
    pnlInitial = initialPanel();
    pnlAdmin = adminPanel();
    pnlUser = userPanel();

    base.add(pnlInitial, "initial"); // initial panel
    base.add(pnlAdmin, "admin"); // admin button
    base.add(pnlUser, "user"); // user button

    layout.show(base, "initial");

    

  }

  public JPanel initialPanel(){ //initial panel created

    JPanel panel = new JPanel(); // create new Jpanel
    panel.setLayout(null);
    panel.setBackground(new Color(176,216,230)); 
    add(panel); // panel added
    

    lblTitle = new JLabel("Welcome to Barrhaven Hyundai!"); // title created
    lblTitle.setBounds(120, 50, 500, 40); // set frame size
    lblTitle.setFont(new Font("Serif", Font.BOLD,20)); 
    panel.add(lblTitle); // titel panel added

    btnUser = new JButton("User"); // button user created
    btnUser.setBounds(350, 300, 80, 50); // set frame size
    btnUser.setActionCommand("User");
    btnUser.addActionListener(this);
    panel.add(btnUser); // button added to screen

    btnAdmin = new JButton("Admin"); // button admin created
    btnAdmin.setBounds(150, 300, 80, 50); // set frame size
    btnAdmin.setActionCommand("Admin");
    btnAdmin.addActionListener(this);
    panel.add(btnAdmin); // button added to screen

    titleImage = new JButton(new ImageIcon("Images/mainScreenImage.png"));
    titleImage.setBounds(145, 100, 300, 150);
    panel.add(titleImage);

    


    /*
    category_2 = new JButton(new ImageIcon("Jeopardy Project Images/VideoGames.png"));
    category_2.setBounds(175, 50, 150, 70);
    panel.add(category_2);
    */
    return panel;
  }

  public JPanel adminPanel(){ // admin panel created
    
    JPanel panel = new JPanel(); // create new Jpanel
    panel.setLayout(null);
    panel.setBackground(new Color(176,216,230)); 
    add(panel); // panel added

    lblUsername = new JLabel("Enter Your Username"); // username created
    lblUsername.setBounds(223, 30, 150, 25); // set frame size
    panel.add(lblUsername); // button added to screen

    lblUsernameError = new JLabel("   "); 
    lblUsernameError.setBounds(215, 100, 3000, 25); // set frame size
    lblUsernameError.setFont(new Font("Serif", Font.PLAIN, 12));
    lblUsernameError.setForeground(Color.RED);
    panel.add(lblUsernameError); // button added to screen 

    txtUserName = new JTextField(20); // new Jtextfield created
    txtUserName.setBounds(225, 75, 150, 25); // set frame size
    panel.add(txtUserName); // button added to screen

    lblPassword = new JLabel("Enter The Password"); // new Jlabel created
    lblPassword.setBounds(223, 150, 3000, 25); // set frame size
    panel.add(lblPassword); // button added to screen

    lblPasswordError = new JLabel("   "); 
    lblPasswordError.setBounds(215, 215, 3000, 25); // set frame size
    lblPasswordError.setFont(new Font("Serif", Font.PLAIN, 12));
    lblPasswordError.setForeground(Color.RED);
    panel.add(lblPasswordError); // button added to screen

    txtPassword = new JPasswordField(20); // new JPasswordField created
    txtPassword.setBounds(225, 185, 150, 25); // set frame size
    panel.add(txtPassword); // button added to screen

    btnLogin = new JButton("Login"); // new Jbutton created
    btnLogin.setBounds(250, 400, 80, 50); // set frame size
    btnLogin.setActionCommand("Login");
    btnLogin.addActionListener(this);
    panel.add(btnLogin); // button added to screen

    return panel;

  }

  public JPanel userPanel(){ // user panel created
    
    JPanel panel = new JPanel(); // new Jpanel created
    panel.setLayout(null);
    panel.setBackground(new Color(176,216,230)); 
    add(panel); // panel added to screen

    lblUsername = new JLabel("Enter Your Username"); // new Jlabel created
    lblUsername.setBounds(223, 30, 150, 25); // set frame size
    panel.add(lblUsername); // button added to screen

    lblUsernameError2 = new JLabel("   ");
    lblUsernameError2.setBounds(215, 100, 3000, 25); // set frame size
    lblUsernameError2.setFont(new Font("Serif", Font.PLAIN, 12));
    lblUsernameError2.setForeground(Color.RED);
    panel.add(lblUsernameError2);

    txtUserName2 = new JTextField(20); // new Jtextfield created
    txtUserName2.setBounds(225, 75, 150, 25); // set frame size
    panel.add(txtUserName2); // button added to screen
    
    btnLogin = new JButton("Login"); // new Jbutton created
    btnLogin.setBounds(210, 350, 80, 50); // set frame size
    btnLogin.setActionCommand("Login"); // login button created
    btnLogin.addActionListener(this);
    panel.add(btnLogin); // button added to screen

    return panel;

  }

  @Override
  public void actionPerformed(ActionEvent e) {

    switch (e.getActionCommand()){
      case "User":
        layout.show(base, "user");
        client = User.getInstance();
        client.setCanBuy(false);
        break;
      case "Admin":
        layout.show(base, "admin");
        client = Admin.getInstance();
        client.setCanBuy(true);

        break;
      case "Login":
        if(client.getCanBuy()){
          if (txtUserName.getText().isEmpty()){
            lblUsernameError.setText("Username cannot be empty!");
          }
          else {
            client.setUsername(txtUserName.getText());
            if (txtPassword.getText().isEmpty()){
              lblPasswordError.setText("Incorrect Password");
            }
            else if (!txtPassword.getText().equals(pass)){
              lblPasswordError.setText("Incorrect Password");
            }
            else {
              ChooseWindow myFrame = new ChooseWindow(); // create LabelFrame
              myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              myFrame.setSize(600, 500); // set frame size
              myFrame.setVisible(true); // display frame
              this.dispose();
            }
          }
        }
        else {
          if (txtUserName2.getText().isEmpty()){
            lblUsernameError2.setText("Username cannot be empty!");
          }
          else {
            client.setUsername(txtUserName2.getText());

            ChooseWindow myFrame = new ChooseWindow(); // create LabelFrame
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.setSize(600, 500); // set frame size
            myFrame.setVisible(true); // display frame
            this.dispose();
          }
        }



    }

  }

}