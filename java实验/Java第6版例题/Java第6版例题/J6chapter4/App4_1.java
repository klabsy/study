public class App4_1
{
  public static void main(String[] args)
  {
    int a=1,b=2,c=3,max,min;
    if(a>b)
      max=a;
    else
      max=b;
    if(c>max) max=c;
    System.out.println("Max="+max);
    min=a<b ? a : b;
    min=c<min ? c : min;
    System.out.println("Min="+min);
  }
}
