//interface class, methods that each block can do
//each block requires its own collision detection patterns, rotation patterns, movements left & right BASED on each rotation (easy for BlockO but not BlockI)
//BlockI holds most of the comments since it's extremely repetitive & basically mundane brute force 
//some blocks require to be opaque because of the bounds (2x3) which have two empty spaces (for J, L, S, & Z blocks)

public interface Block
{
    public void startFalling();
    
    public void moveLeft();
    
    public void moveRight();
    
    public void moveDown();
    
    //Block Rotation System:
    //https://tetris.wiki/Super_Rotation_System
    public void rotate();
    
    public void place();
}