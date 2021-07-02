//filename：App4_7.java
import java.util.*;
public class App4_7
{
  public static void main(String[] args) 
  {
    double sum=0;
    int n=0;
    System.out.println("请输入多个数，每输入一个数后按Enter或Tab或空格键确认：");
    System.out.println("最后输入一个非数字结束输入操作");
    Scanner reader=new Scanner(System.in);
    while(reader.hasNextDouble() )
    {
      double x=reader.nextDouble(); 
      sum=sum+x;
      n++;
    }
    System.out.print("共输入了"+n+"个数，其和为："+sum);
  }
}
