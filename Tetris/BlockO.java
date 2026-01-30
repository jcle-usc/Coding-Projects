import javax.swing.*; //for JFrame
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*; //color

public class BlockO extends JPanel implements Block
{
    private static Graphics g;
    private Timer fallTimer;
    private JPanel p;
    private Tetris t;
    private Key keyListener;
    private int rotate;
    private int row;
    private int col;

    public BlockO(JPanel tetris, Tetris tet)
    {
        setBounds(725,100,70,70);

        p = tetris;
        keyListener = new Key(this);
        p.addKeyListener(keyListener);

        t = tet;

        rotate = 0;
        row = 0;
        col = 4;
    }

    protected void paintComponent(Graphics graphic)
    {
        g = graphic;

        super.paintComponent(g);

        for (int i = 0; i < 2; i++)
        {
            g.setColor(new Color(255, 255, 0));
            g.fillRect(i * 35,0,35,35);
            g.setColor(new Color(0, 0, 0));
            g.drawRect(i * 35,0,35,35);
        }
        for (int i = 0; i < 2; i++)
        {
            g.setColor(new Color(255, 255, 0));
            g.fillRect(i * 35,35,35,35);
            g.setColor(new Color(0, 0, 0));
            g.drawRect(i * 35,35,35,35);
        }
    }

    public void startFalling()
    {
        fallTimer = new Timer(1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (getY() < 765)
                    moveDown();
                else
                {
                    fallTimer.stop();
                    t.blockPlaced();
                    p.removeKeyListener(keyListener);
                }
            }
        });
        fallTimer.start();
    }

    public void moveLeft()
    {
        if (getX() > 585)
        {
            setBounds(getX() - 35,getY(),70,70);
        }
        col--;
        repaint();
    }

    public void moveRight()
    {
        if (getX() < 865)
            setBounds(getX() + 35,getY(),70,70);
        col++;
        repaint();
    }

    public void moveDown()
    {
        if (getY() < 765)
            setBounds(getX(),getY() + 35,70,70);
        row++;
    }

    public void rotate()
    {
        //no rotation for this block ...
    }

    public void place()
    {

    }
}