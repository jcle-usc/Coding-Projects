/*
 * initially had the setLocation (now setBounds) code in this method using switch case for each type of block (this was before i made a Block interface)
 * took a VERY long time to get the BlockI JLabel somewhat working before I could move onto the other blocks
*/

import javax.swing.*; 
import java.awt.event.*;
import java.awt.*;

public class KeyJLabel extends JFrame implements KeyListener 
{   
    private int rotate;
    
    public KeyJLabel()//JLabel block, char blockType)
    {
        //rotate = 0;
    }
        
    public void keyTyped(KeyEvent e)
    {
        /*
        switch(e.getKeyChar())
        {
            case 'c': //hold
                break;
        }
        */
    }
    
    public void keyPressed(KeyEvent e)
    {
        /*
        switch(e.getKeyCode())
        {
            case 37: //left
                switch(type)
                {
                    case 'I':
                        if (b.getX() > 585) 
                        {
                            b.setLocation(b.getX() - 35, b.getY());
                            BlockI.col--;
                        }
                        //System.out.println(b.getX());
                        break;
                }
                break;
            case 39: //right
                switch(type)
                {
                    case 'I':
                        if (b.getX() < 795 && rotate % 2 == 0) 
                        {
                            b.setLocation(b.getX() + 35, b.getY());
                            BlockI.col++;
                        }
                        else if (b.getX() < 900 && rotate % 1 == 0 && rotate != 0)
                        {    
                            b.setLocation(b.getX() + 35, b.getY());
                            BlockI.col++;
                        }
                        //System.out.println(b.getX());
                        break;
                }
                break;
            case 38: //up
                switch(type)
                {
                    case 'I':
                        BlockI.rotate();
                        //System.out.println(rotate);
                        //rotate++;
                        break;
                }
            case 40: //down
            case 32: //space 
        }
        */
    }
    
    public void keyReleased(KeyEvent e)
    {  
        
    }
}
