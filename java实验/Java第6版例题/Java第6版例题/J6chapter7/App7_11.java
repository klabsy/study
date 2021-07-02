//filename：App7_11.java
class Cylinder
{
  private static double pi=3.14;
  private double radius;
  private int height;
  public Cylinder(double r, int h) 
  {
    radius=r;
    height=h;
  }
  public void compare(Cylinder volu)
  {
    if (this==volu)
      System.out.println("这两个对象相等");
    else
      System.out.println("这两个对象不相等");
  }
}
public class App7_11
{
  public static void main(String[] args)
  {
    Cylinder volu1=new Cylinder(1.0,2);
    Cylinder volu2=new Cylinder(1.0,2); 
    Cylinder volu3= volu1;
    volu1.compare(volu2);
    volu1.compare(volu3);
  }
}
