public class Battleship2D
{   
    private int[][] grid = new int[10][10]; //creates 10x10 battleship grid
    private int[][] blankGrid = new int[10][10]; //grid to show user, holds input of hits & misses
    private int[][] shipPositions = new int[4][4]; //keeps track of each ship's direction, starting row index, & starting column index for 4 ships
    private boolean[] shipSinks = new boolean[4]; //keeps track if each ship sunk or not for 4 ships
    private int shipNumber; //the number of ships 
    private int shipLength; //the length of each ship
    private int startIndex = 7; //for math randomizer
    private int direction; //direction of ship (horizontal or vertical)
    private int shipStartRowIndex; //the start row index of each ship
    private int shipStartColumnIndex; //the start column index of each ship
    private int guesses; //counts the number of total guesses

    public Battleship2D()
    {        
        setShips();
    }
    
    private void setShips()
    {        
        while (shipNumber < 4) //makes sure 4 ships are created
        {   
            for (shipLength = 2; shipLength < 6; shipLength++) //each ship has a unique length: 2, 3, 4, & 5
            {
                /*
                System.out.println("Grid before adding ship: ");
                for (int row = 0; row < 10; row++)
                {
                    for (int column = 0; column < 10; column++)
                    {
                        System.out.print(grid[row][column]);
                    }
                    System.out.println();
                }
                */
                direction = (int)(Math.random() * 2); //0 is horizontal, 1 is vertical  
                shipStartRowIndex = (int)(Math.random() * (shipLength + startIndex)); //as the ship length increase, the starting index decreases to prevent overlap
                shipStartColumnIndex = (int)(Math.random() * (shipLength + startIndex)); 
                //lngth = 2, * = 9; lngth = 3, * = 8; lngth = 4, * = 7; lngth = 5, * = 6
                /*
                System.out.println();
                if (shipOverlap())
                {
                    System.out.println("overlap?: " + shipOverlap());
                    System.out.println("ship number: " + shipNumber); 
                    System.out.println("start index: " + startIndex);
                    System.out.println("ship length: " + shipLength);
                    System.out.println("direction: " + direction);        
                    System.out.println("start row index: " + shipStartRowIndex);        
                    System.out.println("start column index: " + shipStartColumnIndex);
                    System.out.println();
                }
                System.out.println();
                */
                if (!shipOverlap())
                { 
                    /*
                    System.out.println("ship number: " + shipNumber); 
                    System.out.println("start index: " + startIndex);
                    System.out.println("ship length: " + shipLength);
                    System.out.println("direction: " + direction);        
                    System.out.println("start row index: " + shipStartRowIndex);        
                    System.out.println("start column index: " + shipStartColumnIndex); 
                    System.out.println();
                    */
                    if (direction == 0) //horizontal
                    {
                        for (int i = 0; i < shipLength; i++)
                        {
                            grid[shipStartRowIndex][shipStartColumnIndex + i] = 1;
                        }
                    }
                    if (direction == 1) //vertical
                    {
                        for (int i = 0; i < shipLength; i++)
                        {
                            grid[shipStartRowIndex + i][shipStartColumnIndex] = 1;
                        }
                    }
                    shipPositions[shipNumber][0] = shipNumber; //stores the starting indeces of the ships (row & column)
                    shipPositions[shipNumber][1] = direction;
                    shipPositions[shipNumber][2] = shipStartRowIndex;
                    shipPositions[shipNumber][3] = shipStartColumnIndex;
                    
                    /*
                    System.out.println("Ship positions: ");
                    for (int shipNum = 0; shipNum < 4; shipNum++)
                    {
                        for (int col = 0; col < 4; col++)
                        {
                            System.out.print(shipPositions[shipNum][col]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    */
                    
                    shipNumber++;
                    startIndex = startIndex - 2;
                    
                    /*
                    System.out.println("Grid after adding ship: ");
                    for (int row = 0; row < 10; row++)
                    {
                        for (int column = 0; column < 10; column++)
                        {
                            System.out.print(grid[row][column]);
                        }
                        System.out.println();
                    }
                    System.out.println();
                    */
                }
                else if (shipOverlap())
                {
                    shipLength--; //keeps the length appropriate for the same number of ships 
                }
            }
        }
    }
    
