//filename：App7_13.java
class Person
{
  private String name;
  private int age;
  public Person(String name, int age) 
  {
    this.name=name;
    this.age=age;
  }
  public void show()
  {
    System.out.println("姓名："+name+"  年龄："+age);
  }
}
public class App7_13
{
  public static void main(String[] args)
  {
    Person[] per;
    per=new Person[3];
    per[0]=new Person("张三",20);
    per[1]=new Person("李四",21);
    per[2]=new Person("王二",19);
    per[2].show(); 
    per[0].show();
  }
}
