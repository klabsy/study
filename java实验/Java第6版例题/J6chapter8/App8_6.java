//filename£ºApp8_6.java
class AAA
{
  static final double PI=3.14;
  public final void show()
  {
    System.out.println("pi="+PI);
  }
}
class BBB extends AAA
{
  private int num=100;
  public void show()
  {
    System.out.println("num="+num);
  }
}
public class App8_6
{
  public static void main(String[] args)
  {
    BBB ex=new BBB();
    ex.show();
  }
}
