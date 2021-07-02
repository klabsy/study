//filename£∫App16_5.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
public class App16_5 extends Application
{
  @Override
  public void start(Stage stage)
  {
    Pane rPane=new Pane();
    Arc arc1=new Arc(150,100,80,80,0,90);
    arc1.setFill(Color.BLUE);
    arc1.setType(ArcType.ROUND);
    Text t1=new Text(210,40,"arc1:ROUND");
    Arc arc2=new Arc(150,100,80,80,120,90);
    arc2.setFill(Color.GREEN);
    arc2.setType(ArcType.OPEN);
    arc2.setStroke(Color.BLACK);
    arc2.setStrokeWidth(3);
    Text t2=new Text(10,70,"arc2:OPEN");
    Arc arc3=new Arc(150,100,80,80,240,90);
    arc3.setFill(Color.RED);
    arc3.setType(ArcType.CHORD);
    arc3.setStroke(Color.BLACK);
    arc3.setStrokeWidth(3);
    Text t3=new Text(210,170,"arc3:CHORD");
    rPane.getChildren().addAll(arc1,arc2,arc3,t1,t2,t3); 
    Scene scene=new Scene(rPane,300,200);
    stage.setTitle("‘≤ª°º∞¿‡–Õ");
    stage.setScene(scene);
    stage.show();
  }
}
