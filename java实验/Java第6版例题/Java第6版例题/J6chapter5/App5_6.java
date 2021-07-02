//filename£ºApp5_6.java
public class App5_6
{
  public static void main(String[] args)
  {
    String str="rotor";
    int i=0,n;
    boolean yn=true;
    if (args.length>0)
      str=args[0];
    System.out.println("str="+str);
    n=str.length();
    char sChar,eChar;
    while (yn && (i<n/2))
    {
      sChar=str.charAt(i);
      eChar=str.charAt(n-i-1);
      System.out.println("sChar="+sChar+"  eChar="+eChar);
      if (sChar==eChar)
	i++;
      else
	yn=false;
    }
    System.out.println("Ëã·¨1£º"+yn);
    String temp="",sub1="";
    for (i=0;i<n;i++)
    {
      sub1=str.substring(i,i+1);
      temp=sub1+temp;
    }
    System.out.println("temp="+temp);
    System.out.println("Ëã·¨2£º"+str.equals(temp));
  }
}
