//filename：App16_2.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
public class App16_2 extends Application
{
  @Override
  public void start(Stage stage)
  {
    Pane pane=new Pane();
    for(int i=0;i<4;i++)
    {
      Rectangle r=new Rectangle(50,50,80,20); 
      r.setArcWidth(10);
      r.setArcHeight(6);
      r.setRotate(i*360/8);
      r.setStroke(Color.color(Math.random(),Math.random(),Math.random()));
      r.setFill(null);
      pane.getChildren().add(r);
    }
    Scene scene=new Scene(pane,200,130);
    stage.setTitle("矩形程序设计");
    stage.setScene(scene);
    stage.show();
  }
}
