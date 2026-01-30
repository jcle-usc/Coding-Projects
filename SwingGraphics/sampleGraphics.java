import javax.swing.*; //for JFrame
import java.awt.*; //for Graphics and Container

public class sampleGraphics
{  
    public static void main (String[] args)
    {
        JFrame win; //JFrame Graphics setup
        Container contentPane;
        Graphics g;
      
        win = new JFrame("My Christmas Tree");  // window setup
        win.setSize(1520,935); //size of the terminal (x, y)
        win.setLocation(0,0); //location of the terminal, (left, top) of the screen
        win.setVisible(true); //make the terminal visible
      
        contentPane = win.getContentPane(); //activates graphics in window
        g = contentPane.getGraphics();
                
        try {Thread.sleep(100);} catch (Exception e) {} //every 100 milliseconds

        //making the roof
        g.setColor(new Color(102,51,0)); //chestnut brown
        g.fillRect(0,75,1520,20); //rectangle (x pos, y pos, x length, y length)
        
        //making the wall
        g.setColor(new Color(210,180,140)); //tan
        g.fillRect(0,95,1520,840);
        
        //making the sky
        g.setColor(new Color(25,25,112)); //midnight blue
        g.fillRect(0,0,1520,75);
        g.fillRect(150,350,300,300); //backgrounds for windows
        g.fillRect(1065,350,300,300);
        
        //making the windows
        g.setColor(new Color(102,51,0)); //chestnut brown
        int windowPos = 0;
        for (int window = 0; window < 2; window++) //makes 2 windows
        {
            g.fillRect(150 + windowPos,350,300,5); //rectangle (x pos, y pos, x length, y length)
            g.fillRect(150 + windowPos,650,300,5); 
            g.fillRect(150 + windowPos,350,5,300); 
            g.fillRect(450 + windowPos,350,5,305); 
            g.fillRect(150 + windowPos,500,300,5); 
            g.fillRect(300 + windowPos,350,5,300); 
            
            windowPos += 915;
        }

        //making the moon
        g.setColor(new Color(238,232,170)); //pale golden rod
        g.fillOval(200,400,50,50);
        g.setColor(new Color(25,25,112)); //midnight blue
        g.fillOval(220,400,50,50); //creates a crescent shape
        
        //making Santa on the roof
        int stepPos = 0;
        for (int steps = 0; steps < 10; steps++)
        {
            try {Thread.sleep(500);} catch (Exception e) {} //Santa steps across the roof every 500 milliseconds
            g.setColor(new Color(25,25,112)); //midnight blue
            g.fillRect(0,0,125 + stepPos,75); //replaces the last pair of feet with the midnight blue 
            
            g.setColor(new Color(255,255,250)); //snow
            g.fillRect(0,70,125 + stepPos,5);
            
            //Santa's boots
            g.setColor(new Color(139,69,19)); //saddle brown
            g.fillRect(10 + stepPos,55,65,20); //leg 1
            g.fillRect(10 + stepPos,35,35,20);
            g.fillRect(70 + stepPos,55,65,20); //leg 2
            g.fillRect(70 + stepPos,35,35,20); 
            
            //Santa's pants
            g.setColor(new Color(255,255,255)); //white 
            g.fillRect(0 + stepPos,30,55,5); 
            g.fillRect(60 + stepPos,30,55,5); 
            
            g.setColor(new Color(128,0,0)); //maroon 
            g.fillRect(5 + stepPos,0,45,30); 
            g.fillRect(65 + stepPos,0,45,30);  

            stepPos += 200; //steps every 200 x units to the right
        }
        
        //making the snow
        g.setColor(new Color(255,255,250)); //snow
        windowPos = 0;
        for (int window = 0; window < 2; window++) //makes 2 windows with a bottom line of snow
        {
            g.fillRect(150 + windowPos,495,300,5);
            g.fillRect(150 + windowPos,645,300,5);
            
            windowPos += 915;
        }
        //int ysnow = 0;
        for (int snowflakes = 0; snowflakes < 100; snowflakes++) //makes 100 snowflakes on the roof
        { 
            int xRandom = (int)(Math.random() * 1520); //random x pos 
            int yRandom = (int)(Math.random() * 65); //random y pos 
            int size = (int)(Math.random() * 6) + 5; //random size btwn 5-10
            
            g.fillOval(xRandom,yRandom,size,size);
            
            //attempt to make snow fall
            /*                    
            for (int snow = 0; snow < 100; snow++)
            {
                try {Thread.sleep(100);} catch (Exception e) {}
                  
                if (ysnow + size > 70)
                    ysnow = 0;
                    
                g.setColor(new Color(25,25,112)); //midnight blue
                g.fillOval(xrandom,ysnow - 10,size,size);
                g.fillOval(xrandom,ysnow,size,size);
                
                g.setColor(new Color(255,255,250)); //snow
                g.fillOval(xrandom,ysnow,size,size); //replaces
                
                ysnow += 10;
            }
            */ 
        }

        int nextPanel = 0;
        windowPos = 0;
        for (int topWindows = 0; topWindows < 4; topWindows++) //for every panel of the top windows
        {
            for (int snowflakes = 0; snowflakes < 25; snowflakes++) //creates 25 snowflakes
            {
                int xRandom = (int)(Math.random() * 141) + 160; //random x pos 
                int yRandom = (int)(Math.random() * 141) + 360; //random y pos 
                int size = (int)(Math.random() * 6) + 5; //random size btwn 5-10
                
                g.fillOval(xRandom + nextPanel + windowPos,yRandom,size,size);
            }
            nextPanel += 150; //next panel of the same window (tried to prevent snow from getting inside the house)
            if (topWindows == 1)    
            {    
                nextPanel = 0; //reset the next panel
                windowPos += 915; //go to the 2nd window
            }
        }
        
        nextPanel = 0;
        windowPos = 0;
        for (int bottomWindows = 0; bottomWindows < 4; bottomWindows++) //repeat for the bottom 4 panels of the 2 windows
        {
            for (int snowflakes = 0; snowflakes < 25; snowflakes++)
            {
                int xrandom = (int)(Math.random() * 141) + 160; //random x pos 
                int yrandom = (int)(Math.random() * 141) + 510; //random y pos 
                int size = (int)(Math.random() * 6) + 5; //random size btwn 5-10
                
                g.fillOval(xrandom + nextPanel + windowPos,yrandom,size,size);
            }
            nextPanel += 150;
            if (bottomWindows == 1)   
            {
                nextPanel = 0;
                windowPos += 915;
            }
        }
        
        //making the trunk of the tree
        g.setColor(new Color(102,51,0)); //chestnut brown
        g.fillRect(730,800,60,935); 
                     
        //making the leaves
        Polygon[] tree = new Polygon[12]; //create tree object array
        for (int i = 0; i < tree.length; i++) 
        {
            tree[i] = new Polygon();
        }
    
        int middle = 760;
        int right = 820;
        int left = 700;
        int top = 200;
        int bottom = 250;
                    
        g.setColor(new Color(0,100,0)); //dark green
        for (int leaf = 0; leaf < tree.length; leaf++) //makes 12 triangles
        {
            tree[leaf].addPoint(middle,top); //top point
            tree[leaf].addPoint(right,bottom); //bottom right point
            tree[leaf].addPoint(left,bottom); //bottom left point
            g.fillPolygon(tree[leaf]); //fills the triangle
            
            top += 25;
            left -= 20;
            right += 20;
            bottom += 50; //lowers + increases the width of the triangle (illusion to make a tree)
        }

        //first steps before recognizing pattern
        /*
        Polygon tri1 = new Polygon();
        tri1.addPoint(760,200);
        tri1.addPoint(700,250);
        tri1.addPoint(820,250);
        g.fillPolygon(tri1);       // drawPolygon() would create outline only

        Polygon tri2 = new Polygon();
        tri2.addPoint(760,225);
        tri2.addPoint(680,300);
        tri2.addPoint(840,300);
        g.fillPolygon(tri2);
        
        Polygon tri3 = new Polygon();
        tri3.addPoint(760,250);
        tri3.addPoint(660,350);
        tri3.addPoint(860,350);
        g.fillPolygon(tri3);
        
        Polygon tri4 = new Polygon();
        tri4.addPoint(760,275);
        tri4.addPoint(640,400);
        tri4.addPoint(880,400);
        g.fillPolygon(tri4);
        
        Polygon tri5 = new Polygon();
        tri5.addPoint(760,300);
        tri5.addPoint(620,450);
        tri5.addPoint(900,450);
        g.fillPolygon(tri5);
        */
       
        //making the star        
        //y values
        int h1 = 180; //top height
        int h2 = 195; //middle height
        int h3 = 200; //bottom height
        
        //x values
        int x1 = 760; //middle
        int x2 = 752; //bottom left
        int x3 = 753; //top left
        int x4 = 767; //top right
        int x5 = 766; //bottom right
                
        g.setColor(new Color(255,215,0)); //gold 
        Polygon p = new Polygon(); //upsidedown pentagon
        //going clockwise
        p.addPoint(x1,h3); //middle bottom point
        p.addPoint(x2,h2); //bottom left pt
        p.addPoint(x3,h1); //top left pt
        p.addPoint(x4,h1); //top right pt
        p.addPoint(x5,h2); //bottom right pt
        g.fillPolygon(p); 
                
        //the coordinates of the pentagon will be the exact same for 2 points of the 5 triangles, only 1 unique point is added
        
        //going clockwise
        Polygon t1 = new Polygon(); //triangle 1 (bottom left)
        t1.addPoint(x2 - 8,h3 + 8); //top (unique point)
        t1.addPoint(x1,h3); //bottom left
        t1.addPoint(x2,h1); //bottom right 
        g.fillPolygon(t1); 
        
        Polygon t2 = new Polygon(); //triangle 2 (middle left)
        t2.addPoint(x2 - 16,h1); //top (unique point)
        t2.addPoint(x3,h1); //bottom left
        t2.addPoint(x2,h2); //bottom right 
        g.fillPolygon(t2); 
        
        Polygon t3 = new Polygon(); //triangle 3 (top)
        t3.addPoint(x1,h1 - 20); //top (unique point)
        t3.addPoint(x3,h1); //bottom left 
        t3.addPoint(x4,h1); //bottom right 
        g.fillPolygon(t3); 
        
        Polygon t4 = new Polygon(); //triangle 4 (middle right)
        t4.addPoint(x4 + 16,h1); //top
        t4.addPoint(x4,h1); //bottom left
        t4.addPoint(x5,h2); //bottom right 
        g.fillPolygon(t4); 
        
        Polygon t5 = new Polygon(); //triangle 5 (bottom right)
        t5.addPoint(x4 + 8,h3 + 8); //top (unique point)
        t5.addPoint(x5,h1); //bottom left
        t5.addPoint(x1,h3); //bottom right 
        g.fillPolygon(t5); 
        
        //making the tinsel garlands (streamers)        
        Polygon[] tinsel = new Polygon[5]; //create tinsels object array
        for (int i = 0; i < tinsel.length; i++)
        {
            tinsel[i] = new Polygon();
        }
        
        int leftPos = 700;
        int rightPos = 840;
        int height = 310;
        int adjust = 0;
       
        g.setColor(new Color(204,0,0)); //dark red
        for (int streamer = 0; streamer < tinsel.length; streamer++) //makes 5 streamers (polygons)
        {
            tinsel[streamer].addPoint(leftPos - adjust,height); //top left
            tinsel[streamer].addPoint(leftPos - 20,height + 20); //bottom left
            tinsel[streamer].addPoint(rightPos + adjust,height + 50); //top right
            tinsel[streamer].addPoint(rightPos + 20,height + 70); //bottom right
            g.fillPolygon(tinsel[streamer]);
            
            leftPos -= 40;
            rightPos += 40;
            height += 100;
            adjust += 1; //to better connect with the sides of the tree
        }
        
        //first steps before recognizing pattern
        /*
        Polygon s1 = new Polygon(); //angled rhombus
        s1.addPoint(700,310); //top left
        s1.addPoint(680,330); //bottom left
        s1.addPoint(840,360); //top right
        s1.addPoint(862,380); //bottom right
        g.fillPolygon(s1);
        
        Polygon s2 = new Polygon();
        s2.addPoint(660,410); 
        s2.addPoint(640,430); 
        s2.addPoint(880,460); 
        s2.addPoint(902,480);   
        g.fillPolygon(s2);
        
        Polygon s3 = new Polygon();
        s3.addPoint(620,510); 
        s3.addPoint(600,530); 
        s3.addPoint(920,560); 
        s3.addPoint(942,580);   
        g.fillPolygon(s3);
        
        Polygon s4 = new Polygon();
        s4.addPoint(580,610); 
        s4.addPoint(560,630); 
        s4.addPoint(960,660); 
        s4.addPoint(982,680);   
        g.fillPolygon(s4);
        
        Polygon s5 = new Polygon();
        s5.addPoint(540,710); 
        s5.addPoint(520,730); 
        s5.addPoint(1000,760); 
        s5.addPoint(1022,780);   
        g.fillPolygon(s5);
        */
                
        //making the presents        
        int presentPos = 550; 
        int presentHeight = 860;
        int nextPresent = 0;
        int trunk = 0;
        for (int present = 0; present < 4; present++) //creates 4 presents
        {
            int sizeRandom = (int)(Math.random() * 2); //0 = large, 1 = small
            int size = 50;
            
            if (sizeRandom == 0)
            {
                size += 20; //if a large present, increase by 20 units
                presentHeight -= 20;
            }
                
            int R = (int)(Math.random() * 256);
            int G = (int)(Math.random() * 256);
            int B = (int)(Math.random() * 256);
            g.setColor(new Color(R,G,B)); //random color
            
            if (present == 2)
                trunk += 70; //acount for presents on the right side of the trunk
            g.fillRect(presentPos + nextPresent + trunk,presentHeight,size,size); //square (x pos, y pos, x length, y length
            
            //making the ribbons on the presents
            g.setColor(new Color(255,255,255)); //white
            if (sizeRandom == 0) //large
            {
                g.fillRect(presentPos + nextPresent + trunk + 28,presentHeight,14,70); //vertical
                g.fillRect(presentPos + nextPresent + trunk,presentHeight + 28,70,14); //horizontal
                g.fillOval(presentPos + nextPresent + trunk + 18,presentHeight - 18,20,20);
                g.fillOval(presentPos + nextPresent + trunk + 32,presentHeight - 18,20,20);
            }
            if (sizeRandom == 1) //small
            {
                g.fillRect(presentPos + nextPresent + trunk + 20,presentHeight,10,50); //vertical
                g.fillRect(presentPos + nextPresent + trunk,presentHeight + 20,50,10); //horizontal
                g.fillOval(presentPos + nextPresent + trunk + 12,presentHeight - 13,15,15);
                g.fillOval(presentPos + nextPresent + trunk + 24,presentHeight - 13,15,15);
            }

            nextPresent += 100;
            presentHeight = 860; //reset y position
        }
        
        //making the ornaments
        //x-space is 700-820 (each side decreases/increase by 20 w/ each level), y-space is 250-800 (of the tree)
        int treeHeight = 0;
        for (int ornament = 0; ornament < 6; ornament++) //creates 6 ornaments
        {
            int treeLength = 101; //space of 100 instead of 120
            int xPos = 710; //cut 10 on both sides to remove edge ornaments
            int yPos = 250; //base y of 250
            for (int leaf = 0; leaf < 11; leaf++) //each leaf layer of the tree
            {
                int xRandom = (int)(Math.random() * treeLength); //random x pos in the xspace based on the which "leaf" it's on (out of 11)
                
                //create 2 ornaments of each color
                if (ornament < 2)
                    g.setColor(new Color(255,0,0)); //red
                if (ornament > 1 && ornament < 4)
                    g.setColor(new Color(0,255,0)); //green
                if (ornament > 3)
                    g.setColor(new Color(0,0,255)); //blue
                    
                g.fillOval(xRandom + xPos,yPos + treeHeight,20,20);
                
                /*
                if (ybase%100 == 50) //heights of 250, 350, etc.
                {
                    g.setColor(new Color(red,green,blue));
                    g.fillOval(xrandom + xbase,ybase,25,25);
                }
                if (ybase%100 == 0) //heights of 300, 400, etc.
                {
                    g.setColor(new Color(red,green,blue));
                    g.fillOval(xrandom + xbase,ybase,25,25);
                }
                */
                
                treeLength += 40;
                xPos -= 20; 
                yPos += 50; 
            }
            treeHeight += 15; //make the ornaments more spaced out 
            if (ornament == 2 || ornament == 4)
                treeHeight = 0; //reset
                
            /*
            g.fillOval(760,250,25,25);
            g.fillOval(760,350,25,25); 
            g.fillOval(700,450,25,25);
            g.fillOval(660,550,25,25);
            g.fillOval(800,650,25,25);
            g.fillOval(650,750,25,25);
            
            g.setColor(new Color(204,0,204)); //purple
            g.fillOval(730,300,25,25);
            g.fillOval(800,400,25,25);
            g.fillOval(860,500,25,25);
            g.fillOval(700,600,25,25);
            g.fillOval(620,700,25,25);
            */
        }        
    }
}