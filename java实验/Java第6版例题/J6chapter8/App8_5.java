//filename：App8_5.java
class Person
{
  protected String name;
  protected int age;
  public Person(String name, int age)
  {
    this.name=name;
    this.age=age;
  }
  protected void show()
  {
    System.out.println("姓名："+name+"  年龄："+age);
  }
}
class Student extends Person
{
  private String department;
  public Student (String name,int age,String dep)
  {
    super(name,age);
    department=dep;
  }
  protected void show()
  {
    System.out.println("系别："+ department);
  }
  public void subShow()
  {
    System.out.println("我在子类中");
  }
}
public class App8_5
{
  public static void main(String[] args)
  {
    Person per=new Student("王永涛",24, "电子");
    per.show();
    //per.subShow();
  }
}
