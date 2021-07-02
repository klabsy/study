//filename£ºOut.java   Àı13.3
public class Out
{
  private int age;
  public class Student
  {
    String name;
    public Student(String n,int a)
    {
      name=n;
      age=a;
    }
    public void output()
    {
      System.out.println("ĞÕÃû£º"+this.name+"£»ÄêÁä£º"+age);
    }
  }
  public void output()
  {
    Student stu=new Student("Áõ  Ñó",24);
    stu.output();
  }
  public static void main(String[] args)
  {
    Out g=new Out();
    g.output();
  }
}
