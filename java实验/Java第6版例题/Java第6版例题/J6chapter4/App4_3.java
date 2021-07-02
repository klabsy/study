//filename：App4_3.java
public class App4_3
{
  public static void main (String[] args) throws Exception
  {
    int a=100, b=6;
    char oper;
    System.out.print("请输入运算符：");
    oper=(char)System.in.read();
    switch (oper)
    {
      case '+':
        System.out.println(a+"+"+b+"="+(a+b));
        break;
      case '-':
        System.out.println(a+"-"+b+"="+(a-b));
        break;
      case '*':
        System.out.println(a+"*"+b+"="+(a*b));
        break;
      case '/':
        System.out.println(a+"/"+b+"="+((float)a/b));
        break;
      default:
        System.out.println("输入的符号不正确！");
    }
  }
}
