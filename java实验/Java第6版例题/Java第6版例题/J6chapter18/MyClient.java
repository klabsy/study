//filename：MyClient.java
import java.net.*;
import java.io.*;
public class MyClient implements Runnable
{
  Socket clientSocket;
  boolean flag=true;
  Thread connenThread;
  BufferedReader cin;
  DataOutputStream cout;
  public static void main(String[] args)
  { new MyClient().clientStart(); }
  public void clientStart()
  {
    try
    {
      clientSocket=new Socket("localhost",8080);
      System.out.println("已建立连接!");
      while(flag)
      {
        InputStream is=clientSocket.getInputStream();
        cin=new BufferedReader(new InputStreamReader(is));
        OutputStream os=clientSocket.getOutputStream();
        cout=new DataOutputStream(os);
        connenThread=new Thread(this);
        connenThread.start();
        String aLine;
        while((aLine=cin.readLine())!=null)
        {
          System.out.println(aLine);
          if(aLine.equals("bye"))
          {
            flag=false;
            connenThread.interrupt();
            break;
          }
        }
        cout.close();
        os.close();
        cin.close();
        is.close();
        clientSocket.close();
        System.exit(0);	
      }
    }
    catch(Exception e)
    { System.out.println(e); }
  }
  public void run()
  {
    while(true)
    {
      try
      {
        int ch;
        while((ch=System.in.read())!=-1)
        {
          cout.write((byte)ch);
          if(ch=='\n')
            cout.flush();
        }
      }
      catch(Exception e)
      { System.out.println(e); }
    }
  }
}
