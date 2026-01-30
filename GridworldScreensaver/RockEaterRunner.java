import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import java.awt.Color;

public class RockEaterRunner //CritterRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(7, 8), new Rock());
        world.add(new Location(3, 3), new Rock());
        world.add(new Location(1, 2), new Rock());
        world.add(new Location(2, 6), new Rock());
        world.add(new Location(3, 3), new Rock());
        world.add(new Location(4, 8), new Rock());
        world.add(new Location(5, 6), new Rock());
        world.add(new Location(6, 4), new Rock());
        world.add(new Location(8, 9), new Rock());
        world.add(new Location(9, 1), new Rock());
        //world.add(new Location(2, 8), new Flower(Color.BLUE));
        //world.add(new Location(5, 5), new Flower(Color.PINK));
        //world.add(new Location(1, 5), new Flower(Color.RED));
        //world.add(new Location(7, 2), new Flower(Color.YELLOW));
        //world.add(new Location(4, 4), new RockDropper(Color.BLUE));
        world.add(new Location(5, 8), new RockEater());
        world.show();
    }
}