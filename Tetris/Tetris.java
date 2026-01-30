import javax.swing.*; 
import java.awt.*; 
import java.util.ArrayList;

public class Tetris
{
    private JPanel tetris;
    private boolean gameOver;
    private boolean blockPlaced;
    private int previousBlock;
    private int rowFilled;
    private ArrayList<Block> blocksPlaced;
    
    public Tetris(JPanel grid)
    {
        tetris = grid;
        gameOver = false;
        blockPlaced = false;
        previousBlock = 7;
        blocksPlaced = new ArrayList<Block>();
    }
    
    public void runGame()
    {
        createNewBlock();
        /* honestly the logic is extremely flawed as of now
        while (!gameOver)
        {
            if (blockPlaced)
            {
                if (lineFilled())
                    deleteLine();
                createNewBlock();
                blockPlaced = false;
            }
        }
        */
    }
        
    public void createNewBlock()
    {
        int randomBlock = (int)(Math.random() * 7); //picks a random block
        if (previousBlock == randomBlock) //prevents getting the same block twice
            createNewBlock();
        previousBlock = randomBlock;
        switch (randomBlock)
        {
            case 0:
                BlockI blockI = new BlockI(tetris, this); //creates JPanel for block
                tetris.add(blockI); //adds block to the JPanel grid (JPanel on top of a JPanel)
                blockI.startFalling(); //activates the Timer
                blocksPlaced.add(blockI);
                break;
            case 1:
                BlockO blockO = new BlockO(tetris, this);
                tetris.add(blockO);
                blockO.startFalling();
                blocksPlaced.add(blockO);
                break;
            case 2:
                BlockT blockt = new BlockT(tetris, this);
                tetris.add(blockt);
                blockt.startFalling();
                blocksPlaced.add(blockt);
                break;
            case 3:
                BlockS blocks = new BlockS(tetris, this);
                tetris.add(blocks);
                blocks.startFalling();
                blocksPlaced.add(blocks);
                break;
            case 4:
                BlockZ blockz = new BlockZ(tetris, this);
                tetris.add(blockz);
                blockz.startFalling();
                blocksPlaced.add(blockz);
                break;
            case 5:
                BlockJ blockj = new BlockJ(tetris, this);
                tetris.add(blockj);
                blockj.startFalling();
                blocksPlaced.add(blockj);
                break;
            case 6:
                BlockL blockl = new BlockL(tetris, this);
                tetris.add(blockl);
                blockl.startFalling();
                blocksPlaced.add(blockl);
                break;
        }
    }
    
    private boolean lineFilled()
    {
        for (int r = 0; r < Grid.grid.length; r++)
        {
            for (int c = 0; c < Grid.grid[r].length; c++)
            {
                if (Grid.grid[r][c] == 0)
                {
                    rowFilled = r;
                    return false;
                }
            }
        }
        return true;
    }
    
    private void deleteLine()
    {
        /*
        int x;
        for (int i = 0; i < blocksPlaced.size(); i++)
        {
            x = (rowFilled * 35) + 585;
            if ((blocksPlaced.get(i)).getX() == x)
            {
                //not coded yet
            }
        }
        for (int c = 0; c < Grid.grid[rowFilled].length; c++)
        {
            Grid.grid[rowFilled][c] = 0;
        }
        */
    }
    
    public void blockPlaced()
    {
        createNewBlock();
    }
}