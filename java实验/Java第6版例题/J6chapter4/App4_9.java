//filename：App4_9.java     
import java.io.*;
public class App4_9
{
public static void main(String[] args) throws IOException
  {
    int a,b,k;
    String str1,str2;
    BufferedReader buf;
    buf=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("请输入第一个数 a=");
    str1=buf.readLine();
    a=Integer.parseInt(str1);
    System.out.print("请输入第二个数 b=");
    str2=buf.readLine();
    b=Integer.parseInt(str2);
    System.out.print("gcd("+a+","+b+")=");
    do {
      k=a % b;
      a=b;
      b=k;
    }while(k!=0); 
    System.out.println(a); 
  }
}
