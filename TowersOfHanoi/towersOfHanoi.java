import java.util.ArrayList;

public class towersOfHanoi
{
    private int disk; //tracks which disk the game is on 
    private int moves; //move counter
    ArrayList<Integer> pegOne = new ArrayList<Integer>();
    ArrayList<Integer> pegTwo = new ArrayList<Integer>();
    ArrayList<Integer> pegThree = new ArrayList<Integer>();

    public towersOfHanoi(int n) //constructor
    {
        for (int disks = n; disks > 0; disks--)
        {
            pegOne.add(disks);
        }
        moveOne(1, 1); //prints the Tower of Hanoi before the game starts 
    }

    public void towersOfHanoiGame(int n, int from, int to, int spare) //(n, 1, 3, 2)
    {
        if (n == 1)
        {
            disk = n;
            moves++;
            moveOne(from, to);
        }
        else
        {
            towersOfHanoiGame(n - 1, from, spare, to);
            
            disk = n;
            moves++;
            moveOne(from, to); 
            
            towersOfHanoiGame(n - 1, spare, to, from);
        }

        /* Figure 15.2: main idea -> moving (N - 1) disks from the "from" to "spare," then after the largest disk is moved to peg 3, move (N - 1) disks from the "spare" to "to"
         * ^ explains why from the parameter (n, from, to, spare) the 1st recursion switches spare & to (for moveOne(from -> spare)) then the 2nd recursion switches spare & from (for moveOne(spare -> to))
         * recursion for N -1 disks: from -> spare -> to, rebuiling the smaller tower (one disk smaller) in the spare peg and on top of the largest disk in the last peg
         * ^ for 2 disks, n = 1 tower is rebuilt (in this case it just moves over)
         * for 3 disks, n = 2 tower is rebuilt
         * for 4 disks, n = 3 tower is rebuilt 
         * for 5 disks, n = 4 tower is rebuilt etc: for the 1st recursion, you can notice the n = 3 tower rebuilt in peg 3 before moving the 4th disk in peg 2, then moving that n = 3 tower onto the 4th disk in peg 2 to move the 5th disk to peg 3
         * in essence, every tower below n is being rebuilt over and over (recursion) 
         * the middleOne(from, to) in between allows the largest disk to be moved once the 1st recursion is finished (N - 1) tower is in the peg 2         * 
         * 
         * Tester run w/ 3 disks analysis:
         * STEP #1: "Move N - 1 disks from peg 1 to peg 2" (rebuild the smaller tower in the spare peg)
         * (3, 1, 3, 2) //parameter
         * (2, 1, 2, 3) from (3 - 1, 1, to -> spare, spare -> to)
         * (1, 1, 3, 2) //switching between the spare & to (2 & 3) demonstrates odd disk recursion method for rebuilding: (noticed in playing 6, 7, & 8 disks)
         * since 1st disk & 3rd disk (largest) are odd (a disk between them), move them to the peg where the largest disk needs to go (3)
         * if the disk is not odd (2nd disk), move it to the spare peg (2)
         * 4 disks would shift the disks:
         * (4, 1, 3, 2)
         * (3, 1, 2 ,3) //instead of from 1 to 3, it's now 1 to 2
         * (2, 1, 3 ,2) //every n is switched below it
         * (1, 1, 2 ,3)
         * 
         * since (n == 1): moveOne(1, 3) //moves 1st disk to peg 3
         * 1st argument (1, 1, 3, 2) is done, backs out to the 2nd disk
         * moveOne(1, 2) //moves the 2nd disk to peg 2
         * (1, 3, 2, 1) //2nd towersOfHanoi recursion from the 2nd disk, switches from & spare
         * since (n == 1): moveOne(3, 2); //moves the 1st disk to peg 2 AFTER the 2nd disk below it moved there first
         * 
         * now, it has rebuilt the 2 tower disk in the spare AKA "move (N - 1) disks from peg 1 to peg 2"
         * 2nd argument (2, 1, 2, 3) is done, backs out to the 3rd disk
         * 
         * STEP #2: "Move one disk from peg 1 to peg 3" (move the largest disk to the last peg)
         * moveOne(1, 3) //moves the 3rd disk (largest) to peg 3 since (N - 1) disks is now in peg 2
         * 
         * STEP #3: "Move N - 1 disks from peg 2 to peg 3" (rebuild the smaller tower in the last peg)
         * (2, 2, 3, 1) //2nd towersOfHanoi recursion from the 3rd disk, switches to & spare
         * (1, 2, 1, 3) //switches spare & to again for odd disk method: since the 2nd disk needs to go in peg 3 first before the last disk, move the 1st disk in the "spare" (peg 1 now)
         * since (n == 1): moveOne(2, 1) //moves 1st disk from the spare peg (2) to the first peg (1) 
         * 1st argument (1, 2, 1, 3) is done, backs out to the 2nd disk
         * moveOne(2, 3) //moves the 2nd disk to peg 3
         * (1, 1, 3, 2) //2nd towersOfHanoi recursion from the 2nd disk, switches from & spare
         * since (n == 1): moveOne(1, 3); //moves the 1st disk to peg 3 AFTER the 2nd disk below it moved there first
         * 
         * COMPLETE !
         * 
         * 3 disks: n = 3 calls moveOne 1x, n = 2 calls moveOne 2x, n = 1 calls moveOne 4x => minimum moves: 7
         * 4 disks: n = 4 calls moveOne 1x, n = 3 calls moveOne 2x, n = 2 calls moveOne 4x, n = 1 calls moveOne 8x => minimum moves: 15
         * minimum moves is 2x the last n (+1) to account for moving the largest disk to peg 3: 2(7) + 1 = 15
         */
    }

    private void moveOne(int from, int to)
    {
        //graphical representation with numbers representing disks
        if (to == 1)
        {
            pegOne.add(disk);
            if (from == 1)
                pegOne.remove(pegOne.size() - 1);
            else if (from == 2)
                pegTwo.remove(pegTwo.size() - 1);
            else
                pegThree.remove(pegThree.size() - 1);
        }
        else if (to == 2)
        {
            pegTwo.add(disk);
            if (from == 1)
                pegOne.remove(pegOne.size() - 1);
            else if (from == 2)
                pegTwo.remove(pegTwo.size() - 1);
            else
                pegThree.remove(pegThree.size() - 1);
        }
        else
        {
            pegThree.add(disk);
            if (from == 1)
                pegOne.remove(pegOne.size() - 1);
            else if (from == 2)
                pegTwo.remove(pegTwo.size() - 1);
            else
                pegThree.remove(pegThree.size() - 1);
        } //looks like the rock paper scissors coding

        System.out.println("Move: " + moves);
        for (int d : pegOne)
        {
            System.out.print(d);
        }
        System.out.print("--");
        System.out.println();
        for (int d : pegTwo)
        {
            System.out.print(d);
        }
        System.out.print("--");
        System.out.println();
        for (int d : pegThree)
        {
            System.out.print(d);
        }
        System.out.print("--");
        System.out.println();
        System.out.println();

        //keep track of which disk
        //System.out.println("[disk " + disk + "] " + from + " ---> " + to);

        //simplest - just list moves
        //System.out.println(from + " ---> " + to);
    }
}