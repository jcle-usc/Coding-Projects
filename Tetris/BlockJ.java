import javax.swing.*; //for JFrame
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*; //color

public class BlockJ extends JPanel implements Block
{
    private static Graphics g;
    private Timer fallTimer;
    private JPanel p;
    private Tetris t;
    private Key keyListener;
    private int rotate;
    private int row;
    private int col;

    public BlockJ(JPanel tetris, Tetris tet)
    {
        setBounds(725,100,105,70);
        setOpaque(false);

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

        switch (rotate)
        {
            case 0:
                g.setColor(new Color(0, 0, 255));
                g.fillRect(0,0,35,35);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(0,0,35,35);
                for (int i = 0; i < 3; i++)
                {
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(i * 35,35,35,35);
                    g.setColor(new Color(0, 0, 0));
                    g.drawRect(i * 35,35,35,35);
                }
                break;
            case 1:
                g.setColor(new Color(0, 0, 255));
                g.fillRect(35,0,35,35);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(35,0,35,35);
                for (int i = 0; i < 3; i++)
                {
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(0,i * 35,35,35);
                    g.setColor(new Color(0, 0, 0));
                    g.drawRect(0,i * 35,35,35);
                }
                break;
            case 2:
                g.setColor(new Color(0, 0, 255));
                g.fillRect(70,35,35,35);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(70,35,35,35);
                for (int i = 0; i < 3; i++)
                {
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(i * 35,0,35,35);
                    g.setColor(new Color(0, 0, 0));
                    g.drawRect(i * 35,0,35,35);
                }
                break;
            case 3:
                g.setColor(new Color(0, 0, 255));
                g.fillRect(0,70,35,35);
                g.setColor(new Color(0, 0, 0));
                g.drawRect(0,70,35,35);
                for (int i = 0; i < 3; i++)
                {
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(35,i * 35,35,35);
                    g.setColor(new Color(0, 0, 0));
                    g.drawRect(35,i * 35,35,35);
                }
                break;
        }
    }

    public void startFalling()
    {
        fallTimer = new Timer(1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (((rotate == 0 && getY() < 765) || (rotate == 2 && getY() < 765)) || ((getY() < 730 && !(rotate == 0 || rotate == 2))))
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
            if (rotate % 2 == 0)
                setBounds(getX() - 35,getY(),105,70);
            else
                setBounds(getX() - 35,getY(),70,105);
        }
        col--;
        repaint();
    }

    public void moveRight()
    {
        if (getX() < 900)
        {
            if (rotate % 2 == 0)
                setBounds(getX() + 35,getY(),105,70);
            else
                setBounds(getX() + 35,getY(),70,105);
        }
        col++;
        repaint();
    }

    public void moveDown()
    {
        if ((rotate == 0 && getY() < 765) || (rotate == 2 && getY() < 765))
            setBounds(getX(),getY() + 35,105,70);
        else if ((getY() < 730 && !(rotate == 0 || rotate == 2)))
            setBounds(getX(),getY() + 35,70,105);
        row++;
        repaint();
    }

    public void rotate()
    {
        switch (rotate)
        {
            case 0:
                setBounds(getX() + 35, getY(), 70, 105);
                rotate++;
                break;
            case 1:
                setBounds(getX() - 35, getY() - 35, 105, 70);
                rotate++;
                break;
            case 2:
                setBounds(getX() + 35, getY(), 70, 105);
                rotate++;
                break;
            case 3:
                setBounds(getX(), getY(), 105, 70);
                rotate = 0;
                break;
        }
        repaint();
    }

    public void place()
    {
        
    }
}