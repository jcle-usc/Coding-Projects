import javax.swing.*; 
import java.awt.*; 

public class sampleGraphicsScaled
{  
    public static void main (String[] args)
    {
        JFrame win; 
        Container contentPane;
        Graphics g;
      
        win = new JFrame("My Christmas Tree");  
        win.setSize(912,561); 
        win.setLocation(0,0); 
        win.setVisible(true); 
      
        contentPane = win.getContentPane(); 
        g = contentPane.getGraphics();
                
        try {Thread.sleep(100);} catch (Exception e) {} 

        
        g.setColor(new Color(102,51,0)); 
        g.fillRect(0,45,912,12); 
        
        
        g.setColor(new Color(210,180,140)); 
        g.fillRect(0,57,912,504);
        
        
        g.setColor(new Color(25,25,112)); 
        g.fillRect(0,0,912,45);
        g.fillRect(90,210,180,180); 
        g.fillRect(639,210,180,180);
        
        
        g.setColor(new Color(102,51,0)); 
        int windowPos = 0;
        for (int window = 0; window < 2; window++) 
        {
            g.fillRect(90 + windowPos,210,180,3); 
            g.fillRect(90 + windowPos,390,180,3); 
            g.fillRect(90 + windowPos,210,3,180); 
            g.fillRect(270 + windowPos,210,3,183); 
            g.fillRect(90 + windowPos,300,180,3); 
            g.fillRect(180 + windowPos,210,3,180); 
            
            windowPos += 549;
        }

        
        g.setColor(new Color(238,232,170)); 
        g.fillOval(120,240,30,30);
        g.setColor(new Color(25,25,112)); 
        g.fillOval(132,240,30,30); 
        
        
        int stepPos = 0;
        for (int steps = 0; steps < 10; steps++)
        {
            try {Thread.sleep(500);} catch (Exception e) {} 
            g.setColor(new Color(25,25,112)); 
            g.fillRect(0,0,75 + stepPos,45); 
            
            g.setColor(new Color(255,255,250)); 
            g.fillRect(0,42,75 + stepPos,3);
            
            
            g.setColor(new Color(139,69,19)); 
            g.fillRect(6 + stepPos,33,39,12); 
            g.fillRect(6 + stepPos,21,21,12);
            g.fillRect(42 + stepPos,33,39,12); 
            g.fillRect(42 + stepPos,21,21,12); 
            
            
            g.setColor(new Color(255,255,255)); 
            g.fillRect(0 + stepPos,18,33,3); 
            g.fillRect(36 + stepPos,18,33,3); 
            
            g.setColor(new Color(128,0,0)); 
            g.fillRect(3 + stepPos,0,27,18); 
            g.fillRect(39 + stepPos,0,27,18);  

            stepPos += 120; 
        }
        
        
        g.setColor(new Color(255,255,250)); 
        windowPos = 0;
        for (int window = 0; window < 2; window++) 
        {
            g.fillRect(90 + windowPos,297,180,3);
            g.fillRect(90 + windowPos,387,180,3);
            
            windowPos += 549;
        }
        
        for (int snowflakes = 0; snowflakes < 100; snowflakes++) 
        { 
            int xRandom = (int)(Math.random() * 912); 
            int yRandom = (int)(Math.random() * 39); 
            int size = (int)(Math.random() * 3) + 3; 
            
            g.fillOval(xRandom,yRandom,size,size);
            
            
            /*                    
            for (int snow = 0; snow < 100; snow++)
            {
                try {Thread.sleep(100);} catch (Exception e) {}
                  
                if (ysnow + size > 42)
                    ysnow = 0;
                    
                g.setColor(new Color(25,25,112)); 
                g.fillOval(xrandom,ysnow - 6,size,size);
                g.fillOval(xrandom,ysnow,size,size);
                
                g.setColor(new Color(255,255,250)); 
                g.fillOval(xrandom,ysnow,size,size); 
                
                ysnow += 10;
            }
            */ 
        }

        int nextPanel = 0;
        windowPos = 0;
        for (int topWindows = 0; topWindows < 4; topWindows++) 
        {
            for (int snowflakes = 0; snowflakes < 25; snowflakes++) 
            {
                int xRandom = (int)(Math.random() * 84) + 96; 
                int yRandom = (int)(Math.random() * 84) + 216; 
                int size = (int)(Math.random() * 3) + 3; 
                
                g.fillOval(xRandom + nextPanel + windowPos,yRandom,size,size);
            }
            nextPanel += 90; 
            if (topWindows == 1)    
            {    
                nextPanel = 0; 
                windowPos += 549; 
            }
        }
        
        nextPanel = 0;
        windowPos = 0;
        for (int bottomWindows = 0; bottomWindows < 4; bottomWindows++) 
        {
            for (int snowflakes = 0; snowflakes < 25; snowflakes++)
            {
                int xrandom = (int)(Math.random() * 84) + 96; 
                int yrandom = (int)(Math.random() * 84) + 306; 
                int size = (int)(Math.random() * 3) + 3; 
                
                g.fillOval(xrandom + nextPanel + windowPos,yrandom,size,size);
            }
            nextPanel += 90;
            if (bottomWindows == 1)   
            {
                nextPanel = 0;
                windowPos += 549;
            }
        }
        
        
        g.setColor(new Color(102,51,0)); 
        g.fillRect(438,480,36,561); 
                     
        
        Polygon[] tree = new Polygon[12]; 
        for (int i = 0; i < tree.length; i++) 
        {
            tree[i] = new Polygon();
        }
    
        int middle = 456;
        int right = 492;
        int left = 420;
        int top = 120;
        int bottom = 150;
                    
        g.setColor(new Color(0,100,0)); 
        for (int leaf = 0; leaf < tree.length; leaf++) 
        {
            tree[leaf].addPoint(middle,top); 
            tree[leaf].addPoint(right,bottom); 
            tree[leaf].addPoint(left,bottom); 
            g.fillPolygon(tree[leaf]); 
            
            top += 15;
            left -= 12;
            right += 12;
            bottom += 30; 
        }

        
        /*
        Polygon tri1 = new Polygon();
        tri0.addPoint(456,120);
        tri0.addPoint(420,150);
        tri0.addPoint(492,150);
        g.fillPolygon(tri1);       

        Polygon tri2 = new Polygon();
        tri1.addPoint(456,135);
        tri1.addPoint(408,180);
        tri1.addPoint(504,180);
        g.fillPolygon(tri2);
        
        Polygon tri3 = new Polygon();
        tri1.addPoint(456,150);
        tri1.addPoint(396,210);
        tri1.addPoint(516,210);
        g.fillPolygon(tri3);
        
        Polygon tri4 = new Polygon();
        tri2.addPoint(456,165);
        tri2.addPoint(384,240);
        tri2.addPoint(528,240);
        g.fillPolygon(tri4);
        
        Polygon tri5 = new Polygon();
        tri3.addPoint(456,180);
        tri3.addPoint(372,270);
        tri3.addPoint(540,270);
        g.fillPolygon(tri5);
        */
       
        
        
        int h1 = 108; 
        int h2 = 117; 
        int h3 = 120; 
        
        
        int x1 = 456; 
        int x2 = 451; 
        int x3 = 451; 
        int x4 = 460; 
        int x5 = 459; 
                
        g.setColor(new Color(255,215,0)); 
        Polygon p = new Polygon(); 
        
        p.addPoint(x1,h3); 
        p.addPoint(x2,h2); 
        p.addPoint(x3,h1); 
        p.addPoint(x4,h1); 
        p.addPoint(x5,h2); 
        g.fillPolygon(p); 
                
        
        
        
        Polygon t1 = new Polygon(); 
        t1.addPoint(x2 - 4,h3 + 4); 
        t1.addPoint(x1,h3); 
        t1.addPoint(x2,h1); 
        g.fillPolygon(t1); 
        
        Polygon t2 = new Polygon(); 
        t2.addPoint(x2 - 9,h1); 
        t2.addPoint(x3,h1); 
        t2.addPoint(x2,h2); 
        g.fillPolygon(t2); 
        
        Polygon t3 = new Polygon(); 
        t3.addPoint(x1,h1 - 12); 
        t3.addPoint(x3,h1); 
        t3.addPoint(x4,h1); 
        g.fillPolygon(t3); 
        
        Polygon t4 = new Polygon(); 
        t4.addPoint(x4 + 9,h1); 
        t4.addPoint(x4,h1); 
        t4.addPoint(x5,h2); 
        g.fillPolygon(t4); 
        
        Polygon t5 = new Polygon(); 
        t5.addPoint(x4 + 4,h3 + 4); 
        t5.addPoint(x5,h1); 
        t5.addPoint(x1,h3); 
        g.fillPolygon(t5); 
        
        
        Polygon[] tinsel = new Polygon[5]; 
        for (int i = 0; i < tinsel.length; i++)
        {
            tinsel[i] = new Polygon();
        }
        
        int leftPos = 420;
        int rightPos = 504;
        int height = 186;
        int adjust = 0;
       
        g.setColor(new Color(204,0,0)); 
        for (int streamer = 0; streamer < tinsel.length; streamer++) 
        {
            tinsel[streamer].addPoint(leftPos - adjust,height); 
            tinsel[streamer].addPoint(leftPos - 12,height + 12); 
            tinsel[streamer].addPoint(rightPos + adjust,height + 30); 
            tinsel[streamer].addPoint(rightPos + 12,height + 42); 
            g.fillPolygon(tinsel[streamer]);
            
            leftPos -= 24;
            rightPos += 24;
            height += 60;
            adjust += 0; 
        }
        
        
        /*
        Polygon s1 = new Polygon(); 
        s0.addPoint(420,186); 
        s0.addPoint(408,198); 
        s0.addPoint(504,216); 
        s0.addPoint(517,228); 
        g.fillPolygon(s1);
        
        Polygon s2 = new Polygon();
        s1.addPoint(396,246); 
        s1.addPoint(384,258); 
        s1.addPoint(528,276); 
        s1.addPoint(541,288);   
        g.fillPolygon(s2);
        
        Polygon s3 = new Polygon();
        s1.addPoint(372,306); 
        s1.addPoint(360,318); 
        s1.addPoint(552,336); 
        s1.addPoint(565,348);   
        g.fillPolygon(s3);
        
        Polygon s4 = new Polygon();
        s2.addPoint(348,366); 
        s2.addPoint(336,378); 
        s2.addPoint(576,396); 
        s2.addPoint(589,408);   
        g.fillPolygon(s4);
        
        Polygon s5 = new Polygon();
        s3.addPoint(324,426); 
        s3.addPoint(312,438); 
        s3.addPoint(600,456); 
        s3.addPoint(613,468);   
        g.fillPolygon(s5);
        */
                
        
        int presentPos = 330; 
        int presentHeight = 516;
        int nextPresent = 0;
        int trunk = 0;
        for (int present = 0; present < 4; present++) 
        {
            int sizeRandom = (int)(Math.random() * 2); 
            int size = 30;
            
            if (sizeRandom == 0)
            {
                size += 12; 
                presentHeight -= 12;
            }
                
            int R = (int)(Math.random() * 256);
            int G = (int)(Math.random() * 256);
            int B = (int)(Math.random() * 256);
            g.setColor(new Color(R,G,B)); 
            
            if (present == 2)
                trunk += 42; 
            g.fillRect(presentPos + nextPresent + trunk,presentHeight,size,size); 
            
            
            g.setColor(new Color(255,255,255)); 
            if (sizeRandom == 0) 
            {
                g.fillRect(presentPos + nextPresent + trunk + 16,presentHeight,8,42); 
                g.fillRect(presentPos + nextPresent + trunk,presentHeight + 16,42,8); 
                g.fillOval(presentPos + nextPresent + trunk + 10,presentHeight - 10,12,12);
                g.fillOval(presentPos + nextPresent + trunk + 19,presentHeight - 10,12,12);
            }
            if (sizeRandom == 1) 
            {
                g.fillRect(presentPos + nextPresent + trunk + 12,presentHeight,6,30); 
                g.fillRect(presentPos + nextPresent + trunk,presentHeight + 12,30,6); 
                g.fillOval(presentPos + nextPresent + trunk + 7,presentHeight - 7,9,9);
                g.fillOval(presentPos + nextPresent + trunk + 14,presentHeight - 7,9,9);
            }

            nextPresent += 60;
            presentHeight = 516; 
        }
        
        
        
        int treeHeight = 0;
        for (int ornament = 0; ornament < 6; ornament++) 
        {
            int treeLength = 60; 
            int xPos = 426; 
            int yPos = 150; 
            for (int leaf = 0; leaf < 11; leaf++) 
            {
                int xRandom = (int)(Math.random() * treeLength); 
                
                
                if (ornament < 2)
                    g.setColor(new Color(255,0,0)); 
                if (ornament > 1 && ornament < 4)
                    g.setColor(new Color(0,255,0)); 
                if (ornament > 3)
                    g.setColor(new Color(0,0,255)); 
                    
                g.fillOval(xRandom + xPos,yPos + treeHeight,12,12);
                
                /*
                if (ybase%100 == 50) 
                {
                    g.setColor(new Color(red,green,blue));
                    g.fillOval(xrandom + xbase,ybase,15,15);
                }
                if (ybase%100 == 0) 
                {
                    g.setColor(new Color(red,green,blue));
                    g.fillOval(xrandom + xbase,ybase,15,15);
                }
                */
                
                treeLength += 24;
                xPos -= 12; 
                yPos += 30; 
            }
            treeHeight += 9; 
            if (ornament == 2 || ornament == 4)
                treeHeight = 0; 
                
            /*
            g.fillOval(456,150,15,15);
            g.fillOval(456,210,15,15); 
            g.fillOval(420,270,15,15);
            g.fillOval(396,330,15,15);
            g.fillOval(480,390,15,15);
            g.fillOval(390,450,15,15);
            
            g.setColor(new Color(204,0,204)); 
            g.fillOval(438,180,15,15);
            g.fillOval(480,240,15,15);
            g.fillOval(516,300,15,15);
            g.fillOval(420,360,15,15);
            g.fillOval(372,420,15,15);
            */
        }        
    }
}
