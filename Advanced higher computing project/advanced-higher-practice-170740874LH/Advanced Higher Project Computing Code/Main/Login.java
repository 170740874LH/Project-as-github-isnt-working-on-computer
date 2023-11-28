package Main; 
import Inputs.ButtonInputs;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Scanner;
public class Login {
    private static GameWindow gameWindow;
    private static GamePanel gamePanel;

    private static Scanner keyboard = new Scanner(System.in);

    private static JLabel userNameLabel;
    private static JLabel passwordLabel;

    private static ButtonInputs buttonInputsFormat;

    private static JButton createAccountButton;
    public static boolean loginStage;
    private static String userName = "";
    private static String password = "";
        //true = username
        //false = password
        private static boolean loginProgress = true;

    private static String currentLogin = "";
    Login () {
        loginStage = true;
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();

        Button buttonFormat = new Button();
        buttonInputsFormat = new ButtonInputs(this);
        //x,y,width,height,textInButton,textColour,backgroundColour,visible
        createAccountButton = buttonFormat.setButton(50,550,450,150,"Create Account",Color.RED,Color.BLACK,true);
        buttonInputsFormat.addButtonToList(createAccountButton);
        gamePanel.add(createAccountButton);

        Lable labelFormat = new Lable();
        //x, y, width, height, sizeOfText, text
        userNameLabel = new JLabel();
        passwordLabel = new JLabel();

            userNameLabel = labelFormat.setLable(50, 250, 250, 50, 28,"UserName = ");
            passwordLabel = labelFormat.setLable(400, 250, 250, 50, 28,"Password = ");
        
        gamePanel.add(userNameLabel);
        gamePanel.add(passwordLabel);

        gamePanel.repaint();
                validateLogin();
    }
    public static GamePanel getPanel () {
        return gamePanel;
    }
   
    public static void displayCurrentLoginOnScreen () {

        
            if (loginProgress) {
                userNameLabel.setText("UserName = " + currentLogin);
            }
            else {
                passwordLabel.setText("Password = " + currentLogin);
            }

        gamePanel.repaint();

    }
    public static void validateLogin () {
        //checks login with database


            //need to change indented stuff as used it to skip login every time
            boolean validLogin = true;
        if (userName.equals("moo") && password.equals("baa")) {
            System.out.println("user " + userName + " password " + password);

            validLogin = true;
        }
            // else {
            //     validLogin = false;
            //     System.out.println("user " + userName + " password " + password);

            // }
        if (validLogin) {
            loginStage = false;
            gamePanel.remove(userNameLabel);
            gamePanel.remove(passwordLabel);
            gamePanel.repaint();
            createAccountButton.setVisible(!validLogin);
            HomePage game = new HomePage(gameWindow,gamePanel,buttonInputsFormat); 
        }
        else {
            userNameLabel.setText("UserName = ");
            passwordLabel.setText("Password = ");
            gamePanel.repaint();



            gamePanel.setBackground(Color.RED);

            loginProgress = true;
            
        }
    }
    public static void createAccount () {
        System.out.println("Please enter username (only use lowercase letters and letters)");
        String newUserName = keyboard.next();
        System.out.println("Please enter password (only use lowercase letters and letters and length has to be greater than 5)");
        String newPassword = keyboard.next();
        validateNewAccount(newUserName,newPassword);
        System.out.println("user Login Saved please sign in");
        //send account details to database

    }   
    private static void validateNewAccount (String userName, String password) {
        if (password.length() < 5) {
            createAccount();
        }
        for (int i = 0; i < userName.length(); i++) {
            if (((int)userName.charAt(i) >= 97 && (int)userName.charAt(i) <= 122) 
                || ((int)userName.charAt(i)) >= 48 && (int)userName.charAt(i) <= 57) {
                
            }
            else {
                createAccount();
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (((int)password.charAt(i) >= 97 && (int)password.charAt(i) <= 122) 
                || ((int)password.charAt(i)) >= 48 && (int)password.charAt(i) <= 57) {
                
            }
            else {
                createAccount();
            }
        }
    } 
    public static void giveLoginCharacter(char key) {
        gamePanel.setBackground(null);
        //10 = enter
        if ((int) key == 10 ) {
            if (loginProgress) {
                userName = currentLogin;

                currentLogin = "";


                loginProgress = false;
            }
            else {
                password = currentLogin;
                currentLogin = "";
                validateLogin();
            }
        }
        else {
            currentLogin = currentLogin + key;
            displayCurrentLoginOnScreen();

        }
    }
}
