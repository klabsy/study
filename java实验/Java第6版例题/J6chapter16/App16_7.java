//filename£ºApp16_7.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
public class App16_7 extends Application
{
  double x1,y1,x2,y2;
  Pane pane=new Pane();
  @Override
  public void start(Stage stage)
  {
    pane.setOnMousePressed(e->handleMousePressed(e));
    pane.setOnMouseDragged(e->handleMouseDragged(e));
    Scene scene=new Scene(pane,300,200);
    stage.setTitle("Êó±êÍÏ¶¯»æÍ¼");
    stage.setScene(scene);
    stage.show();
  }
  protected void handleMousePressed(MouseEvent e)
  {
    x1=e.getX();
    y1=e.getY();
  }
  protected void handleMouseDragged(MouseEvent e)
  {
    x2=e.getSceneX();
    y2=e.getSceneY();
    Line line=new Line(x1,y1,x2,y2);
    pane.getChildren().add(line);
    x1=x2; y1=y2;
  }
}
