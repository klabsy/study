//filename：App9_3.java
public class App9_3
{
  public static void main(String[] args)
  {
    int a=5,b=0;
    try
    {
      if(b==0)
        throw new ArithmeticException();
      else
        System.out.println(a+"/"+b+"="+a/b);
    }
    catch(ArithmeticException e)
    {
      System.out.println("异常："+e+" 被抛出了！");
      e.printStackTrace();
    }
  }
}
