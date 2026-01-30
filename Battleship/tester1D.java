import java.util.Scanner;
public class tester1D
{    
    public static void main(String[] args)
    {                
        Scanner kbReader = new Scanner(System.in);
        
        Battleship1D game = new Battleship1D();
                
        while (!game.gridIsClear())
        {
            System.out.println("Guess the index (0-9) where the battleships are: ");
            int gs = kbReader.nextInt();
            
            game.guess(gs);
        }
    }
}