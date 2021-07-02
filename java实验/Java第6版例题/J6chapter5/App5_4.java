//filename£ºApp5_4.java
public class App5_4
{
  public static void main(String[] args)
  {
    int i,j;
    int level=7;
    int[][] iaYong =new int[level][];
    System.out.println("Ñî»ÔÈý½ÇÐÎ");
    for (i=0;i<iaYong.length;i++)
      iaYong[i]=new int [i+1];
    iaYong[0][0]=1;
    for (i=1;i<iaYong.length;i++)
    {
      iaYong[i][0]=1;
      for (j=1;j< iaYong[i].length-1;j++)
        iaYong[i][j]= iaYong[i-1][j-1]+ iaYong[i-1][j];
      iaYong[i][ iaYong[i].length-1]=1;
    }
    for(int[] row : iaYong)
    {
      for(int col : row)
        System.out.print(col+ "  ");
      System.out.println();
    }
  }
}
