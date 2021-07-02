//filename：App12_8.java
import java.util.*;
public class App12_8
{
  public static void main(String[] args)
  {
    List<Integer> al=new ArrayList<Integer>();
    for(int i=1;i<5;i++)
      al.add(i);
    System.out.println("数组列表的原始数据"+al);
    ListIterator<Integer> listIter=al.listIterator();
    listIter.add(0);
    System.out.println("添加数据后数组列表"+al);
    if(listIter.hasNext())
    {
      int i=listIter.nextIndex();
      listIter.next();
      listIter.set(9);
      System.out.println("修改数据后数组列表"+al);
    }
    listIter=al.listIterator(al.size());
    System.out.print("反向遍历数组列表：");
    while(listIter.hasPrevious())
      System.out.print(listIter.previous()+"  ");
  }
}
