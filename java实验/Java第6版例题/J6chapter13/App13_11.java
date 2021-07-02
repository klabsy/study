//filename£ºApp13_11.java
@FunctionalInterface
interface IShow<T>
{
  public T create(String s,int a);
}
class Person
{
  String name;
  int age;
  Person()
  {
    name="ÁõÑó";
    age=30;
  }
  Person(String name,int age)
  {
    this.name=name;
    this.age=age;
  }
  @Override
  public String toString()
  {
    return "ĞÕÃû£º"+this.name+"£¬ÄêÁä£º"+this.age;
  }
}
public class App13_11
{
  public static void main(String[] args)
  {  
    IShow<Person> na=Person::new;
    Person p=na.create("³ÂÀÚ",32);
    System.out.println(p.toString());
  }
}
