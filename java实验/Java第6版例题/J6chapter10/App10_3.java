//filename：App10_3.java
import java.io.*;
public class App10_3
{
  public static void main(String[] args)
  {
    try(
      FileOutputStream fout=new FileOutputStream("D:/temp");
      DataOutputStream dout=new DataOutputStream(fout);
    )
    {
      dout.writeInt(10);
      dout.writeLong(12345);
      dout.writeFloat(3.1415926f);
      dout.writeDouble(987654321.123);
      dout.writeBoolean(true);
      dout.writeChars("Goodbye! ");
    }
    catch (IOException e) { }
    try(
      FileInputStream fin=new FileInputStream("D:/temp");
      DataInputStream din=new DataInputStream(fin);
    )
    {
      System.out.println(din.readInt());
      System.out.println(din.readLong());
      System.out.println(din.readFloat());
      System.out.println(din.readDouble());
      System.out.println(din.readBoolean());
      char ch;
      while ((ch=din.readChar())!='\0')
        System.out.print(ch);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("文件未找到！！");
    }
    catch (IOException e) {  }
  }
}
