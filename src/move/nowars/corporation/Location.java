package move.nowars.corporation;

public class Location {

    public int x,y;
    public World world;

    public Location(World world, int x, int y){
        this.x = x;
        this.y = y;
        this.world = world;
    }

}
