//filename：App9_2.java
public class App9_2
{
  public static void main(String[] args)
  {
    int i;
    int[] a={1,2,3,4}; 
    for(i=0;i<5;i++)
    {
      try
      {
        System.out.print("a["+i+"]/"+i+"="+(a[i]/i));
      }
      catch(ArrayIndexOutOfBoundsException e)
      {
        System.out.print("捕获到了数组下标越界异常");
      }
      catch(ArithmeticException e)
      {
        System.out.print("异常类名称是："+e);
      }
      catch(Exception e)
      {
        System.out.println("捕获"+e.getMessage()+"异常！");
      }
      finally
      {
        System.out.println("    finally   i="+i);
      }
    }
    System.out.println("继续！！");
  }
}
