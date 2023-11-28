package Inputs;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;
import Main.Login;

public class KeyboardInputs implements KeyListener{
    private GamePanel panel;
    private Login loginPage;
    public KeyboardInputs (Login loginPage) {
        this.loginPage = loginPage;
    }
    

    @Override
    public void keyPressed(KeyEvent e) {
        panel = Login.getPanel();
              
        int keyCode = e.getKeyCode();
        if ((keyCode+32) >= 97 && (keyCode+32) <= 122 ) {
            keyCode += 32;
        }


        if (Login.loginStage) {
            
            Login.giveLoginCharacter(((char) keyCode));
        }
        
        else if (panel.gameOneMain.gameOneRunning) {
            
            panel.gameOneKeyPressed((char) keyCode);
             
        } 
    }
    public void hello () {
        System.out.println("hello");
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    
}