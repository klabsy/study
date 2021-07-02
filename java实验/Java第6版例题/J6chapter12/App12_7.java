//filename：App12_7.java
import java.util.*;
class StringStack
{
  private LinkedList<String> ld=new LinkedList<String>();
  public void push(String name)
  {
    ld.addFirst(name);
  }
  public String pop()
  {
    return ld.removeFirst();
  }
  public boolean isEmpty()
  {
    return ld.isEmpty();
  }
}
public class App12_7
{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    StringStack stack=new StringStack();
    System.out.println("请输入数据(quit结束)");
    while(true)
    {
      String input=sc.next();
      if(input.equals("quit"))
        break;
      stack.push(input);
    }
    System.out.println("先进后出的顺序：");
    while(!stack.isEmpty())
      System.out.print(stack.pop()+"  ");
  }
}
