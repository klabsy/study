//filename：App8_2.java
class Person
{
  private String name; 
  private int age; 
  public Person()
  {
    System.out.println("调用了Person类的无参构造方法");
  }
  public Person(String name, int age)
  {
    System.out.println("调用了Person类的有参构造方法");
    this.name=name;
    this.age=age;
  }
  public void show()
  {
    System.out.println("姓名："+name+"  年龄："+age);
  }
}
class Student extends Person
{
  private String department;
  public Student()
  {
    System.out.println("调用了学生类的无参构造方法Student()");
  }
  public Student (String name,int age,String dep)
  {
    super(name,age);
    department=dep;
    System.out.println("我是"+department +"的学生");
    System.out.println("调用了学生类的有参构造方法Student(String name,int age,String dep) ");
  }
}
public class App8_2
{
  public static void main(String[] args)
  {
    Student stu1=new Student();
    Student stu2=new Student("李小四",23, "信息系");
    stu1.show();
    stu2.show();
  }
}
