//filename£ºApp4_11.java
public class App4_11
{
  public static void main(String[] args)
  {
    int i,n=10,s=0;
    for(i=1;i<=n;i++)
      s=s+i;
    System.out.println("Sum=1+¡­¡­+"+n+"="+s);
    s=0;
    System.out.print("Sum=");
    for(i=n;i>1;i--)
    {
      s+=i;
      System.out.print(i+"+");
    }
    System.out.println(i+"="+(s+i));
  }
}
