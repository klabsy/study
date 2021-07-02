//filename App12_2.java
public class App12_2
{
  public static void main(String[] args)
  {
    Integer[] num={1,2,3,4,5};
    String[] str={"ºì","³È","»Æ","ÂÌ","Çà","À¶","×Ï"};
    App12_2.<Integer>display(num);
    App12_2.<String>display(str);
  }
  public static <E> void display(E[] list)
  {
    for(int i=0;i<list.length;i++)
      System.out.print(list[i]+ "  ");
    System.out.println();
  }
}
