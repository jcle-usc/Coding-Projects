public class Battleship1D
{   
    private int[] grid;
    private int[] shipPositions = new int[2];
    private boolean[] shipSinks = new boolean[2];
    private boolean bothShipsSunkPrints = false;
    private int ships;
    private int shipStart;
    private int guesses;
    /*
    private int lowerShip, middleShip, upperShip;
    private placeShips1D ship1 = new placeShips1D();
    private placeShips1D ship2 = new placeShips1D();
    */

    public Battleship1D()
    {
        grid = new int[10];
                
        setShips();
    }
    
    private void setShips()
    {         
        /*
        ship.setIndex();

        System.out.println("is there overlap?: " + shipOverlap(ship));
        System.out.print("grid before adding ship: ");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(grid[i]);
        }  
        */
        while (ships < 2) 
        {
            shipStart = (int)(Math.random() * 8);
            if (!shipOverlap())
            {
                //System.out.println("index: " + shipStart);
                for (int i = 0; i < 3; i++)
                {
                    grid[shipStart + i] = 1;
                }
                
                shipPositions[ships] = shipStart;
                ships++;
                
                /*
                if (index <= 2)
                {
                    for (int i = 0; i < 3; i++) 
                    {
                        grid[index + i] = 1;
                    }
                    lowerShip = index;
                }
                if (index >= 7)
                {
                    for (int i = 0; i < 3; i++) 
                    {
                        grid[index - i] = 1;
                    }
                    upperShip = index;
                }
                if (index > 2 && index < 7)
                {
                    for (int i = 0; i < 3; i++) 
                    {
                        grid[index + i - 1] = 1;
                    }
                    middleShip = index;
                }
                */
            }
        }
        /*
        System.out.println();
        System.out.println("amount of battleships: " + ships);
        
        System.out.print("grid after adding ship: ");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(grid[i]);
        } 
        System.out.println();
        
        if (ships < 2)
        {
            setShips();
        }
        */
    }
    
    private boolean shipOverlap()
    {
        for (int i = 0; i < 3; i++)
        {
            if (grid[shipStart + i] == 1)
            {
                return true;
            }
        }
        return false;
        /*
        if (index <= 2)
        {
            for (int i = 0; i < 3; i++)
            {
                if (grid[index + i] > 0)
                {
                    return true;
                }
            }
        }
        if (index >= 7)
        {
            for (int i = 0; i < 3; i++)
            {
                if (grid[index - i] > 0)
                {
                    return true;
                }
            }
        }
        if (index > 2 && index < 7)
        {
            for (int i = 0; i < 3; i++)
            {
                if (grid[index + i - 1] > 0)
                {
                    return true;
                }
            }
        }
        */
    }
    
    public void guess(int gs)
    {        
        if (!gridIsClear())
        {
            if (grid[gs] == 1)
            {
                System.out.println("Hit!");
                grid[gs] = 0;
                guesses++;                
                
                shipSink();
                /*
                System.out.println("did the lower ship sink: " + lowerShipSink());
                System.out.println("did the middle ship sink: " + middleShipSink());
                System.out.println("did the upper ship sink: " + upperShipSink());
                
                if (gs <= 2)
                {
                    if (lowerShipSink())
                    {
                        System.out.println("Sink!");
                    }
                }
                if (gs >= 7)
                {
                    if (upperShipSink())
                    {
                        System.out.println("Sink!");
                    }
                }
                if (gs > 2 && gs < 7)
                {
                    if (middleShipSink())
                    {
                        System.out.println("Sink!");
                    }
                }
                
               
                System.out.print("grid: ");
                for (int i = 0; i < 10; i++)
                {
                    System.out.print(grid[i]);
                } 
                System.out.println();
                */
            }
            else
            {
                System.out.println("Miss.");
                guesses++;
            }
        }
        if (gridIsClear())
        {
            System.out.println();
            System.out.println("Game Over!");
            System.out.println("Guess count: " + guesses);
        }
    }
    
    private void shipSink()
    {
        for (int i = 0; i < 2; i++)
        {
            boolean shipSunk = true;
    
            for (int j = 0; j < 3; j++)
            {
                if (grid[shipPositions[i] + j] == 1)
                {
                    shipSunk = false; 
                    break;
                }
            }
            
            if (shipSunk && !shipSinks[i]) 
            {
                System.out.println("Sink!");
                shipSinks[i] = true;
            }
        }
        //System.out.println("ship pos: " + shipPositions[0] + "//" + shipPositions[1]);

        //System.out.println("Sink? 1: " + shipSinks[0] + "2: " + shipSinks[1]);         
    }
    
    /*
    private boolean lowerShipSink()
    {
        switch (lowerShip)
        {
            case 0:
            {
                if (grid[0] == 0 && grid[1] == 0 && grid[2] == 0)
                    return true;
            }
            case 1:
            {
                if (grid[1] == 0 && grid[2] == 0 && grid[3] == 0)
                    return true;
            }
            case 2:
            {
                if (grid[2] == 0 && grid[3] == 0 && grid[4] == 0)
                    return true;
            }
        }
        return false;
    }
    
    private boolean middleShipSink()
    {
        switch (middleShip)
        {
            case 3:
            {
                if (grid[2] == 0 && grid[3] == 0 && grid[4] == 0)
                    return true;
            }
            case 4:
            {
                if (grid[3] == 0 && grid[4] == 0 && grid[5] == 0)
                    return true;
            }
            case 5:
            {
                if (grid[4] == 0 && grid[5] == 0 && grid[6] == 0)
                    return true;
            }
            case 6:
            {
                if (grid[5] == 0 && grid[6] == 0 && grid[7] == 0)
                    return true;
            }
        }
        return false;
    }
    
    private boolean upperShipSink()
    {
        switch (upperShip)
        {
            case 7:
            {
                if (grid[5] == 0 && grid[6] == 0 && grid[7] == 0)
                    return true;
            }
            case 8:
            {
                if (grid[6] == 0 && grid[7] == 0 && grid[8] == 0)
                    return true;
            }
            case 9:
            {
                if (grid[7] == 0 && grid[8] == 0 && grid[9] == 0)
                    return true;
            }
        }
        return false;
    }
    */
    
    public boolean gridIsClear()
    {
        for (int i = 0; i < 10; i++)
        {
            if (grid[i] > 0)
                return false;
        }
        return true;
    }
}