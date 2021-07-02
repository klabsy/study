//filename£ºApp16_8.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
public class App16_8 extends Application
{
  @Override
  public void start(Stage stage)
  {
    StackPane pane=new StackPane();
    Circle c=new Circle(50);
    c.setStroke(Color.BLUE);
    c.setFill(Color.RED);
    pane.getChildren().add(c);
    FadeTransition ft=new FadeTransition(Duration.millis(2000));
    ft.setFromValue(1.0);
    ft.setToValue(0.0);
    ft.setCycleCount(Animation.INDEFINITE);
    ft.setAutoReverse(true);
    ft.setNode(c);
    ft.play();
    c.setOnMousePressed(e->ft.pause());
    c.setOnMouseReleased(e->ft.play());
    Scene scene=new Scene(pane,200,120);
    stage.setTitle("µ­Èëµ­³ö¶¯»­");
    stage.setScene(scene);
    stage.show();
  }
}
