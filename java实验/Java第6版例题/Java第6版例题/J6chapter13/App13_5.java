//filename：App13_5.java
interface IShape
{
  void shape();
}
class MyType
{
  public void outShape(IShape s)
  {
    s.shape();
  }
}
public class App13_5
{
  public static void main(String[] args)
  {
    MyType a=new MyType();
    a.outShape(new IShape()
      {
       @Override
        public void shape()
        {
          System.out.println("我可以是任何形状");
        }
      }
    );
  }
}
