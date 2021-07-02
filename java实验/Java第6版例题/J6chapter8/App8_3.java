//filename：App8_3.java 
class Person
{
  protected String name;
  protected int age;
  public Person() {}
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
  int age=20;
  public Student (String xm,String dep)
  {
    name=xm;
    department=dep;
    super.age=25;
    System.out.println("子类Student中的成员变量age="+age);
    super.show();
    System.out.println("系别："+ department );
  }
}
public class App8_3
{
  public static void main(String[] args)
  {
    Student stu=new Student("李小四","信息系");
  }
}
