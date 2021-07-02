//filename：App6_5.java
public class App6_5
{
  public static void main(String[] args)
  {
    int[] a={8,3,7,88,9,23};
    LeastNumb minNumber=new LeastNumb();
    minNumber.least(a);
  }
}
class LeastNumb
{
  public void least(int[] array)
  {
    int temp=array[0];
    for(int i=1;i<array.length;i++)
      if(temp>array[i])
        temp=array[i];
    System.out.println("最小的数为："+temp);
  }
}
