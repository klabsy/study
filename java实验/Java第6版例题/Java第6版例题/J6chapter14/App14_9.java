//filename：App14_9.java
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
public class App14_9
{
  public static void main(String[] args)
  {
    DoubleProperty t1=new SimpleDoubleProperty(6);
    DoubleProperty t2=new SimpleDoubleProperty(9);
    t1.bind(t2);
    System.out.println("t1值="+t1.getValue()+"；t2值="+ t2.getValue());
    t2.setValue(10);
    System.out.println("t1值="+t1.getValue()+"；t2值="+ t2.getValue());
  }
}
