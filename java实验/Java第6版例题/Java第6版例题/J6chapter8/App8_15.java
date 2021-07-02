//filename：App8_15
interface Face1
{
  final static double PI=3.14;
  public default double area(int r)
  {
    return r*r*PI;
  }
  abstract double volume(int r,double h);
}
interface Face2
{
  public default double area(int r)
  {
    return r*r;
  }
}
public class App8_15 implements Face1,Face2
{
  public double area(int r)
  {
    return Face2.super.area(r);
  }
  public double volume(int r,double h)
  {
    return area(r)*h;
  }
  public static void main(String[] args)
  {
    App8_15 ap=new App8_15();
    System.out.println("柱体体积为："+ap.volume(1,2.0));
  }
}
