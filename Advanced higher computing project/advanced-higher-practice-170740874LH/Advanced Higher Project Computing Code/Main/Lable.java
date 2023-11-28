package Main;

import java.awt.Font;

import javax.swing.JLabel;

public class Lable {

    public JLabel setLable(int x, int y, int width, int height, int sizeOfText, String text) {
        //x, y, width, height, sizeOfText, text

        JLabel tempLable = new JLabel(text);

        tempLable.setFont(new Font("Arial", Font.BOLD, sizeOfText));
        tempLable.setBounds(x,y,width,height);

        return tempLable;
    }
}
