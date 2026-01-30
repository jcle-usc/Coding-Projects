import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;
import java.awt.Color;

public class FlowerSpawner extends Flower
{
    //private static final Color DEFAULT_COLOR = Color.PINK;
    //private static final double DARKENING_FACTOR = 0.05;
    //private ArrayList<Flower> allFlowers = new ArrayList<Flower>();
    //private ArrayList<Location> flowerLocations = new ArrayList<Location>();
    
    public FlowerSpawner() //since Flower has 2 constructors, need redefining of both
    {
        //automatically calls super();
    }

    public FlowerSpawner(Color initialColor)
    {
        super(initialColor); //changes the color of the BattleCritter
    }
    
    public void act()
    {   
        //The grid has a lot of wind! BattleCritter's seeds end up blowing in the wind and planting in random locations of the grid...
        //Wherever the seed is randomly placed, a flower will grow, killing whatever is in its way (the square it spawned in), and the 8 squares around it (since it grew so fast it bursted out)
        //Only the BattleCritter can spawn flowers through act(), the flowers it creates is simply a Flower that darkens
        //Once the BattleCritter dies, it will stop spawning flowers
        //The flowers distract the base Critter, directing it away from the mother spawner, until it kills it by spawning a flower under it (usually)
        
        Grid<Actor> gr = getGrid(); //get the grid where the BattleCritter is (don't need to type getGrid().
        if (gr == null) //if BattleCritter is not in a grid then exit act()
            return;
        
        Location firstLocation = getLocation(); //get initial location of the BattleCritter
        
        int x = (int)(Math.random() * gr.getNumRows()); //random x interval of BoundedGrid
        int y = (int)(Math.random() * gr.getNumCols()); //random y interval of BoundedGrid
        
        Location loc = new Location(x, y); //create new location
        //flowerLocations.add(loc);
                
        Flower flower = new Flower(getColor()); //create flower actor   
        //allFlowers.add(flower);
        
        if (flower.getGrid() == null && gr.isValid(loc) && !(loc.equals(firstLocation))) //follows the putSelfInGrid preconditions (actor not contained in grid, loc is valid) and it doesn't spawn on the initial location, killing the BattleCritter (flower spawner)
            flower.putSelfInGrid(gr, loc);
        
        //below, wherever the flower spawns, whatever is in the 8 squares around it removes itself from the grid
        ArrayList<Actor> actorNextToFlower = gr.getNeighbors(loc); //gets an ArrayList of the objects in the occupied locations adjacent to the newest flower's location
        if (actorNextToFlower.size() > 0) //if there is more than one actor around where the flower spawned (rock, critter, flower, etc)
        {
            for (Actor actor : actorNextToFlower) //go through all the actors adjacent to the flower's location
            {
                if (!(actor.getLocation()).equals(firstLocation)) //if the actor is not the BattleCritter itself (prevents self-killing)
                    gr.remove(actor.getLocation()); //remove whatever actor is next to the spawned flower
            }
        }
            
        //attempt to keep track of all the flowers in an arraylist (the flower itself & its location)
        //failed idea: every flower planted becomes poisonous, if eaten by a Critter the Critter would remove itself from the grid
        /*
        for (int i = 0; i < allFlowers.size(); i++)
        {
            Flower gridFlower = (Flower)(gr.get(flowerLocations.get(i)));
            
            if (!(gridFlower.equals(allFlowers.get(i))))
            {
                for (Location flowersLocation : gr.getOccupiedAdjacentLocations(flowerLocations.get(i)))
                {
                    gr.remove(flowersLocation);
                }
            }
        }
        */
    }
}

