import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.awt.Color;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;

public class RockDropper extends Critter
{
    public RockDropper(Color rockDropperColor)
    {
        setColor(rockDropperColor);
    }
    
    public void makeMove(Location loc)
    {
        Grid<Actor> gr = getGrid();
        Location currentLoc = getLocation();
            
        super.makeMove(loc);
        
        Rock rock = new Rock(getColor());
        if (currentLoc != loc) //so that it doesn't put a rock on a trapped RockDropper
            rock.putSelfInGrid(gr, currentLoc);
        
        /*
        if (loc == null)
            removeSelfFromGrid();
        else
        {
            Grid<Actor> gr = getGrid();
            Location currentLoc = getLocation();
            
            moveTo(loc);
            
            Rock rock = new Rock(getColor());
            rock.putSelfInGrid(gr, currentLoc);
        }
        */
    }
}