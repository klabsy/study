//filename：App5_2.java
public class App5_2
{
  public static void main(String[] args)
  {
    int i,max,sec;
    int[] a={8,50,20,7,81,55,76,93};
    if (a[0]>a[1])
    {
      max=a[0];
      sec=a[1];
    }
    else
    {
      max=a[1];
      sec=a[0];
    }
    System.out.print("数组的各元素为："+a[0]+ "  "+a[1]);
    for(i=2;i<a.length;i++)
    {
      System.out.print("  " + a[i]);
      if (a[i]>max)
      {
        sec=max;
        max=a[i];
      }
      else if(a[i]>sec) sec=a[i];
    }
    System.out.print("\n其中的最大值是："+max);
    System.out.println("     次最大值是："+sec);
  }
}
