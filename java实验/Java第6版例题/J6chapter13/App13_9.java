//filename：App13_9.java
@FunctionalInterface
interface StringFunc
{
  public String func(String s);
}
public class App13_9
{
  static String sop(StringFunc sf,String s)
  {
    return sf.func(s);
  }
  public static void main(String[] args)
  {
    String outStr,inStr="Lambda 表达式 good";
    System.out.println("原字符串："+inStr); 
    outStr=sop((str)->str.toUpperCase(),inStr);
    System.out.println("转换为大写字符后："+outStr);
    outStr=sop((str)->{
      String result="";
      for(int i=0;i<str.length();i++)
        if(str.charAt(i)!=' ')
          result+=str.charAt(i);
        return result;
    },inStr);
    System.out.println("去掉空格的字符串："+outStr);
    StringFunc reverse=(str)->{
      String result="";
      for(int i=str.length()-1;i>=0;i--)
        result+=str.charAt(i);
      return result;
    };
    System.out.print("反序后的字符串："+sop(reverse,inStr));  
  }
}
