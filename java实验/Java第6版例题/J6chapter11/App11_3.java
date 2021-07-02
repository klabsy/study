//filename：App11_3.java
//将App11_1的MyThread类放在此处
public class App11_3
{
  public static void main(String[] args)
  {
    MyThread you=new MyThread("你");
    MyThread she=new MyThread("她");
    you.start();
    try{
      you.join();
    }
    catch(InterruptedException e) {}
    she.start();
    try{
      she.join();
    }
    catch(InterruptedException e) {}
    System.out.println("主方法main()运行结束！");
  }
}
