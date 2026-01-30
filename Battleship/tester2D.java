import java.util.Scanner;
public class tester2D
{    
    public static void main(String[] args)
    {                
        Scanner kbReader = new Scanner(System.in);
        
        Battleship2D game = new Battleship2D(); 
             
        System.out.println("Welcome to Battleship.");
        System.out.println("There are 4 ships with lengths 2, 3, 4, & 5. ");
        System.out.println("0: water, 1: hit, 2: miss");
        
        int[][] blankGrid = new int[10][10]; //creates blank grid to display the indeces for user's convenience
        ;
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
        
        while (!game.gridIsClear())
        {
            System.out.println();
            System.out.println("Guess the row index (0-9) where the battleships are: ");
            int row = kbReader.nextInt();
            
            System.out.println("Guess the column letter (A-I) where the battleships are: ");
            String columnString = kbReader.next();
            char columnChar = columnString.charAt(0);
            int columnGuess = (int)columnChar;
            columnGuess = columnGuess - 65; //converts letter to ASCII value to grid (0-9): A = 0, B = 1, etc.
            
            int rowGuess = 0;
            for (int i = 0; i < 5; i++) //as the grid starts from top right, this converts the row so that the grid starts from bottom right (how battleship grids normally work)
            {
                if (row == i)
                {
                    rowGuess = 9 - i; //ex. if row was 0, then rowGuess is 9 to match the backwards 2d array properties for rows (column is defaulty 0-9 correct)
                    break;
                }
            }
            int count = 1;
            for (int i = 5; i < 10; i++)
            {
                if (row == i)
                {
                    rowGuess = i - count;
                    break;
                }
                count = count + 2;
            }
            
            game.guess(rowGuess, columnGuess); //keeps guessing while the grid is not clear
        }
    }
}