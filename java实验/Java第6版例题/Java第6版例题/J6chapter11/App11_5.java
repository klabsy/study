//filename：App11_5.java
class ThreadSale implements Runnable
{
  private int tickets=10;
  public void run()
  {
    while(true)
    {
      if(tickets>0)
        System.out.println(Thread.currentThread().getName()+"售机票第"+tickets--+"号");
      else
        System.exit(0);
    }
  }
}
public class App11_5
{
  public static void main(String[] args)
  {
    ThreadSale t=new ThreadSale();
    Thread t1=new Thread(t, "第1售票窗口");
    Thread t2=new Thread(t, "第2售票窗口");
    Thread t3=new Thread(t, "第3售票窗口");
    t1.start();
    t2.start();
    t3.start();
  }
}
