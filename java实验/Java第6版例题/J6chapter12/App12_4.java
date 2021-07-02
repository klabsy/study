//filename：App12_4.java
class GeneralType<T extends Number>
{
  T obj;
  public GeneralType(T obj)
  {
    this.obj=obj;
  }
  public T getObj()
  {
    return obj;
  }
}
public class App12_4 
{
  public static void main(String[] args)
  {
    GeneralType<Integer> num=new GeneralType<Integer>(5);
    System.out.println("给出的参数是："+num. getObj());
    //下面的语句是非法的，因为实际参数String不是Number或Number的子类
    //GeneralType<String> s=new GeneralType<String>("Hello"); 
    //System.out.println("给出的参数是："+s.getObj());
  }
}
