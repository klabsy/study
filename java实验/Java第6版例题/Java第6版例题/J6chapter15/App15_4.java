//filename：App15_4.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
public class App15_4 extends Application
{
  private double tOffX,tOffY;
  Text t=new Text(20,20,"拖动我");
  @Override
  public void start(Stage stage)
  {
    Pane pane=new Pane();
    pane.getChildren().add(t);
    Scene scene=new Scene(pane,200,100);
    t.setOnMousePressed(e->handleMousePressed(e));
    t.setOnMouseDragged(e->handleMouseDragged(e));
    stage.setTitle("拖动操作");
    stage.setScene(scene);
    stage.show();
  }
  protected void handleMousePressed(MouseEvent e)
  {
    tOffX=e.getSceneX()-t.getX();
    tOffY=e.getSceneY()-t.getY();
  }
  protected void handleMouseDragged(MouseEvent e)
  {
  	 t.setX(e.getSceneX()-tOffX);
  	 t.setY(e.getSceneY()-tOffY);
  }
}
