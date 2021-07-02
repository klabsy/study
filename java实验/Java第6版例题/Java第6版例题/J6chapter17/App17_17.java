//filename:App17_17.java
import java.sql.*;
public class App17_17
{
  private static String driver="com.mysql.jdbc.Driver";
  private static String url="jdbc:mysql://localhost/StudentScore?useSSL=false";
  private static String user="root";
  private static String password="";	
  public static void main(String[] args) 
  {
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    String selectSql="SELECT * FROM Student WHERE dept=?";
    String insertSql="INSERT INTO Student(sNo,sName,sex,age,dept)"+
                   "VALUES(?,?,?,?,?);";
    String updateSql="UPDATE Student SET dept='金融' WHERE sNo=?";
    String deleteSql="DELETE FROM Student WHERE sNo=?";
    try 
    {
      Class.forName(driver);	
      conn=DriverManager.getConnection(url,user,password);
      ps=conn.prepareStatement(selectSql);
      ps.setString(1, "计算机");
      rs=ps.executeQuery();
      while(rs.next())
      {
        String no=rs.getString("sNo");
        String name=rs.getString("sName");
        String sex=rs.getString("sex");
        int age=rs.getInt("age");
        String dept=rs.getString("dept");
        System.out.println(no+"  "+name+"  "+sex+"  "+age+"  "+dept);
      }
      ps=conn.prepareStatement(insertSql);
      ps.setString(1, "201201009");
      ps.setString(2, "王毅");
      ps.setString(3, "男");
      ps.setInt(4, 18);
      ps.setString(5, "外语");
      int count=ps.executeUpdate();
      System.out.println("添加"+ count+"条记录到Student表中");
      ps=conn.prepareStatement(updateSql);
      ps.setString(1, "201201009");
      count=ps.executeUpdate();
      System.out.println("修改了Student表的"+count+"条记录");
      ps=conn.prepareStatement(deleteSql);
      ps.setString(1, "201201009");
      count=ps.executeUpdate();
      System.out.println("删除了Student表的"+count+"条记录");
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      try
      {
        if(rs!=null) rs.close();
        if(ps!=null) ps.close();
        if(conn!=null) conn.close();
      }
      catch(Exception e) 
      {
        e.printStackTrace();
      }
    }
  }
}
