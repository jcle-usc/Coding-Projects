import javax.swing.*; 
import java.awt.event.*; //KeyListener
import java.awt.*;

//KeyListener:
//https://docs.oracle.com/javase/tutorial/uiswing/events/keylistener.html
//https://www.youtube.com/watch?v=BJ7fr9XwS2o

public class Key extends JFrame implements KeyListener 
{    
    private Block b; 

    public Key(Block block)
    {
        b = block; //Key takes ANY of the seven blocks passed as a Block object
    }
        
    public void keyTyped(KeyEvent e)
    {
        switch(e.getKeyChar())
        {
            case 'c': //holds block
            //not coded yet
                break;
        }
    }
    
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case 37: //left
                b.moveLeft();
                break;
            case 39: //right
                b.moveRight();
                break;
            case 38: //up
                b.rotate();
                break;
            case 40: //down
                b.moveDown();
            case 32: //space 
                b.place(); //not coded yet
        }
    }
    
    public void keyReleased(KeyEvent e)
    {  
        
    }
}