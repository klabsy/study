//filename£ºApp4_5.java
public class App4_5
{
  public static void main (String[] args)
  {
    final int MAX=15;
    int i=0,j=1,k=1;
    while(k<=MAX)
    {
      System.out.print (" "+i+" "+j);
      i=i+j;
      j=i+j;
      k=k+2;
    }
    System.out.println();
  }
}
