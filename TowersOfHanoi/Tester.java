import java.util.Scanner;

public class Tester
{
    public static void main(String args[])
    {
        Scanner kbReader = new Scanner(System.in);
        System.out.println("Enter the amount of disks: ");
        int n = kbReader.nextInt();
        
        towersOfHanoi Hanoi = new towersOfHanoi(n);

        System.out.println("Start:");
        Hanoi.towersOfHanoiGame(n, 1, 3, 2);
        //Hanoi.towersOfHanoi(2, 1, 3, 2); //3
        //Hanoi.towersOfHanoi(3, 1, 3, 2); //7
        //Hanoi.towersOfHanoi(4, 1, 3, 2); //15
        //Hanoi.towersOfHanoi(5, 1, 3, 2); //31
        //Hanoi.towersOfHanoi(6, 1, 3, 2); //63
        //Hanoi.towersOfHanoi(7, 1, 3, 2); //127
        //Hanoi.towersOfHanoi(8, 1, 3, 2); //255
        //1,048,575 optimal moves for 20 disks (~20 seconds to run)
        System.out.println("Finish!");
    }
} 