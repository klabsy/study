//filename：Person.java    例8.9
public class Person
{
  static int count=0;
  protected String name;
  protected int age;
  public Person(String n1,int a1)
  {
    name=n1;
    age=a1;
    this.count++;
  }
  public String toString()
  {
    return this.name+" , "+this.age;
  }
  public void display()
  {
    System.out.print("本类名="+this.getClass().getName()+"；");
    System.out.println("父类名="+this.getClass().getSuperclass().getName());
    System.out.print("Person.count="+this.count+ "  ");
    System.out.print("Student.count="+Student.count+ "  ");
    Object obj=this;
    if(obj instanceof Student)    //判断对象属于哪个类
      System.out.println(obj.toString()+"是Student类对象。");
    else if(obj instanceof Person)
      System.out.println(obj.toString()+"是Person类对象。");
  }
}
class Student extends Person
{
  static int count=0;
  protected String dept;
  protected Student(String n1,int a1,String d1)
  {
    super(n1,a1);
    dept=d1;
    this.count++;
  }
  public String toString()
  {
    return super.toString()+","+dept;
  }
  public void display()
  {
    super.display();
    System.out.print("super.count="+super.count);
    System.out.println("  ；this.count="+this.count);
  }
  public static void main(String[] args)
  {
    Person per=new Person("王永涛",23);
    per.display();
    Student stu=new Student("张小三",22,"计算机系");
    stu.display();
  }
}
