//filename：App12_6.java
public class App12_6<T>
{
  private T[] array;
  public void setT(T[] array)
  {
    this.array=array;
  }
  public T[] getT()
  {
    return array;
  }
  public static void main(String[] args)
  {
    App12_6<String> a=new App12_6<String>();
    String[] array={"红色","橙色","黄色","绿色","青色","蓝色","紫色"};
    a.setT(array);
    for(int i=0;i<a.getT().length;i++)
      System.out.print(a.getT()[i]+"  ");
  }
}
