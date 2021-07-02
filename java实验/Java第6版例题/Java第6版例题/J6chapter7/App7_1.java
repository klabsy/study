//filename：App7_1.java
class Cylinder
{
  private double radius;
  private int height;
  private double pi=3.14;
  double area()
  {
    return pi*radius*radius;
  }
  double volume()
  {
    return area()*height;
  }
}
public class App7_1
{
  public static void main(String[] args)
  {
    Cylinder volu;
    volu=new Cylinder();
    volu.radius=2.8;
    volu.height=-5;
    System.out.println("底圆半径="+volu.radius);
    System.out.println("圆柱的高="+volu.height);
    System.out.print("圆柱");
    System.out.println("底面积="+volu.area());
    System.out.println("圆柱体体积="+volu.volume());
  }
}
