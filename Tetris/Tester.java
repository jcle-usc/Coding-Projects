import javax.swing.*; //for JFrame
import java.awt.*; //for Graphics and Container

public class Tester
{  
    public static void main (String[] args) //run code
    {
        //JFrame:
        //https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html
        
        JFrame win = new JFrame("Tetris"); //JFrame Graphics setup

        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes window
        win.setSize(1520,950); //size of the terminal (x, y)
        win.setLocationRelativeTo(null); //center window

        Grid grid = new Grid(); //JPanel
        win.add(grid); //JPanel Grid added to the JFrame
        
        win.setVisible(true); //make the terminal visible
        
        Tetris game = new Tetris(grid);
        game.runGame(); //starts game
    }
}