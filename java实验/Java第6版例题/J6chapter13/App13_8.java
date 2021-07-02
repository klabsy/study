//filename：App13_8.java
import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;
public class App13_8
{
  public static void main(String[] args)
  {
    String[] names={"唐僧 ","孙悟空 ","猪八戒 ","沙和尚"};
    List<String> al=Arrays.asList(names);
    System.out.print("用匿名内部类方式遍历输出：");
    al.forEach(new Consumer<String>()
      {
        @Override
        public void accept(String s)
        {
           System.out.print(s);
        }
      }
    );
    System.out.print("\n使用Lambda表达式遍历输出：");  
    al.forEach((s)->System.out.print(s));
    //al.forEach(System.out::print);
  }
}
