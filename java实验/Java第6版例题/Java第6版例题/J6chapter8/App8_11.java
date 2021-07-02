//filename：App8_11.java
interface IShape
{
  final double PI=3.14;
  abstract double getArea();
  abstract double getLength();
}
class Circle implements IShape
{
  double radius;
  public Circle(double r)
  {
    radius=r;
  }
  public double getArea()
  {
    return PI*radius*radius;
  }
  public double getLength()
  {
    return 2*PI*radius;
  }
}
class Rectangle implements IShape
{
  private double width;
  private double height;
  public Rectangle(double width,double height)
  {
    this.width=width;
    this.height=height;
  }
  public double getArea()
  {
    return width*height;
  }
  public double getLength()
  {
    return 2*(width+height);
  }
}
public class App8_11
{
  public static void main(String[] args)
  {
    IShape circle=new Circle(5.0);
    System.out.print("圆面积="+circle.getArea());
    System.out.println("；周长="+circle.getLength());
    Rectangle rect =new Rectangle(6.5,10.8);
    System.out.print("矩形面积="+rect.getArea());
    System.out.println("；周长="+rect.getLength());
  }
}
