//filename：MyServer.java
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class MyServer implements Runnable
{
  ServerSocket server=null;
  Socket clientSocket;
  boolean flag=true;
  Thread connenThread;
  BufferedReader sin;
  DataOutputStream sout; 
  public static void main(String[] args)
  { 
    MyServer MS=new MyServer();
    MS.serverStart();
  }
  public void serverStart()
  {
    try
    {
      server=new ServerSocket(8080);
      System.out.println("端口号:"+server.getLocalPort());
      while(flag)
      {
        clientSocket=server.accept();
        System.out.println("连接已经建立完毕!");
        InputStream is=clientSocket.getInputStream();
        sin=new BufferedReader(new InputStreamReader(is));
        OutputStream os=clientSocket.getOutputStream();
        sout=new DataOutputStream(os);
        connenThread=new Thread(this);
        connenThread.start();
        String aLine;
        while((aLine=sin.readLine())!=null)
        {                        
          System.out.println(aLine);
          if(aLine.equals("bye"))
          {
            flag=false;
            connenThread.interrupt();
            break;
          }
        }
        sout.close();
        os.close();
        sin.close();
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
          sout.write((byte)ch);
          if(ch=='\n')
            sout.flush();
        }
      }
      catch(Exception e)
      { System.out.println(e); }
    }
  }
}
