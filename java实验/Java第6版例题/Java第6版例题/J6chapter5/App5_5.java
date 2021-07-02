//filename£ºApp5_5.java
public class App5_5
{
  public static void main(String[] args)
  {
    int i,j,k,sum=0;
    int[][][] a={{{1,2},{3,4}},{{5,6},{7,8}}};
    for (i=0;i<a.length;i++)
      for (j=0;j<a[i].length;j++)
        for (k=0;k<a[i][j].length;k++)
        {
          System.out.println("a["+i+"]["+j+"]["+k+"]="+ a[i][j][k]);
          sum+=a[i][j][k];
        }
    System.out.println("sum="+sum);
  }
}
