//filename£ºApp8_16.java
enum Direction
{ EAST,SOUTH,WEST,NORTH }
public class App8_16
{
  public static void main(String[] args)
  {
    Direction dir=Direction.EAST;
    Direction dir1=Direction.valueOf("NORTH");
    System.out.println(dir);
    System.out.println("  "+dir1);
    for(Direction d:Direction.values())
      System.out.println("ÐòºÅ:"+d.ordinal()+" µÄÖµÎª£º"+d.name());
  }
}
