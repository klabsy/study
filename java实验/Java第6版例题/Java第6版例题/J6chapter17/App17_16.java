//filename:App17_16.java
import java.sql.*;
public class App17_16
{
  private static String driver="com.mysql.jdbc.Driver";
  private static String url="jdbc:mysql://localhost/StudentScore?useSSL=false";
  private static String user="root";
  private static String password="";	
  public static void main(String[] args) 
  {
    String selectSql="SELECT * FROM Student WHERE dept='计算机'";
    String insertSql="INSERT INTO Student(sNo,sName,sex, age,dept) "+
                  "VALUES('201201009', '王毅','男',18,'外语');";
    String updateSql="UPDATE Student SET dept='金融' WHERE sNo='201201009'";
    String deleteSql="DELETE FROM Student WHERE sNo='201201009'";
    try( Connection conn=DriverManager.getConnection(url,user,password);
         Statement stmt=conn.createStatement();
         ResultSet rs=stmt.executeQuery(selectSql); ) 
    {
      Class.forName(driver);
      while(rs.next())
      {
        String no=rs.getString("sNo");
        String name=rs.getString("sName");
        String sex=rs.getString("sex");
        int age=rs.getInt("age");
        String dept=rs.getString("dept");
        System.out.println(no+"  "+name+"  "+sex+"  "+age+"  "+dept);
      }
      int count=stmt.executeUpdate(insertSql);
      System.out.println("添加"+ count+"条记录到Student表中");
      count=stmt.executeUpdate(updateSql);
      System.out.println("修改了Student表的"+count+"条记录");
      count=stmt.executeUpdate(deleteSql); 
      System.out.println("删除了Student表的"+count+"条记录");
    }
    catch (Exception e) 
    {
      e.printStackTrace();
    }
  }
}
