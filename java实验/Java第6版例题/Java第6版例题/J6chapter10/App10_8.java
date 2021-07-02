//filename£ºApp10_8.java
import java.io.*;
public class App10_8
{
  public static void main(String[] args) throws IOException
  {
    String str=new String();
    try(
       BufferedReader in=new BufferedReader(new FileReader("d:/java/test.txt"));
       BufferedWriter out=new BufferedWriter(new FileWriter("d:/java/test1.txt"));
    )
    {
      while ((str=in.readLine())!=null)
      {
        System.out.println(str);
        out.write(str);
        out.newLine();
      }
      out.flush();
     }
    catch (IOException ioe)
    {
      System.out.println("´íÎó! "+ioe);
    }
  }
}
