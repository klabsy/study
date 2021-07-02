//filename£ºApp4_2.java
public class App4_2
{
  public static void main(String[] args)
  {
    int testScore=86;
    char grade;
    if(testScore>=90) {
      grade='A';
    } else if (testScore>=80) {
      grade='B';
    } else if (testScore>=70) {
      grade='C';
    } else if (testScore>=60) {
      grade='D';
    } else  {
      grade='E';
    }
    System.out.println("ÆÀ¶¨³É¼¨Îª£º"+ grade);
  }
}
