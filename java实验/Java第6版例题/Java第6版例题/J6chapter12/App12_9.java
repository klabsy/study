//filename：App12_9.java
import java.util.*;
public class App12_9
{
  public static void main(String[] args)
  {
    HashSet<String> hs=new HashSet<String>();
    for(String a:args)
      if(!hs.add(a))
        System.out.println("元素"+a+"重复");
    System.out.println("集合的容量为："+hs.size()+"，各元素为：");
    Iterator it=hs.iterator();
    while(it.hasNext())
      System.out.print(it.next()+"  ");
  }
}
