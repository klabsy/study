//filename£∫App10_6.java
import java.io.*;
public class App10_6
{
  public static void main(String[] args) throws IOException
  {
    FileWriter fw=new FileWriter("d:\\java\\test.txt");
    char[] c={'H','e','l','l','o','\r','\n'};
    String str="ª∂”≠ π”√Java£°";
    fw.write(c);
    fw.write(str);
    fw.close();
  }
}
