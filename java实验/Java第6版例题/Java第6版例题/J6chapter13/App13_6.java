//filename£ºApp13_6.java
interface IntFun
{
  double dis(int n);
}
public class App13_6
{
  public static void main(String[] args)
  {
    IntFun fun=(new IntFun()
      {
        public double dis(int i)
        {return 2*i;}
      }
    );
    double m=fun.dis(3);
    System.out.println(m);
  }
}
