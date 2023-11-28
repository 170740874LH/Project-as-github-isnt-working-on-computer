package Main;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Button extends JButton{
    //x,y,width,height,textInButton,textColour,backgroundColour,visible
    public JButton setButton (int x, int y, int width, int height, String buttonName, Color text, Color background, boolean visible) { 
        JButton tempButton = new JButton();
        
        tempButton.setText(buttonName);  
        tempButton.setFont(new Font("Comic Sans",Font.BOLD,25)); 
        tempButton.setForeground(text); 
        tempButton.setBackground(background); 
        tempButton.setFocusable(false); 
        tempButton.setBounds(x, y, width, height); 
        tempButton.setVisible(visible);
        return tempButton;
    } 
}