    private boolean shipOverlap()
    {
        if (direction == 0) //horizontal
        {
            for (int i = 0; i < shipLength; i++)
            {
                if (grid[shipStartRowIndex][shipStartColumnIndex + i] == 1)
                {
                    return true;
                }
            }
        }
        if (direction == 1) //vertical
        {
            for (int i = 0; i < shipLength; i++)
            {
                if (grid[shipStartRowIndex + i][shipStartColumnIndex] == 1)
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void guess(int rowGuess, int columnGuess)
    {            
        if (!gridIsClear())
        {
            //System.out.println("row guess: " + rowGuess);
            //System.out.println("column guess: " + columnGuess);
            if (grid[rowGuess][columnGuess] == 1)
            {
                System.out.println();
                System.out.println("Hit!");
                
                grid[rowGuess][columnGuess] = 0; //makes the battleship grid value 0
                blankGrid[rowGuess][columnGuess] = 1; //makes the blank grid value 1, meaning that the spot was a hit
            
                guesses++;                
               
                shipSink(); //checks if the ship sunk or not
                
                System.out.println();
                System.out.println("Grid: "); //prints the blank grid for the user to see & guess
                int col = 9;
                for (int row = 0; row < 10; row++)
                {
                    System.out.print(col + "|");
                    for (int column = 0; column < 10; column++)
                    {
                        System.out.print(blankGrid[row][column]);
                    }
                    col--;
                    System.out.println();
                }
                System.out.println(" -----------");
                System.out.println("  ABCDEFGHIJ");
            }
            else
            {
                System.out.println();
                System.out.println("Miss.");
                
                guesses++;
                
                blankGrid[rowGuess][columnGuess] = 2; //makes the blank grid value 2, meaning that the spot was a miss
                
                System.out.println();
                System.out.println("Grid: ");
                int col = 9;
                for (int row = 0; row < 10; row++)
                {
                    System.out.print(col + "|");
                    for (int column = 0; column < 10; column++)
                    {
                        System.out.print(blankGrid[row][column]);
                    }
                    col--;
                    System.out.println();
                }
                System.out.println(" -----------");
                System.out.println("  ABCDEFGHIJ");
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
        for (int ship = 0; ship < 4; ship++) //checks through all 4 ships
        {
            boolean shipSunk = true;                
            
            if (shipPositions[ship][1] == 0) //horizontal
            {
                for (int i = 0; i < ship + 2; i++) //checks the appropriate length with the appropriate ship number (ship 0 = length of 2, etc)
                {
                    if (grid[shipPositions[ship][2]][shipPositions[ship][3] + i] == 1) //checks the starting row & column index stored for the appropriate ship
                    {
                        shipSunk = false;
                    }
                }
            }
            else if (shipPositions[ship][1] == 1) //vertical
            {
                for (int i = 0; i < ship + 2; i++)
                {
                    if (grid[shipPositions[ship][2] + i][shipPositions[ship][3]] == 1)
                    {
                        shipSunk = false;
                    }
               }
            }
            
            if (shipSunk && !shipSinks[ship]) //if it wasn't sunk previously, it now becomes considered "sunk" and cannot print sunk again
            {
                System.out.println("Sink!");
                shipSinks[ship] = true;
            }
        }
    }
    
    public boolean gridIsClear()
    {
        for (int row = 0; row < 10; row++) //checks through entire battleship grid, only true when the battleship grid values are all 0
        {
            for (int column = 0; column < 10; column++)
            {
                if (grid[row][column] > 0)
                {
                    return false;
                }
            }
        }
        return true;
    }
}