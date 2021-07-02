//filename£ºApp6_2.java
class Cylinder
{
  double radius;
  int height;
  double pi=3.14;
  void area()
  {
    System.out.println("µ×Ãæ»ı="+pi* radius* radius);
  }
  double volume()
  {
    return (pi* radius* radius)*height;
  }
}
public class App6_2
{
  public static void main(String[] args)
  {
    Cylinder volu1,volu2;
    volu1=new Cylinder();
    volu2=new Cylinder();
    volu1.radius= volu2.radius=2.5;
    volu2.pi=3;
    System.out.println("Ô²Öù1µ×°ë¾¶="+volu1.radius);
    System.out.println("Ô²Öù2µ×°ë¾¶="+volu2.radius);
    System.out.println("Ô²Öù1µÄpiÖµ="+volu1.pi);
    System.out.println("Ô²Öù2µÄpiÖµ="+volu2.pi);
    System.out.print("Ô²Öù1");
    volu1.area();
    System.out.print("Ô²Öù2");
    volu2.area();
  }
}
