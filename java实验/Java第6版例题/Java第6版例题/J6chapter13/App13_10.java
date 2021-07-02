//filename£ºApp13_10.java
@FunctionalInterface
interface IShow<P,R>
{ public R info(P p); }
public class App13_10
{
  public static void main(String[] args)
  {  
    IShow<Integer,String> ip=String::valueOf;
    String s=ip.info(888);
    System.out.println(s);
  }
}
