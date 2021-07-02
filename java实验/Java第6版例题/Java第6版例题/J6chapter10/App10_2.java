//filename：App10_2.java
import java.io.*;
public class App10_2
{
  public static void main(String[] args) throws IOException
  {
    try(
      FileInputStream fi=new FileInputStream("风景.jpg");
      FileOutputStream fo=new FileOutputStream("风景1.jpg");
    )
    {
      System.out.println("文件的大小="+fi.available());
      byte[] b=new byte[fi.available()];
      fi.read(b);
      fo.write(b);
      System.out.println("文件已被拷贝并被更名");
    }
  }
}
