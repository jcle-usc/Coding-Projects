import javax.swing.*;
import java.awt.*; 

//JPanel:
//https://docs.oracle.com/javase/8/docs/api/javax/swing/JPanel.html

public class Grid extends JPanel
{    
    public static int[][] grid;
    
    public Grid()
    {                
        grid = new int[20][10]; //grid used for tracking of the blocks, eventually was GOING to use for block collision logic & line deletion (almost done in JLabel version)
        
        //JPanel setLayout(): 
        //https://docs.oracle.com/javase/tutorial/uiswing/layout/using.html
        //https://docs.oracle.com/javase/tutorial/uiswing/layout/none.html
        setLayout(null); //confused why my blocks were not appearing on the grid, needed to set the layout of JPanel grid's components (blocks) to null in order to use setBounds() on the blocks 
        //JPanel setFocusable():
        //https://docs.oracle.com/javase/8/docs/api/java/awt/Component.html
        setFocusable(true); //confused why my blocks were not moving with keyListener, needed to allow the JPanel grid to receive keyboard events w/ this method
    }
    
    //paintComponent:
    //https://docs.oracle.com/javase/tutorial/uiswing/painting/closer.html
    
    //overriden method where graphics expects the drawing to be done
    //MANY issues with graphics/swing in the main method, either wouldn't show up sometimes or i had to call a Thread.sleep for it to show at one point ?
    //learned that this is the best way to draw the game's grid (on a JPanel) rather than the JFrame itself, so that the blocks could eventually lay on top of it
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g); //automatically called
                        
        g.setColor(new Color(0,0,0)); 
        g.fillRect(0,0,1520,950); //background
        
        g.setColor(new Color(255, 255, 255)); 
        g.fillRect(582,835,353,3); //grid
        g.fillRect(582,135,3,700);
        g.fillRect(935,135,3,700);
                
        g.setColor(new Color(255, 255, 255)); 
        g.fillRect(410,135,175,35); //hold
        g.fillRect(410,135,3,140);
        g.fillRect(410,275,175,3);
        
        g.setColor(new Color(0,0,0)); 
        g.fillRect(415,140,2,25); //H
        g.fillRect(415,152,15,2);
        g.fillRect(430,140,2,25);
        g.fillRect(435,140,2,25); //O
        g.fillRect(435,140,15,2);
        g.fillRect(450,140,2,25);
        g.fillRect(435,163,16,2);
        g.fillRect(455,140,2,25); //L
        g.fillRect(455,163,15,2);
        g.fillRect(475,140,2,25); //D
        g.fillRect(491,145,2,18);
        Polygon lineOne = new Polygon();
        lineOne.addPoint(475,140);
        lineOne.addPoint(490,145);
        lineOne.addPoint(550,140);
        g.fillPolygon(lineOne); 
        g.setColor(new Color(255, 255, 255)); 
        Polygon lineOneDup = new Polygon();
        lineOneDup.addPoint(480,140);
        lineOneDup.addPoint(494,145);
        lineOneDup.addPoint(555,140);
        g.fillPolygon(lineOneDup);
        g.setColor(new Color(0,0,0)); 
        Polygon lineTwo = new Polygon();
        lineTwo.addPoint(475,165);
        lineTwo.addPoint(490,160);
        lineTwo.addPoint(555,165);
        g.fillPolygon(lineTwo); 
        g.setColor(new Color(255, 255, 255)); 
        Polygon lineTwoDup = new Polygon();
        lineTwoDup.addPoint(480,165);
        lineTwoDup.addPoint(494,160);
        lineTwoDup.addPoint(555,165);
        g.fillPolygon(lineTwoDup); 
        
        g.setColor(new Color(255, 255, 255)); 
        g.fillRect(935,135,175,35); //next
        g.fillRect(1110,135,3,143);
        g.fillRect(935,275,175,3);
        
        g.setColor(new Color(0, 0, 0));
        g.fillRect(940,140,2,25); //N
        Polygon lineThree = new Polygon();
        lineThree.addPoint(940,140);
        lineThree.addPoint(955,165);
        lineThree.addPoint(1100,140);
        g.fillPolygon(lineThree); 
        g.setColor(new Color(255, 255, 255)); 
        Polygon lineThreeDup = new Polygon();
        lineThreeDup.addPoint(943,140);
        lineThreeDup.addPoint(958,165);
        lineThreeDup.addPoint(1103,140);
        g.fillPolygon(lineThreeDup); 
        g.setColor(new Color(0,0,0)); 
        g.fillRect(956,140,2,25);
        g.fillRect(961,140,2,25); //E
        g.fillRect(961,140,15,2);
        g.fillRect(961,151,15,2);
        g.fillRect(961,163,15,2);
        Polygon lineFour = new Polygon(); //X
        lineFour.addPoint(980,140);
        lineFour.addPoint(1000,140);
        lineFour.addPoint(990,155);
        g.fillPolygon(lineFour); 
        g.setColor(new Color(255, 255, 255)); 
        Polygon lineFourDup = new Polygon();
        lineFourDup.addPoint(980,136);
        lineFourDup.addPoint(1000,136);
        lineFourDup.addPoint(990,151);
        g.fillPolygon(lineFourDup);
        g.setColor(new Color(0,0,0)); 
        Polygon lineFive = new Polygon();
        lineFive.addPoint(980,165);
        lineFive.addPoint(1000,165);
        lineFive.addPoint(990,150);
        g.fillPolygon(lineFive); 
        g.setColor(new Color(255, 255, 255)); 
        Polygon lineFiveDup = new Polygon();
        lineFiveDup.addPoint(980,169);
        lineFiveDup.addPoint(1000,169);
        lineFiveDup.addPoint(990,154);
        g.fillPolygon(lineFiveDup); 
        g.setColor(new Color(0,0,0)); 
        g.fillRect(1005,140,20,2); //T
        g.fillRect(1014,140,2,25);
        
        g.setColor(new Color(192, 192, 192)); 
        int addVertical = 35;
        for (int i = 0; i < 10; i++)
        {
            g.fillRect(585 + addVertical,135,1,700);
            addVertical += 35;
        }
        int addHorizontal = 0;
        for (int i = 0; i < 20; i++)
        {
            g.fillRect(585,135 + addHorizontal,350,1);
            addHorizontal += 35;
        }
    }
}