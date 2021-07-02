//filename£ºApp6_7.java
public class App6_7
{
  public static void display(int x,String...arg)
  {
    System.out.print(x+"  ");
    for(int i=0;i<arg.length;i++)
      System.out.print(arg[i]+"  ");
    System.out.print("\n");
  }
  public static void main(String[] args)
  {
    display(5);
    display(6,"a","b");
    display(7,"AA","BB","CC","DD");
  }
}