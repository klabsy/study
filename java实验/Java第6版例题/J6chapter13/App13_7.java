//filename£ºApp13_7.java
@FunctionalInterface
interface IntFun
{
  double dis(int n);
}
public class App13_7
{
  public static void main(String[] args)
  {
    IntFun fun=(i)->{return 2*i;};
    double m=fun.dis(3);
    System.out.println(m);
  }
}
