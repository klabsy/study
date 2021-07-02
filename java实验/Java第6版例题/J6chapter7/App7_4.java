//filename：App7_4.java
class Cylinder
{
  private double radius;
  private int height; 
  private double pi=3.14;
  public Cylinder(double r, int h)
  {
    radius=r;
    height=h;
  }
  double area()
  {
    return pi* radius* radius;
  }
  double volume()
  {
    return area()*height;
  }
}
public class App7_4
{
  public static void main(String[] args)
  {
    Cylinder volu=new Cylinder(3.5, 8);
    System.out.println("圆柱底面积="+ volu.area());
    System.out.println("圆柱体体积="+volu.volume());
  }
}
