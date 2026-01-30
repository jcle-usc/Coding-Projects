import javax.swing.*; //for JFrame
import java.awt.*; // for Graphics
import javax.swing.Timer; //for Timer (block falling)
import java.awt.event.ActionEvent; //also for Timer
import java.awt.event.ActionListener; //also for Timer

//each block overrides interface Block methods
public class BlockI extends JPanel implements Block
{
    private Graphics g;
    private Timer fallTimer;
    private JPanel p;
    private Tetris t;
    private Key keyListener;
    private int rotate;
    private int row;
    private int col;

    public BlockI(JPanel tetris, Tetris tet)
    {
        setBounds(690,100,140,35);

        p = tetris;
        keyListener = new Key(this);
        p.addKeyListener(keyListener); //adds block to keyListener
        
        t = tet;

        rotate = 0;
        row = 0;
        col = 3;
    }
    
    //overriden method 
    protected void paintComponent(Graphics graphic)
    {
        g = graphic;

        super.paintComponent(g); //automatically called

        if (rotate % 2 == 0)
        {
            for (int i = 0; i < 4; i++)
            {
                g.setColor(new Color(0, 255, 255));
                g.fillRect(i * 35,0,35,35);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(i * 35,0,35,35);
            }
            
            //start at manual 2D grid tracking with a static grid
            /*
            if (rotate == 0 && row != 0)
            {
                for (int i = 0; i < 4; i++)
                {
                    Grid.grid[row - 1][col + i] = 0;
                    Grid.grid[row][col + i] = 1;
                }
            }
            else if (rotate == 2)
            {
                for (int i = 0; i < 4; i++)
                {
                    Grid.grid[row][col + i] = 0;
                    Grid.grid[row + 1][col + i] = 1;
                }
            }
            
            System.out.println();
            for (int row = 0; row < Grid.grid.length; row++)
            {
                for (int col = 0; col < Grid.grid[row].length; col++)
                {
                    System.out.print(Grid.grid[row][col]);
                }
                System.out.println();
            }
            */
        }
        else
        {
            for (int i = 0; i < 4; i++)
            {
                g.setColor(new Color(0, 255, 255));
                g.fillRect(0,i * 35,35,35);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(0,i * 35,35,35);
            }
        }
    }

    //Timer:
    //https://docs.oracle.com/javase/7/docs/api/javax/swing/Timer.html
    
    //initially done with try catch Thread.sleep, found many issues with lag, inconsistent block updates, and it would only produce two blocks since it couldn't update anymore
    public void startFalling()
    {
        fallTimer = new Timer(1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //block falls if it is above the bound of the bottom of the grid
                if (((getY() < 800 && rotate % 2 == 0) || (getY() < 695 && !(rotate % 2 == 0))))
                    moveDown();
                else
                {
                    fallTimer.stop();
                    t.blockPlaced(); //creates a new block after calling this method
                    p.removeKeyListener(keyListener); //confused on why after a block was "placed" the keyListener would move BOTH the new block and placed block, didn't know you had to REMOVE keyListener as you have to ADD it (who would've thought)
                }
            }
        });
        fallTimer.start();
    }

    public void moveLeft()
    {
        if (getX() > 585)
        {
            if (rotate % 2 == 0)
                setBounds(getX() - 35,getY(),140,35);
            else
                setBounds(getX() - 35,getY(),35,140);
        }
        col--;
        
        //repaint();
        //https://stackoverflow.com/questions/10768619/paint-and-repaint-in-java
        
        //method is already called, but logic is that it will creates new bounds and then repain within the new bounds
        repaint();
    }

    public void moveRight()
    {
        if (rotate % 2 == 0 && getX() < 795)
            setBounds(getX() + 35,getY(),140,35);
        else if (!(rotate % 2 == 0) && getX() < 900)
            setBounds(getX() + 35,getY(),35,140);
        col++;
        repaint();
    }

    public void moveDown()
    {
        if (rotate % 2 == 0 && getY() < 800)
            setBounds(getX(),getY() + 35,140,35);
        else if ((getY() < 695 && !(rotate % 2 == 0)))
            setBounds(getX(),getY() + 35,35,140);
        row++;
        repaint();
    }

    public void rotate()
    {
        switch (rotate)
        {
            case 0:
                setBounds(getX() + 70, getY() - 35, 35, 140);
                rotate++;
                break;
            case 1:
                setBounds(getX() - 70, getY() + 70, 140, 35);
                rotate++;
                break;
            case 2:
                setBounds(getX() + 35, getY() - 70, 35, 140);
                rotate++;
                break;
            case 3:
                setBounds(getX() - 35, getY() + 35, 140, 35);
                rotate = 0;
                break;
        }
        repaint();
    }

    public void place()
    {
        //not coded yet
    }
}