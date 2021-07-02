//filename：App8_4.java
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
}
public class App8_4
{
  public static void main(String[] args)
  {
    Student stu=new Student("王永涛",24, "电子");
    stu.show();
  }
}
