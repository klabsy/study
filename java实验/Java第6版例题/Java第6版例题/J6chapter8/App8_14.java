//filename：App8_14
interface Face
{
  final static double PI=3.14;
  public default double area(int r)
  {
    return r*r*PI;
  }
  abstract double volume(int r,double h);
  public static String show()
  {
    return "我是Face接口中的静态方法";
  }
}
public class App8_14 implements Face
{
  public double volume(int r,double h)
  {
    return area(r)*h;
  }
  public static void main(String[] args)
  {
    System.out.println(Face.show());
    App8_14 ap=new App8_14();
    System.out.println("圆柱体体积为："+ap.volume(1,2.0));
  }
}
