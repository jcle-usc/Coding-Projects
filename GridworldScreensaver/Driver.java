import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class Driver
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid(40, 70));
        world.add(new Location(1,1), new RockDropper(Color.RED));
        world.add(new Location(5,5), new RockDropper(Color.YELLOW));
        world.add(new Location(10,10), new RockDropper(Color.GREEN));
        world.add(new Location(15,15), new RockDropper(Color.BLUE));
        world.add(new Location(20,20), new RockEater());

        world.show();
    }
}