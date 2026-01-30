import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.awt.Color;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import java.util.ArrayList;

public class RockEater extends Critter
{   
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> rockLocations = new ArrayList<Location>();
        
        for (Location loc : getGrid().getOccupiedLocations())
        {
            if (getGrid().get(loc) instanceof Rock) //(getGrid().get(loc) == Rock)
            {
                rockLocations.add(loc);
            }
        }
        
        return rockLocations;
    }
}