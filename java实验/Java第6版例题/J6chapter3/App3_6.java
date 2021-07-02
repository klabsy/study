//filename：App3_6.java
import java.util.*;
public class App3_6
{
  public static void main(String[] args)
  {
    int num1;
    double num2;
    Scanner reader=new Scanner(System.in);
    System.out.print("请输入第一个数：");
    num1= reader.nextInt();
    System.out.print("请输入第二个数：");
    num2= reader.nextDouble();
    System.out.println(num1+"*"+num2+"="+((float)num1*num2));
  }
}
