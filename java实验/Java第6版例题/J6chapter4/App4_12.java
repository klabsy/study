//filename：App4_12.java
public class App4_12
{
  public static void main(String[] args)
  {
    final int MAX=100;
    int j,k,n;
    System.out.println("2～"+MAX+"之间的所有素数为：");
    System.out.print("2\t");
    n=1;
    k=3;
    do
    {
      j=3;
      while(j<Math.sqrt(k) && (k % j!=0))
        j++;
      if (j>Math.sqrt(k))
      {
        System.out.print(k+"\t");
        n++; 
        if (n%10==0)  System.out.println( );
      }
      k=k+2;
    }while(k<MAX);
    System.out.println("\n共有"+n+"个素数");
  }
}
