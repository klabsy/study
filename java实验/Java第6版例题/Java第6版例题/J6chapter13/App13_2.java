//filename：App13_2.java
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
class Person
{
  private String name;
  private int age;
  public Person(String name,int age)
  {
    this.name=name;
    this.age=age;
  }
  public void info(String prof,int score)
  {
    System.out.println("我的专业："+prof+"；入学成绩："+score);
  }
  @Override
  public String toString()
  {
    return "姓名："+this.name+",年龄："+this.age;
  }
}
public class App13_2
{
  public static void main(String[] args)   //主方法
  {
    Class<Person> pc=Person.class;
    try
    {
      Constructor con=pc.getConstructor(String.class,int.class);
      System.out.print("构造方法名："+con.getName());
      Class[] pt=con.getParameterTypes();
      for(int i=0;i<pt.length;i++)
        System.out.print("，参数："+pt[i].getName());
    }
    catch(NoSuchMethodException e)
    { e.printStackTrace(); }
    Field[] fls=pc.getDeclaredFields();
    for(Field f:fls)
    {
      int mod=f.getModifiers();
      System.out.print("\n成员变量修饰符："+Modifier.toString(mod));
      Class type=f.getType();
      System.out.print("；名称："+f.getName());
      System.out.print("；类型："+type.getName());
    }
    System.out.println(" ");
    Method[] mds=pc.getMethods();
    for(Method m:mds)
    {
      System.out.print("方法："+m.getName());
      System.out.println(" 参数个数："+m.getParameterCount());
      Parameter[] pars=m.getParameters();
      int index=1;
      for(Parameter p:pars)
      {
        if(p.isNamePresent())
        {
          System.out.println("----第"+(index++)+"个参数的信息----");
          System.out.println("参数名："+p.getName());
          System.out.println("参数类型："+p.getType());
          System.out.println("泛型类型："+p.getParameterizedType());
          System.out.println("----------------------------------------");
        }
      }
    }
  }
}
