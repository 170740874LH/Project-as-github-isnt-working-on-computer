package Inputs;
import Main.Login;
import Main.HomePage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class ButtonInputs implements ActionListener{

    private static Login login;
    private HomePage homePage;
    ArrayList <JButton> buttonArray = new ArrayList<JButton>();
    int buttonIndex = 0;
    public ButtonInputs (Login login) {
        this.login = login;

    }
    public void addHomePageClass (HomePage homePage) {
        this.homePage = homePage;
    }
    public void addButtonToList (JButton tempButton) {
        buttonArray.add(tempButton);
        buttonArray.get(buttonIndex).addActionListener(this);
        buttonIndex++;

    }
    //button 0 = create account button
    //button 1 = games button
    //button 2 = leaderboard button

    //button 3 = game 1 button
    //button 4 = game 2 button

    //button 5 = game 1 leaderboard button
    //button 6 = game 2 leaderboard button

    @Override
    public void actionPerformed(ActionEvent e) {
        
            if (e.getSource() == buttonArray.get(0)) {
                System.out.println("moo");
                createAccountButtonPressed();
            }
            else if (e.getSource() == buttonArray.get(1)) {
                homePage.gamePageButtonPressed();
            }
            else if(e.getSource() == buttonArray.get(2)) {
                homePage.leaderboardButtonPressed();
            }
            else if(e.getSource() == buttonArray.get(3)) {
                homePage.game1ButtonPressed();
            }
    }
    
    public void createAccountButtonPressed () {
        login.createAccount();
    }
}
