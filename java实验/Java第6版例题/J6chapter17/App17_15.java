//filename:App17_15.java
import java.sql.*;
public class App17_15
{
  private static String driver="com.mysql.jdbc.Driver";
  private static String url="jdbc:mysql://localhost/StudentScore?useSSL=false";
  private static String user="root";
  private static String password="";  
  public static void main(String[] args)
 {
      String sql="SELECT sNo,sName,sex,age FROM "+ 
               "Student WHERE dept='¼ÆËã»ú'";
    try( Connection conn=DriverManager.getConnection(url,user,password);
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery(sql);  )
    {
      Class.forName(driver);
      while(rs.next())
      {
        String no=rs.getString("sNo");
        String name=rs.getString("sName");
        String sex=rs.getString("sex");
        int age=rs.getInt("age"); 
        System.out.println(no+"  "+name+"  "+sex+"  "+age);
      }
    }
    catch(Exception e) 
    {
      e.printStackTrace();
    }
  }
}
