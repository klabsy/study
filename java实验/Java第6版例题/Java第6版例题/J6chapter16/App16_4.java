//filename£∫App16_4.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
public class App16_4 extends Application
{
  double px,py;
  Pane rPane=new Pane();
  @Override
  public void start(Stage stage)
  {
    rPane.setOnMousePressed(e->handleMousePressed(e));
    rPane.setOnMouseDragged(e->handleMouseDragged(e));
    Scene scene=new Scene(rPane,200,160);
    stage.setTitle("Õœ∂Øª≠Õ÷‘≤");
    stage.setScene(scene);
    stage.show();
  }
  protected void handleMousePressed(MouseEvent e)
  {
    px=e.getX();
    py=e.getY();
  }
  protected void handleMouseDragged(MouseEvent e)
  {
    double rX=Math.abs((e.getSceneX()-px)/2);
    double rY=Math.abs((e.getSceneY()-py)/2);
    Ellipse elli=new Ellipse(px,py,rX,rY);
    elli.setStroke(Color.RED);
    elli.setFill(Color.WHITE);
    rPane.getChildren().add(elli);
  }
}

