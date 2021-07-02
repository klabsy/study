//filename：App16_9.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
public class App16_9 extends Application
{
  @Override
  public void start(Stage stage)
  {
    Pane pane=new Pane();
    Text t=new Text("您好");
    t.setFont(Font.font(20));
    t.setFill(Color.RED);
    Ellipse elli=new Ellipse(100,60,70,40);
    elli.setFill(Color.WHITE);
    elli.setStroke(Color.BLUE);
    pane.getChildren().addAll(elli,t);
    PathTransition pt=new PathTransition();
    pt.setDuration(Duration.millis(4000));
    pt.setPath(elli);
    pt.setNode(t);
    pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    pt.setCycleCount(Animation.INDEFINITE);
    pt.setAutoReverse(false);
    pt.play();
    elli.setOnMousePressed(e->pt.pause());
    elli.setOnMouseReleased(e->pt.play());
    Scene scene=new Scene(pane,200,120);
    stage.setTitle("移动路径动画");
    stage.setScene(scene);
    stage.show();
  }
}
