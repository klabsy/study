//filename：App6_4.java
class Cylinder
{
  double radius;
  int height;
  double pi;
  void setCylinder(double r,int h,double p)
  {
    pi=p;
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
public class App6_4
{
  public static void main(String[] args)
  {
    Cylinder volu=new Cylinder();
    volu.setCylinder(2.5, 5,3.14);
    System.out.println("底圆半径="+volu.radius);
    System.out.println("圆柱的高="+volu.height);
    System.out.println("圆周率pi="+volu.pi);
    System.out.print("圆柱");
    System.out.println("底面积="+volu.area());
    System.out.println("圆柱体体积="+volu.volume());
  }
}
