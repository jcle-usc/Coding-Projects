/*
 * First idea was to have each block be a JLabel on top of a JPanel grid. 
 * 
 * JLabel:
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JLabel.html
 * 
 * But i ran into numerous issues that i kinda already explained in the snapshots:
 * - graphics would delete the grid behind it everytime the block moved
 * - manual redrawing of block
 * - extremely glitchy grid tracking & falling
 * - line deletion logic doesn't work because some parts of the block still exist usually and that requires "removing" the JLabel, but then the whole block would delete instead of the line itself
*/

import javax.swing.*; //jlabel
import java.awt.*; //color

public class BlockIJLabel extends JLabel
{    
    private static int rotate;
    private static JLabel b;
    private JPanel t;
    private Key keyListener;
    public static int row;
    public static int col;

    public BlockIJLabel(JLabel block, JPanel tetris) 
    {
        /*
        b = block;
        b.setBounds(690, 100, 140, 35);
        b.setBackground(new Color(0,255,255));
        b.setOpaque(true);

        t = tetris;
        keyListener = new Key(b, 'I');
        t.addKeyListener(keyListener);
        t.add(b);

        rotate = 0;
        col = 3;
        row = 0;
        */
    }

    public void fall()
    {
        /*
        while ((b.getY() < 800 && rotate % 2 == 0) || (b.getY() < 695 && rotate % 1 == 0 && rotate != 0))
        {
            b.setLocation(b.getX(), b.getY() + 35);
            updateRowLocation();
            row++;
            try {Thread.sleep(2500);} catch (Exception e) {} //every 1 second

            System.out.println();
            for (int row = 0; row < Grid.grid.length; row++)
            {
                for (int col = 0; col < Grid.grid[row].length; col++)
                {
                    System.out.print(Grid.grid[row][col]);
                }
                System.out.println();
            }
        }
        t.removeKeyListener(keyListener);
        */
    }

    public static void rotate()
    {
        /*
        switch (rotate)
        {
            case 0:
                b.setBounds(b.getX() + 70, b.getY() - 35, 35, 140);
                for (int i = 0; i < 4; i++)
                {
                    if (row != 0)
                    {
                        Grid.grid[row][col + i] = 0;
                        Grid.grid[row - 1 + i][col + 2] = 1;
                    }
                }
                rotate++;
                break;
            case 1:
                b.setBounds(b.getX() - 70, b.getY() + 70, 140, 35);
                for (int i = 0; i < 4; i++)
                {
                    if (row != 0)
                    {
                        Grid.grid[row - 1 + i][col + 2] = 0;
                        Grid.grid[row + 1][col + i] = 1;
                    }
                }
                rotate++;
                break;
            case 2:
                b.setBounds(b.getX() + 35, b.getY() - 70, 35, 140);
                for (int i = 0; i < 4; i++)
                {
                    if (row != 0)
                    {
                        Grid.grid[row + 1][col + i] = 0;
                        Grid.grid[row - 1 + i][col + 1] = 1;
                    }
                }
                rotate++;
                break;
            case 3:
                b.setBounds(b.getX() - 35, b.getY() + 35, 140, 35);
                for (int i = 0; i < 4; i++)
                {
                    if (row != 0)
                    {
                        Grid.grid[row - 1 + i][col + 1] = 0;
                        Grid.grid[row][col + i] = 1;
                    }
                }
                rotate = 0;
                break;
        }
        */
    }

    private static void updateRowLocation()
    {
        /*
        switch (rotate)
        {
            case 0:
                for (int i = 0; i < 4; i++)
                {
                    Grid.grid[row][col + i] = 0;
                    Grid.grid[row + 1][col + i] = 1;
                }
                break;
            case 1:
                for (int i = 0; i < 4; i++)
                {
                    if (row != 0)
                    {
                        Grid.grid[row - 1 + i][col + 2] = 0;
                        Grid.grid[row + i][col + 2] = 1;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 4; i++)
                {
                    Grid.grid[row + 1][col + i] = 0;
                    Grid.grid[row + 2][col + i] = 1;
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++)
                {
                    if (row != 0)
                    {
                        Grid.grid[row - 1 + i][col + 1] = 0;
                        Grid.grid[row + i][col + 1] = 1;
                    }
                }
                break;
        }
        */
    }
}