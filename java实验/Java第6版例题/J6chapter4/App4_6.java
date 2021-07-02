//filename：App4_6.java
import java.io.*;
public class App4_6
{
  public static void main(String[] args) throws IOException
  {
    int a=0,b=1,n,num;
    String str;
    BufferedReader buf;
    buf=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("请输入一个正整数：");
    str=buf.readLine();
    num= Integer.parseInt (str);
    while (b<num)
    {
      n=a+b;  
      a=b;
      b=n;
    }
    if (num==b)  System.out.println(num+"是Fibonacci数");
    else System.out.println(num+"不是Fibonacci数");
  }
}
