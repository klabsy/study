//filename：App7_14.java
class Person
{
  private String name;
  private int age;
  public Person(String name, int age) 
  {
    this.name=name;
    this.age=age;
  }
  public static int minAge(Person[] p)
  {
    int min=Integer.MAX_VALUE;
    for (int i=0;i<p.length;i++)
      if (p[i].age<min)
        min=p[i].age;
    return min;
  }
}
public class App7_14
{
  public static void main(String[] args)
  {
    Person[] per=new Person[3];
    per[0]=new Person("张三",20);
    per[1]=new Person("李四",21);
    per[2]=new Person("王二",19);
    System.out.println("最小的年龄为："+ Person. minAge(per));
  }
}
