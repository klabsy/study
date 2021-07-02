//filename:App17_21.java
import java.sql.*;
public class App17_21
{
  private static String driver="com.mysql.jdbc.Driver";
  private static String url="jdbc:mysql://localhost/StudentScore?useSSL=false";
  private static String user="root";
  private static String password="";	
  public static void main(String[] args) 
  {
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;	
    String selectSql1="INSERT INTO Student(sNo,sName,sex,age,dept) " +
                   "VALUES('201201010','张三','男',18,'计算机');";
    String selectSql2="INSERT INTO Student(sNo,sName,sex,age,dept) " +
                   "VALUES('201201011','李四','男',19,'会计');";
    String selectSql3="INSERT INTO Student(sNo,sName,sex,age,dept) " +
                   "VALUES('201201001','王五','男',20,'金融');";
    try
    {
      Class.forName(driver);
      conn=DriverManager.getConnection(url,user,password);
      stmt=conn.createStatement();
      boolean autoCommit=conn.getAutoCommit();
      conn.setAutoCommit(false);
      stmt.executeUpdate(selectSql1);
      stmt.executeUpdate(selectSql2);
      stmt.executeUpdate(selectSql3);
      conn.commit();
      conn.setAutoCommit(autoCommit);
    }
    catch(Exception e)
    {
      e.printStackTrace();
      if(conn!=null)
      {
        try 
        {
          conn.rollback();
        }
        catch(SQLException e1)
        {
          e1.printStackTrace();
        }
      }
    }
    finally
    {
      try
      {
        if(stmt!=null) stmt.close();
        if(conn!=null) conn.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
  }
}
