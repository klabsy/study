//filename：App13_1.java
public class App13_1
{
  public String name;
  public int age;
  @Deprecated
  public void show(String name)
  {
    System.out.println(name);
  }
  @Override
  public String toString()
  {
    return "姓名："+name+"  年龄："+age;
  }
  public static void main(String[] args)
  {
    App13_1 p=new App13_1();
    p.show("张三");
  }
}
