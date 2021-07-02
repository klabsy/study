//filename£ºApp14_8.java
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class App14_8 extends Application
{
  @Override
  public void start(Stage primaryStage)
  {
    Pane pane=new Pane();
    Circle c=new Circle();
    c.setCenterX(100);
    c.setCenterY(100);
    c.centerXProperty().bind(pane.widthProperty().divide(2));
    c.centerYProperty().bind(pane.heightProperty().divide(2));
    c.setRadius(50);
    c.setFill(Color.WHITE);
    pane.getChildren().add(c);
    Scene scene=new Scene(pane,200,200);
    primaryStage.setTitle("Ô²µÄ°ó¶¨ÊôÐÔ");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
